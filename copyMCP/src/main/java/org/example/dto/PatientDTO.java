package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class PatientDTO
{
    Integer Patient_ID;
    String Patient_first_name;
    String Patient_last_name;
    String Patient_phone;
    LocalDate Patient_Date_of_birth;
    String Patient_weight;
    String Patient_Gender;

    public PatientDTO() {
    }

    public PatientDTO(ResultSet rs) throws SQLException
    {
        Patient_ID = rs.getInt("Patient_ID");
        Patient_first_name = rs.getString("Patient_first_name");
        Patient_last_name = rs.getString("Patient_last_name");
        Patient_phone = rs.getString("Patient_phone");
        Patient_Date_of_birth = rs.getObject("Patient_Date_of_birth", LocalDate.class);
        Patient_weight = rs.getString("Patient_weight");
        Patient_Gender = rs.getString("Patient_Gender");
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

    public void setPatient_phone(String patient_phone) {
        Patient_phone = patient_phone;
    }

    public void setPatient_Date_of_birth(LocalDate patient_Date_of_birth) {
        Patient_Date_of_birth = patient_Date_of_birth;
    }

    public void setPatient_weight(String patient_weight) {
        Patient_weight = patient_weight;
    }

    public void setPatient_Gender(String patient_Gender) {
        Patient_Gender = patient_Gender;
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

    public String getPatient_phone() {
        return Patient_phone;
    }

    public LocalDate getPatient_Date_of_birth() {
        return Patient_Date_of_birth;
    }

    public String getPatient_weight() {
        return Patient_weight;
    }

    public String getPatient_Gender() {
        return Patient_Gender;
    }
}
