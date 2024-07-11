package org.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class Consultations
{
    Integer Consultation_ID;
    LocalDateTime Consultation_request_time = LocalDateTime.now();
    String Consulting_status;
    Integer Doctor_ID;
    Integer Patient_ID;
    Integer Rate;

    public Consultations() {
    }

    public Consultations(ResultSet rs) throws SQLException
    {
        Consultation_ID = rs.getInt("Consultation_ID");
        Consultation_request_time = rs.getTimestamp("Consultation_request_time").toLocalDateTime();
        Consulting_status = rs.getString("Consulting_status");
        Doctor_ID = rs.getInt("Doctor_ID");
        Patient_ID = rs.getInt("Patient_ID");
        Rate = rs.getInt("Rate");
    }

    public Integer getRate() {
        return Rate;
    }

    public void setRate(Integer rate) {
        Rate = rate;
    }

    public void setConsultation_ID(Integer consultation_ID) {
        Consultation_ID = consultation_ID;
    }

    public void setConsultation_request_time(LocalDateTime consultation_request_time) {
        Consultation_request_time = consultation_request_time;
    }

    public void setConsulting_status(String consulting_status) {
        Consulting_status = consulting_status;
    }

    public void setDoctor_ID(Integer doctor_ID) {
        Doctor_ID = doctor_ID;
    }

    public void setPatient_ID(Integer patient_ID) {
        Patient_ID = patient_ID;
    }

    public Integer getConsultation_ID() {
        return Consultation_ID;
    }

    public LocalDateTime getConsultation_request_time() {
        return Consultation_request_time;
    }

    public String getConsulting_status() {
        return Consulting_status;
    }

    public Integer getDoctor_ID() {
        return Doctor_ID;
    }

    public Integer getPatient_ID() {
        return Patient_ID;
    }
}
