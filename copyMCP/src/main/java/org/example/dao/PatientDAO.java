package org.example.dao;


import org.example.connection.McpConnection;
import org.example.dto.PatientDTO;
import org.example.model.Patient;

import java.sql.*;
import java.util.ArrayList;

public class PatientDAO
{

    public ArrayList<Patient> selectAllPatient() throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select * from PATIENT;");

        ResultSet rs = st.executeQuery();
        ArrayList<Patient> patients = new ArrayList<>();

        while (rs.next()) {
            patients.add(new Patient(rs));
        }
        return patients;
    }

    public PatientDTO getPatient(Integer PatientID) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select Patient_ID, Patient_first_name, Patient_last_name, Patient_phone, Patient_Date_of_birth, Patient_weight, Patient_Gender from PATIENT where Patient_ID = ?;");

        st.setInt(1, PatientID);

        ResultSet rs = st.executeQuery();

        if(rs.next()) {
            return new PatientDTO(rs);
        }
        else {
            return null;
        }
    }

    public void insertPatient(Patient patient) throws SQLException, ClassNotFoundException {
        Connection conn = McpConnection.getconnection();

        // Get the next ID for Patient_ID
        PreparedStatement st = conn.prepareStatement("INSERT INTO PATIENT (Patient_first_name, Patient_last_name, Patient_email, Patient_password, Patient_phone, Patient_Date_of_birth, Patient_weight, Patient_Gender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

        st.setString(1, patient.getPatient_first_name());
        st.setString(2, patient.getPatient_last_name());
        st.setString(3, patient.getPatient_email());
        st.setString(4, patient.getPatient_password());
        st.setString(5, patient.getPatient_phone());
        st.setDate(6, Date.valueOf(patient.getPatient_Date_of_birth()));
        st.setString(7, patient.getPatient_weight());
        st.setString(8, patient.getPatient_Gender());

        st.executeUpdate();
    }
}
