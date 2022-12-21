package com.example.workflow.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClaimPeriod {
    Instant startDate;
    Instant endDate;
}
