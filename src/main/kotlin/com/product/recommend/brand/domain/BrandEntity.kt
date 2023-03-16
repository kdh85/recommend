package com.product.recommend.brand.domain

import javax.persistence.*

@Entity
class BrandEntity(
        @Column(nullable = false)
        val title: String
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}