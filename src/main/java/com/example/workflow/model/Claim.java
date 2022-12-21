package com.example.workflow.model;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.UUID;

@Entity
@Table
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder(toBuilder = true)
public class Claim {
    @Id
    @Type(type = "uuid-char")
    UUID id;
    String type;
    Instant date;
    @Type(type = "uuid-char")
    UUID policyId;
    @Type(type = "json")
    @Column(columnDefinition = "json", nullable = false)
    ClaimPeriod claimPeriod;

}
