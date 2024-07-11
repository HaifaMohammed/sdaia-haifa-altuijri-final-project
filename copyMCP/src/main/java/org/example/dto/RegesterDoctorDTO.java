package org.example.dto;

public class RegesterDoctorDTO
{
    Integer Doctor_ID;
    String Doctor_first_name;
    String Doctor_last_name;

    public RegesterDoctorDTO() {
    }

    public RegesterDoctorDTO(Integer doctor_ID, String doctor_first_name, String doctor_last_name) {
        Doctor_ID = doctor_ID;
        Doctor_first_name = doctor_first_name;
        Doctor_last_name = doctor_last_name;
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

    public Integer getDoctor_ID() {
        return Doctor_ID;
    }

    public String getDoctor_first_name() {
        return Doctor_first_name;
    }

    public String getDoctor_last_name() {
        return Doctor_last_name;
    }
}
