package com.product.recommend.brand.domain

import com.product.recommend.brand.repository.BrandRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class BrandRepositoryTest(@Autowired
                     private val brandRepository: BrandRepository) {

    private var saveBrand = BrandEntity("test_title")


    @BeforeEach
    fun setUp() {
        saveBrand = brandRepository.save(BrandEntity("test_title"))

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
        findBrand?.modifyTitle("modify-title")

        val expected = brandRepository.findByIdOrNull(findBrand?.id)
        println(expected)
        assertEquals(expected?.title, "modify-title")
    }

    @Test
    fun deleteTest() {
        brandRepository.delete(saveBrand)

        val findBrand = saveBrand.id?.let { brandRepository.findByIdOrNull(it) }
        assertNull(findBrand)
    }
}