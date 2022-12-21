package com.example.workflow.controller;

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceResult;
import io.camunda.zeebe.spring.client.lifecycle.ZeebeClientLifecycle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Slf4j
@RestController
public class CamundaController {

    private final ZeebeClient zeebeClient;

    private final ZeebeClientLifecycle clientLifecycle;

    @Autowired
    public CamundaController(ZeebeClient zeebeClient, ZeebeClientLifecycle clientLifecycle) {
        this.zeebeClient = zeebeClient;
        this.clientLifecycle = clientLifecycle;
    }

//    private final CamundaService camundaService;
//
//    @Autowired
//    public CamundaController(CamundaService camundaService) {
//        this.camundaService = camundaService;
//    }

    @PostMapping("/evaluate-decision")
    public ResponseEntity<Object> evaluateDecision(@RequestBody Map<String, Object> variables) {
       log.debug("Is client running {}", clientLifecycle.isRunning());
       ProcessInstanceResult result = zeebeClient.newCreateInstanceCommand()
               .bpmnProcessId("Process_0ulqmi2")
               .latestVersion()
               .variables(Map.of("policy_code", "bsc", "claim_type", "room rent"))
               .withResult()
               .send()
               .join();
        return ResponseEntity.ok(result.getVariablesAsMap());
    }
}
