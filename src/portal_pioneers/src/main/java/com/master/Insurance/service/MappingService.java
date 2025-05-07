package com.master.Insurance.service;

import com.master.Insurance.entity.ProductInsuranceMapping;
import com.master.Insurance.exception.ResourceNotFoundException;
import com.master.Insurance.repository.ProductProviderMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MappingService {
    @Autowired
    private ProductProviderMappingRepository mappingRepository;

    public List<ProductInsuranceMapping> getAllMappings() {
        return mappingRepository.findAll();
    }

    public ProductInsuranceMapping getMappingById(Long id) throws ResourceNotFoundException {
        return mappingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mapping not found"));
    }

    public ProductInsuranceMapping createMapping(ProductInsuranceMapping mapping) {
        return mappingRepository.save(mapping);
    }

    public ProductInsuranceMapping updateMapping(Long id, ProductInsuranceMapping mappingDetails) throws ResourceNotFoundException {
        ProductInsuranceMapping mapping = getMappingById(id);
        mapping.setUrl(mappingDetails.getUrl());
        mapping.setRequestJson(mappingDetails.getRequestJson());
        mapping.setResponseJson(mappingDetails.getResponseJson());
        mapping.setCountry(mappingDetails.getCountry());
        return mappingRepository.save(mapping);
    }

    public void deleteMapping(Long id) throws ResourceNotFoundException {
        ProductInsuranceMapping mapping = getMappingById(id);
        mappingRepository.delete(mapping);
    }

    public void setActiveOrInactive(Long productId, Long insuranceId, boolean isActive) throws ResourceNotFoundException {
        Optional<ProductInsuranceMapping> mapping = mappingRepository.findByProductIdAndInsuranceId(productId, insuranceId);
        if (mapping.isPresent()) {
            ProductInsuranceMapping existingMapping = mapping.get();
            mappingRepository.save(existingMapping);
        } else {
            throw new ResourceNotFoundException("Mapping not found");
        }
    }
}

