package com.product.recommend.product.domain

import com.product.recommend.brand.domain.BaseEntity
import com.product.recommend.brand.domain.BrandEntity
import com.product.recommend.brand.enums.ProductCategory
import javax.persistence.*

@Entity
class ProductEntity(
        @Column(nullable = false)
        var name: String,
        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        var category: ProductCategory,
        @ManyToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        @JoinColumn(name = "brand_id", nullable = false, foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
        var brandEntity: BrandEntity
) : BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    companion object {
        fun of(name: String, category: ProductCategory, brandEntity: BrandEntity): ProductEntity {
            val productEntity = ProductEntity(name, category, brandEntity)
            brandEntity.addProduct(productEntity)
            return productEntity
        }
    }

    fun modify(changeName: String, changeCategory: ProductCategory) {
        this.name = changeName
        this.category = changeCategory
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProductEntity

        if (name != other.name) return false
        if (category != other.category) return false
        if (brandEntity != other.brandEntity) return false
        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + category.hashCode()
        result = 31 * result + brandEntity.hashCode()
        result = 31 * result + (id?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "ProductEntity(name='$name', category=$category, brandEntity=$brandEntity, id=$id)"
    }


}