package com.example.workflow.service;

import com.example.workflow.model.Policy;
import com.example.workflow.repo.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@Service
public class PolicyService {
    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public Policy createNewPolicy(Policy policy) {
        Policy policyToSave = Policy.builder()
                .id(UUID.randomUUID())
                .code(policy.getCode())
                .holderName(policy.getHolderName())
                .startDate(Instant.now())
                .endDate(Instant.now().plus(365, ChronoUnit.DAYS))
                .build();

        return policyRepository.save(policyToSave);
    }
}
