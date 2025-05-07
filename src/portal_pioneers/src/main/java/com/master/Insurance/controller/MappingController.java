package com.master.Insurance.controller;

import com.master.Insurance.entity.ProductInsuranceMapping;
import com.master.Insurance.exception.ResourceNotFoundException;
import com.master.Insurance.service.MappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mappings")
public class MappingController {
    @Autowired
    private MappingService mappingService;

    @GetMapping
    public List<ProductInsuranceMapping> getAllMappings() {
        return mappingService.getAllMappings();
    }

    @GetMapping("/{id}")
    public ProductInsuranceMapping getMapping(@PathVariable Long id) throws ResourceNotFoundException {
        return mappingService.getMappingById(id);
    }

    @PostMapping
    public ProductInsuranceMapping createMapping(@RequestBody ProductInsuranceMapping mapping) {
        return mappingService.createMapping(mapping);
    }

    @PutMapping("/{id}")
    public ProductInsuranceMapping updateMapping(@PathVariable Long id, @RequestBody ProductInsuranceMapping mapping) throws ResourceNotFoundException {
        return mappingService.updateMapping(id, mapping);
    }

    @DeleteMapping("/{id}")
    public void deleteMapping(@PathVariable Long id) throws ResourceNotFoundException {
        mappingService.deleteMapping(id);
    }

    @PutMapping("/activate")
    public void setActiveOrInactive(@RequestParam Long productId, @RequestParam Long insuranceId, @RequestParam boolean isActive) throws ResourceNotFoundException {
        mappingService.setActiveOrInactive(productId, insuranceId, isActive);
    }
}

