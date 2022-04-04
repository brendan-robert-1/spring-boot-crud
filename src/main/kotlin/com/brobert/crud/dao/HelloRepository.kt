package com.brobert.crud.dao

import com.brobert.crud.model.entity.HelloEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

@Repository
interface HelloRepository : JpaRepository<HelloEntity, Long> {

    @Transactional(readOnly = true)
    fun findByHelloId(helloId: String) : Optional<HelloEntity>
}
