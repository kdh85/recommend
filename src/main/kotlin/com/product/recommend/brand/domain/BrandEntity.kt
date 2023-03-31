package com.product.recommend.brand.domain

import com.product.recommend.product.domain.ProductEntity
import javax.persistence.*

@Entity
class BrandEntity(
        @Column(nullable = false)
        var title: String,
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandEntity", cascade = [CascadeType.ALL])
        var products: MutableList<ProductEntity> = mutableListOf()
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    fun modifyBrand(modifyTitle: String) {
        this.title = modifyTitle
    }

    fun addProduct(productEntity: ProductEntity) {
        this.products.add(productEntity)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BrandEntity

        if (title != other.title) return false
        if (products != other.products) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + products.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "BrandEntity(title='$title', id=$id)"
    }

}