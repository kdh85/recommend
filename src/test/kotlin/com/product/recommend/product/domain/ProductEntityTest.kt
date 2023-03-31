package com.product.recommend.product.domain

import com.product.recommend.brand.domain.BrandEntity
import com.product.recommend.brand.enums.ProductCategory
import com.product.recommend.product.repository.ProductRepository
import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class ProductEntityTest(
        @Autowired
        private val productRepository: ProductRepository
) {

    private var saveProduct: ProductEntity = ProductEntity.of("A", ProductCategory.KEYBOARD, BrandEntity("brandA"))

    @BeforeEach
    fun setUp() {
        saveProduct = productRepository.save(saveProduct)
    }

    @Test
    fun createTest() {
        val brand = BrandEntity("brandB")
        val saveProduct = productRepository.save(ProductEntity.of("AAA", ProductCategory.KEYBOARD, brand))

        assertEquals(saveProduct.brandEntity, brand)
    }

    @Test
    fun selectTest() {
        val findProduct = productRepository.findByIdOrNull(saveProduct.id)

        assertEquals(saveProduct, findProduct)
    }

    @Test
    fun modifyTest() {
        val findProduct = productRepository.findByIdOrNull(saveProduct.id)

        findProduct?.modify("BBB", ProductCategory.HEAD_SET)

        findProduct?.let {
            assertAll(
                    { assertEquals(it.name, "BBB") },
                    { assertEquals(it.category, ProductCategory.HEAD_SET) }
            )
        }
    }
}