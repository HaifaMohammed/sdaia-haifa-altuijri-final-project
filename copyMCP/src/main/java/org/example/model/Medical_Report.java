package org.example.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Medical_Report
{
    Integer Medical_Report_ID;
    LocalDateTime Medical_Report_Date;
    String Diagnose;
    String Treatment;
    Integer Doctor_ID;
    Integer Patient_ID;

    public Medical_Report() {
    }

    public Medical_Report(ResultSet rs) throws SQLException
    {
        Medical_Report_ID = rs.getInt("Medical_Report_ID");
        Medical_Report_Date = rs.getObject("Medical_Report_Date", LocalDateTime.class);
        Diagnose = rs.getString("Diagnose");
        Treatment = rs.getString("Treatment");
        Doctor_ID = rs.getInt("Doctor_ID");
        Patient_ID = rs.getInt("Patient_ID");
    }

    public void setMedical_Report_ID(Integer medical_Report_ID) {
        Medical_Report_ID = medical_Report_ID;
    }

    public void setMedical_Report_Date(LocalDateTime medical_Report_Date) {
        Medical_Report_Date = medical_Report_Date;
    }

    public void setDiagnose(String diagnose) {
        Diagnose = diagnose;
    }

    public void setTreatment(String treatment) {
        Treatment = treatment;
    }

    public void setDoctor_ID(Integer doctor_ID) {
        Doctor_ID = doctor_ID;
    }

    public void setPatient_ID(Integer patient_ID) {
        Patient_ID = patient_ID;
    }

    public Integer getMedical_Report_ID() {
        return Medical_Report_ID;
    }

    public LocalDateTime getMedical_Report_Date() {
        return Medical_Report_Date;
    }

    public String getDiagnose() {
        return Diagnose;
    }

    public String getTreatment() {
        return Treatment;
    }

    public Integer getDoctor_ID() {
        return Doctor_ID;
    }

    public Integer getPatient_ID() {
        return Patient_ID;
    }
}
