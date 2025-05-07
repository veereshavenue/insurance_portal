package com.master.Insurance.controller;

import com.master.Insurance.entity.Provider;
import com.master.Insurance.exception.ResourceNotFoundException;
import com.master.Insurance.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {
    @Autowired
    private ProviderService insuranceService;

    @GetMapping
    public List<Provider> getAllInsurances() {
        return insuranceService.getAllInsurances();
    }

    @GetMapping("/{id}")
    public Provider getInsurance(@PathVariable Long id) throws ResourceNotFoundException {
        return insuranceService.getInsuranceById(id);
    }

    @PostMapping
    public Provider createInsurance(@RequestBody Provider insurance) {
        return insuranceService.createInsurance(insurance);
    }

    @PutMapping("/{id}")
    public Provider updateInsurance(@PathVariable Long id, @RequestBody Provider insurance) throws ResourceNotFoundException {
        return insuranceService.updateInsurance(id, insurance);
    }

    @DeleteMapping("/{id}")
    public void deleteInsurance(@PathVariable Long id) throws ResourceNotFoundException {
        insuranceService.deleteInsurance(id);
    }
}

