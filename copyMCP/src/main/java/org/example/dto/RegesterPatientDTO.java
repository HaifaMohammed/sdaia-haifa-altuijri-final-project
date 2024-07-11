package org.example.dto;

public class RegesterPatientDTO
{
    Integer Patient_ID;
    String Patient_first_name;
    String Patient_last_name;

    public RegesterPatientDTO() {
    }

    public RegesterPatientDTO(Integer patient_ID, String patient_first_name, String patient_last_name) {
        Patient_ID = patient_ID;
        Patient_first_name = patient_first_name;
        Patient_last_name = patient_last_name;
    }

    public void setPatient_ID(Integer patient_ID) {
        Patient_ID = patient_ID;
    }

    public void setPatient_first_name(String patient_first_name) {
        Patient_first_name = patient_first_name;
    }

    public void setPatient_last_name(String patient_last_name) {
        Patient_last_name = patient_last_name;
    }

    public Integer getPatient_ID() {
        return Patient_ID;
    }

    public String getPatient_first_name() {
        return Patient_first_name;
    }

    public String getPatient_last_name() {
        return Patient_last_name;
    }
}
