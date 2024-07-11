package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientConsultsDTO
{
    Integer Patient_ID;
    String Patient_first_name;
    String Patient_last_name;
    String Patient_phone;

    public PatientConsultsDTO() {
    }

    public PatientConsultsDTO(Integer patient_ID, String patient_first_name, String patient_last_name, String patient_phone) {
        Patient_ID = patient_ID;
        Patient_first_name = patient_first_name;
        Patient_last_name = patient_last_name;
        Patient_phone = patient_phone;
    }

    public PatientConsultsDTO(ResultSet rs) throws SQLException
    {
        Patient_ID = rs.getInt("Patient_ID");
        Patient_first_name = rs.getString("Patient_first_name");
        Patient_last_name = rs.getString("Patient_last_name");
        Patient_phone = rs.getString("Patient_phone");
    }

    public void setPatient_first_name(String patient_first_name) {
        Patient_first_name = patient_first_name;
    }

    public void setPatient_last_name(String patient_last_name) {
        Patient_last_name = patient_last_name;
    }

    public void setPatient_phone(String patient_phone) {
        Patient_phone = patient_phone;
    }

    public String getPatient_first_name() {
        return Patient_first_name;
    }

    public String getPatient_last_name() {
        return Patient_last_name;
    }

    public String getPatient_phone() {
        return Patient_phone;
    }

    public Integer getPatient_ID() {
        return Patient_ID;
    }

    public void setPatient_ID(Integer patient_ID) {
        Patient_ID = patient_ID;
    }
}
