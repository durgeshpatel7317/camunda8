package com.example.workflow.controller;

import com.example.workflow.model.Policy;
import com.example.workflow.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class PolicyController {

    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping("/policies")
    public ResponseEntity<Object> createNewPolicy(@RequestBody Policy policy) {
        Policy savedPolicy = policyService.createNewPolicy(policy);

        if (savedPolicy != null) {
            return ResponseEntity.ok(Map.of("message", "Policy created successfully..!"));
        }

        return ResponseEntity.badRequest().body(Map.of("message", "Policy can not be created, please check details and try again"));
    }
}
