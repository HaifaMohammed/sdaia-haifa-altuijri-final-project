package org.example.dao;

import org.example.connection.McpConnection;
import org.example.dto.ConsultationsDTO;
import org.example.dto.ConsultationsDoctorDTO;
import org.example.dto.ConsultationsPatientDTO;
import org.example.model.Consultations;

import java.sql.*;
import java.util.ArrayList;

public class ConsultationsDAO
{
    public ArrayList<ConsultationsDTO> selectAllConsults() throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select * from Consultations;");

        ResultSet rs = st.executeQuery();
        ArrayList<ConsultationsDTO> consultations = new ArrayList<>();

        while (rs.next()) {
            consultations.add(new ConsultationsDTO(rs));
        }
        return consultations;
    }

    public ArrayList<ConsultationsDoctorDTO> selectAllDoctorConsults(Integer doctorID) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select Consultations.Consultation_request_time, PATIENT.Patient_ID, PATIENT.Patient_first_name, PATIENT.Patient_last_name, PATIENT.Patient_phone from Consultations join PATIENT on Consultations.Patient_ID = PATIENT.Patient_ID where Consultations.Doctor_ID = ? and Consultations.Consulting_status = 'Pending';");

        st.setInt(1, doctorID);

        ResultSet rs = st.executeQuery();
        ArrayList<ConsultationsDoctorDTO> consultations = new ArrayList<>();

        while (rs.next()) {
            consultations.add(new ConsultationsDoctorDTO(rs));
        }
        return consultations;
    }

    public ArrayList<ConsultationsPatientDTO> selectAllPatientConsults(Integer patientID) throws SQLException, ClassNotFoundException {


        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select Consultations.Consulting_status, DOCTOR.Doctor_ID, DOCTOR.Doctor_first_name, DOCTOR.Doctor_last_name, DOCTOR.Doctor_specialty from Consultations join DOCTOR on Consultations.Doctor_ID = DOCTOR.Doctor_ID where Consultations.Patient_ID = ?;");

        st.setInt(1, patientID);

        ResultSet rs = st.executeQuery();
        ArrayList<ConsultationsPatientDTO> consultations = new ArrayList<>();

        while (rs.next()) {
            consultations.add(new ConsultationsPatientDTO(rs));
        }
        return consultations;
    }

    public void insertConsultation(Consultations consultations) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();

        Timestamp current = new Timestamp(System.currentTimeMillis());

        PreparedStatement st = conn.prepareStatement("insert into Consultations (Consultation_request_time, Consulting_status, Doctor_ID, Patient_ID, Rate) values (?, 'Pending', ?, ?, null);");

        st.setTimestamp(1, current);
        st.setInt(2, consultations.getDoctor_ID());
        st.setInt(3, consultations.getPatient_ID());

        st.executeUpdate();
    }

    public void updateConsultationStatus(ConsultationsDTO consultationsDTO) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("UPDATE Consultations SET Consulting_status = ? WHERE Consultation_ID = ?");

        st.setString(1, consultationsDTO.getConsulting_status());
        st.setInt(2, consultationsDTO.getConsultation_ID());

        st.executeUpdate();
    }

    public void updateConsultationRate(ConsultationsDTO consultations) throws SQLException, ClassNotFoundException {


        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("update Consultations set Rate = ? where Consultation_ID = ?;");

        st.setInt(1, consultations.getRate());
        st.setInt(2, consultations.getConsultation_ID());

        st.executeUpdate();
    }

}
