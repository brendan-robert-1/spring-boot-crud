function handle_lint {
  ./gradlew ktlintFormat
  ./gradlew ktlintCheck
}

function handle_up {
  ./gradlew build -x test
  podman-compose -f docker/local/docker-compose.yaml up -d postgres
  podman-compose -f docker/local/docker-compose.yaml build "$1"
  podman-compose -f docker/local/docker-compose.yaml up -d --force-recreate --no-deps "$1"
  handle_ps
  podman logs -f "$1"
}

function handle_ps {
  echo
  podman ps -a --format "table {{.Names}}\t{{.Status}}\t{{.Ports}}"
  echo
}

function handle_run {
    podman stop $1 1>/dev/null 2>/dev/null
    podman-compose -f docker/local/docker-compose.yaml up -d postgres
    ./gradlew bootRun
}

function handle_prune {
  podman system prune -f
  podman volume prune -f
  git fetch --prune
}

function handle_input {
  case $1 in
      l) handle_lint ;;
      up) handle_up "$2" ;;
      p) handle_prune ;;
      r) handle_run "$2";;
  esac
}

handle_input "$1" crud