package com.microservices.Abono.Application.Dto;

import lombok.Getter;
/**
 * Represents a patient in the system.
 * This class holds the patient's name.
 */
@Getter
public class Patient {

    private String patientName;

    public Patient() {
    }

    public Patient(String patientName) {
        this.patientName = patientName;
    }
}
