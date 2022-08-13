package com.brobert.crud.dao

import com.brobert.crud.model.entity.HelloEntity
import org.springframework.stereotype.Component
import java.util.Optional

// @Repository
@Component
interface HelloRepository /*: JpaRepository<HelloEntity, Long>*/ {

    // @Transactional(readOnly = true)
    fun findByHelloId(helloId: String): Optional<HelloEntity>
}
