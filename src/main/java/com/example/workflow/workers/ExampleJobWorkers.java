package com.example.workflow.workers;

import io.camunda.zeebe.client.api.response.ActivatedJob;
import io.camunda.zeebe.spring.client.annotation.JobWorker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

@Slf4j
@Component
public class ExampleJobWorkers {
    @JobWorker(type = "foo", fetchAllVariables = true) // type is set to method name: "bar".
    public Map<String, Object> bar(final ActivatedJob job) {
        Map<String, Object> variables = job.getVariablesAsMap();
        return Collections.singletonMap("someResult", 2 + 1);
    }
}
