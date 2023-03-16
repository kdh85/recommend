package com.product.recommend.brand.repository

import com.product.recommend.brand.domain.BrandEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BrandRepository : JpaRepository<BrandEntity, Long> {
}