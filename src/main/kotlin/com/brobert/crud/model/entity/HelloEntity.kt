package com.brobert.crud.model.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="hello")
data class HelloEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val pk: Long? = null,

    @Column
    var helloId: String? = null,

    @Column
    var message: String? = null
)
