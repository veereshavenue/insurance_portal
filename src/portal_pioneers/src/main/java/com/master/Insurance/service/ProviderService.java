package com.master.Insurance.service;

import com.master.Insurance.entity.Provider;
import com.master.Insurance.exception.ResourceNotFoundException;
import com.master.Insurance.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderRepository insuranceRepository;

    public List<Provider> getAllInsurances() {
        return insuranceRepository.findAll();
    }

    public Provider getInsuranceById(Long id) throws ResourceNotFoundException {
        return insuranceRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Insurance not found"));
    }

    public Provider createInsurance(Provider insurance) {
        return insuranceRepository.save(insurance);
    }

    public Provider updateInsurance(Long id, Provider insuranceDetails) throws ResourceNotFoundException {
        Provider insurance = getInsuranceById(id);
        insurance.setName(insuranceDetails.getName());
        return insuranceRepository.save(insurance);
    }

    public void deleteInsurance(Long id) throws ResourceNotFoundException {
        Provider insurance = getInsuranceById(id);
        insuranceRepository.delete(insurance);
    }
}

