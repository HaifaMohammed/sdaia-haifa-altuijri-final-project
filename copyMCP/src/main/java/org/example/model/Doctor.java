package org.example.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Doctor
{
    Integer Doctor_ID;
    String Doctor_first_name;
    String Doctor_last_name;
    String Doctor_specialty;
    String Doctor_email;
    String Doctor_password;
    String Doctor_phone;

    public Doctor() {
    }

    public Doctor(ResultSet rs) throws SQLException
    {
        Doctor_ID = rs.getInt("Doctor_ID");
        Doctor_first_name = rs.getString("Doctor_first_name");
        Doctor_last_name = rs.getString("Doctor_last_name");
        Doctor_specialty = rs.getString("Doctor_specialty");
        Doctor_email = rs.getString("Doctor_email");
        Doctor_password = rs.getString("Doctor_password");
        Doctor_phone = rs.getString("Doctor_phone");
    }

    public void setDoctor_ID(Integer doctor_ID) {
        Doctor_ID = doctor_ID;
    }

    public void setDoctor_first_name(String doctor_first_name) {
        Doctor_first_name = doctor_first_name;
    }

    public void setDoctor_last_name(String doctor_last_name) {
        Doctor_last_name = doctor_last_name;
    }

    public void setDoctor_specialty(String doctor_specialty) {
        Doctor_specialty = doctor_specialty;
    }

    public void setDoctor_email(String doctor_email) {
        Doctor_email = doctor_email;
    }

    public void setDoctor_password(String doctor_password) {
        Doctor_password = doctor_password;
    }

    public void setDoctor_phone(String doctor_phone) {
        Doctor_phone = doctor_phone;
    }

    public Integer getDoctor_ID() {
        return Doctor_ID;
    }

    public String getDoctor_first_name() {
        return Doctor_first_name;
    }

    public String getDoctor_last_name() {
        return Doctor_last_name;
    }

    public String getDoctor_specialty() {
        return Doctor_specialty;
    }

    public String getDoctor_email() {
        return Doctor_email;
    }

    public String getDoctor_password() {
        return Doctor_password;
    }

    public String getDoctor_phone() {
        return Doctor_phone;
    }

}
