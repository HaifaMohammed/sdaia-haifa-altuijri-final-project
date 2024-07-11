package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Medical_ReportDTO
{
    Integer Medical_Report_ID;
    LocalDateTime Medical_Report_Date;
    String Diagnose;
    String Treatment;

    public Medical_ReportDTO() {
    }

    public Medical_ReportDTO(ResultSet rs) throws SQLException
    {
        Medical_Report_ID = rs.getInt("Medical_Report_ID");
        Medical_Report_Date = rs.getObject("Medical_Report_Date", LocalDateTime.class);
        Diagnose = rs.getString("Diagnose");
        Treatment = rs.getString("Treatment");
    }

    public Medical_ReportDTO(Integer medical_Report_ID, LocalDateTime medical_Report_Date, String diagnose, String treatment) {
        Medical_Report_ID = medical_Report_ID;
        Medical_Report_Date = medical_Report_Date;
        Diagnose = diagnose;
        Treatment = treatment;
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

}
