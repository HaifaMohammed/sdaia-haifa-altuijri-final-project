package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorDTO
{
    Integer Doctor_ID;
    String Doctor_first_name;
    String Doctor_last_name;
    String Doctor_specialty;

    public DoctorDTO() {
    }

    public DoctorDTO(ResultSet rs) throws SQLException
    {
        Doctor_ID = rs.getInt("Doctor_ID");
        Doctor_first_name = rs.getString("Doctor_first_name");
        Doctor_last_name = rs.getString("Doctor_last_name");
        Doctor_specialty = rs.getString("Doctor_specialty");
    }

    public DoctorDTO(Integer doctor_ID, String doctor_first_name, String doctor_last_name, String doctor_specialty) {
        Doctor_ID = doctor_ID;
        Doctor_first_name = doctor_first_name;
        Doctor_last_name = doctor_last_name;
        Doctor_specialty = doctor_specialty;
    }

    public void setDoctor_ID(Integer doctor_ID) {
        Doctor_ID = doctor_ID;
    }

    public void setDoctor_specialty(String doctor_specialty) {
        Doctor_specialty = doctor_specialty;
    }

    public void setDoctor_first_name(String doctor_first_name) {
        Doctor_first_name = doctor_first_name;
    }

    public void setDoctor_last_name(String doctor_last_name) {
        Doctor_last_name = doctor_last_name;
    }

    public Integer getDoctor_ID() {
        return Doctor_ID;
    }

    public String getDoctor_specialty() {
        return Doctor_specialty;
    }

    public String getDoctor_first_name() {
        return Doctor_first_name;
    }

    public String getDoctor_last_name() {
        return Doctor_last_name;
    }
}
