package com.product.recommend.brand.domain

import com.product.recommend.brand.enums.ProductCategory
import javax.persistence.*

@Entity
class BrandEntity(
        @Column(nullable = false)
        var title: String,
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        var category: ProductCategory
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun modifyBrand(modifyTitle: String, modifyCategory: ProductCategory) {
        this.title = modifyTitle
        this.category = modifyCategory
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