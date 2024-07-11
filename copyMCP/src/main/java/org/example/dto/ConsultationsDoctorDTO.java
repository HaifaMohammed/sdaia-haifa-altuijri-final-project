package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ConsultationsDoctorDTO
{
    LocalDateTime Consultation_request_time = LocalDateTime.now();

    PatientConsultsDTO patientConsultsDTO;

    public ConsultationsDoctorDTO() {
    }

    public ConsultationsDoctorDTO(LocalDateTime consultation_request_time, PatientConsultsDTO patientConsultsDTO) {
        Consultation_request_time = consultation_request_time;
        this.patientConsultsDTO = patientConsultsDTO;
    }

    public ConsultationsDoctorDTO(ResultSet rs) throws SQLException
    {
        Consultation_request_time = rs.getObject("Consultation_request_time", LocalDateTime.class);
        this.patientConsultsDTO = new PatientConsultsDTO(
                rs.getInt("Patient_ID"),
                rs.getString("Patient_first_name"),
                rs.getString("Patient_last_name"),
                rs.getString("Patient_phone")
        );
    }

    public LocalDateTime getConsultation_request_time() {
        return Consultation_request_time;
    }

    public PatientConsultsDTO getPatientConsultsDTO() {
        return patientConsultsDTO;
    }

    public void setConsultation_request_time(LocalDateTime consultation_request_time) {
        Consultation_request_time = consultation_request_time;
    }

    public void setPatientConsultsDTO(PatientConsultsDTO patientConsultsDTO) {
        this.patientConsultsDTO = patientConsultsDTO;
    }
}
