package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class ConsultationsDTO
{
    Integer Consultation_ID;
    String Consulting_status;
    int Rate;

    public ConsultationsDTO() {
    }

    public ConsultationsDTO(Integer consultation_ID, String consulting_status, int rate) {
        Consultation_ID = consultation_ID;
        Consulting_status = consulting_status;
        Rate = rate;
    }

    public ConsultationsDTO(ResultSet rs) throws SQLException
    {
        Consultation_ID = rs.getInt("Consultation_ID");
        Consulting_status = rs.getString("Consulting_status");
        Rate = rs.getInt("Rate");
    }

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public void setConsultation_ID(Integer consultation_ID) {
        Consultation_ID = consultation_ID;
    }

    public void setConsulting_status(String consulting_status) {
        Consulting_status = consulting_status;
    }

    public Integer getConsultation_ID() {
        return Consultation_ID;
    }

    public String getConsulting_status() {
        return Consulting_status;
    }

}
