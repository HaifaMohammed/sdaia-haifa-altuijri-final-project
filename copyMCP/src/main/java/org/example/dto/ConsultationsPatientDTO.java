package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultationsPatientDTO
{
    String Consulting_status;

    DoctorDTO doctorConsultsDTO;

    public ConsultationsPatientDTO() {
    }

    public ConsultationsPatientDTO(String consulting_status, DoctorDTO doctorConsultsDTO) {
        Consulting_status = consulting_status;
        this.doctorConsultsDTO = doctorConsultsDTO;
    }

    public ConsultationsPatientDTO(ResultSet rs) throws SQLException
    {
        Consulting_status = rs.getString("Consulting_status");
        this.doctorConsultsDTO = new DoctorDTO(
                rs.getInt("Doctor_ID"),
                rs.getString("Doctor_first_name"),
                rs.getString("Doctor_last_name"),
                rs.getString("Doctor_specialty")
        );
    }

    public String getConsulting_status() {
        return Consulting_status;
    }

    public DoctorDTO getDoctorConsultsDTO() {
        return doctorConsultsDTO;
    }

    public void setConsulting_status(String consulting_status) {
        Consulting_status = consulting_status;
    }

    public void setDoctorConsultsDTO(DoctorDTO doctorConsultsDTO) {
        this.doctorConsultsDTO = doctorConsultsDTO;
    }
}
