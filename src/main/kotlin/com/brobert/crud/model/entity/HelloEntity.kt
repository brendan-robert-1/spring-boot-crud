package com.brobert.crud.model.entity

// @Entity
// @Table(name="hello")
data class HelloEntity(
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    val pk: Long? = null,

    // @Column
    var helloId: String? = null,

    // @Column
    var message: String? = null
)
