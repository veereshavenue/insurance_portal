package com.master.Insurance.repository;

import com.master.Insurance.entity.ProductInsuranceMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductProviderMappingRepository extends JpaRepository<ProductInsuranceMapping, Long> {
    Optional<ProductInsuranceMapping> findByProductIdAndInsuranceId(Long productId, Long insuranceId);
}

