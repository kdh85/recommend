package com.product.recommend.brand.domain

import com.product.recommend.brand.repository.BrandRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest
class BaseEntityTest(@Autowired
                     private val brandRepository: BrandRepository) {

    @Test
    fun createTest() {
        var brandEntity = BrandEntity("title")
        val save = brandRepository.save(brandEntity)

        assertEquals(save.title, brandEntity.title)
    }
}