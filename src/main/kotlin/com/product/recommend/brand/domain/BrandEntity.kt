package com.product.recommend.brand.domain

import javax.persistence.*

@Entity
class BrandEntity(
        @Column(nullable = false)
        var title: String
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun modifyTitle(modifyTitle: String){
        this.title = modifyTitle
    }

    override fun toString(): String {
        return "BrandEntity(title='$title', id=$id)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BrandEntity

        if (title != other.title) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        return result
    }

}