package com.product.recommend.brand.domain

import com.product.recommend.brand.repository.BrandRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class BrandEntityTest(
        @Autowired
        private val brandRepository: BrandRepository) {

    private var saveBrand: BrandEntity = BrandEntity("test_title")

    @BeforeEach
    fun setUp() {
        saveBrand = brandRepository.save(saveBrand)
    }

    @Test
    fun createTest() {
        val brandEntity = BrandEntity("title")
        val save = brandRepository.save(brandEntity)

        assertEquals(save.title, brandEntity.title)
    }

    @Test
    fun findByIdTest() {
        val findBrand = saveBrand.id?.let { brandRepository.findByIdOrNull(it) }
        assertEquals(saveBrand, findBrand)
    }

    @Test
    fun modifyTest() {

        val findBrand = saveBrand.id?.let { brandRepository.findByIdOrNull(it) }
        findBrand?.modifyBrand("modify-title")

        val expected = brandRepository.findByIdOrNull(findBrand?.id)

        assertEquals(expected?.title, "modify-title")
    }

    @Test
    fun deleteTest() {
        brandRepository.delete(saveBrand)

        val findBrand = saveBrand.id?.let { brandRepository.findByIdOrNull(it) }
        assertNull(findBrand)
    }
}