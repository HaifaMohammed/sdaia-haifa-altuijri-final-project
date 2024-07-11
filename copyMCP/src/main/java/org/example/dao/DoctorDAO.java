package org.example.dao;

import org.example.connection.McpConnection;
import org.example.dto.DoctorDTO;
import org.example.model.Doctor;

import java.sql.*;
import java.util.ArrayList;

public class DoctorDAO
{

    public ArrayList<Doctor> selectAllDoctorLogin() throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select * from DOCTOR;");

        ResultSet rs = st.executeQuery();
        ArrayList<Doctor> doctors = new ArrayList<>();

        while (rs.next()) {
            doctors.add(new Doctor(rs));
        }
        return doctors;
    }

    public ArrayList<DoctorDTO> selectAllDoctor() throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select Doctor_ID, Doctor_first_name, Doctor_last_name, Doctor_specialty from DOCTOR;");

        ResultSet rs = st.executeQuery();
        ArrayList<DoctorDTO> doctors = new ArrayList<>();

        while (rs.next()) {
            doctors.add(new DoctorDTO(rs));
        }
        return doctors;
    }

    public ArrayList<DoctorDTO> selectAllDoctorRate(Integer rate) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("" +
                "SELECT  d.Doctor_ID, d.Doctor_first_name, d.Doctor_last_name,d.Doctor_specialty, AVG(c.Rate) AS Average_Rate " +
                "FROM DOCTOR d LEFT JOIN CONSULTATIONS c " +
                "ON d.Doctor_ID = c.Doctor_ID " +
                "WHERE rate NOTNULL " +
                "GROUP BY d.Doctor_ID, d.Doctor_first_name, d.Doctor_last_name, d.Doctor_specialty " +
                "HAVING Average_Rate BETWEEN ? and ? " +
                "ORDER BY Average_Rate DESC;");

        st.setInt(1, rate);
        if(rate < 5 && rate != 0)
        {
            st.setInt(2, rate+1);
        }else {
            st.setInt(2, rate);
        }

        ResultSet rs = st.executeQuery();
        ArrayList<DoctorDTO> doctors = new ArrayList<>();

        while (rs.next()) {
            doctors.add(new DoctorDTO(rs));
        }
        return doctors;
    }

    public ArrayList<DoctorDTO> selectAllDoctorAvailable(Boolean available) throws SQLException, ClassNotFoundException {


        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("SELECT Doctor_ID, Doctor_first_name, Doctor_last_name, Doctor_specialty from DOCTOR where Doctor_ID in (SELECT DISTINCT (Doctor_ID) from SCHEDUL where is_available = ?);");

        st.setBoolean(1, available);

        ResultSet rs = st.executeQuery();
        ArrayList<DoctorDTO> doctors = new ArrayList<>();

        while (rs.next()) {
            doctors.add(new DoctorDTO(rs));
        }
        return doctors;
    }

    public ArrayList<DoctorDTO> selectAllDoctorName(String name) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select Doctor_ID, Doctor_first_name, Doctor_last_name, Doctor_specialty from DOCTOR where Doctor_first_name LIKE ?");

        st.setString(1, "%" + name + "%");

        ResultSet rs = st.executeQuery();
        ArrayList<DoctorDTO> doctors = new ArrayList<>();

        while (rs.next()) {
            doctors.add(new DoctorDTO(rs));
        }
        return doctors;
    }

    public ArrayList<DoctorDTO> selectAllDoctorspecialty(String specialty) throws SQLException, ClassNotFoundException {


        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select Doctor_ID, Doctor_first_name, Doctor_last_name, Doctor_specialty from DOCTOR where Doctor_specialty LIKE ? ;");

        st.setString(1, "%" + specialty + "%");

        ResultSet rs = st.executeQuery();
        ArrayList<DoctorDTO> doctors = new ArrayList<>();

        while (rs.next()) {
            doctors.add(new DoctorDTO(rs));
        }
        return doctors;
    }

    public DoctorDTO getDoctor(Integer doctorID) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select Doctor_ID, Doctor_first_name, Doctor_last_name, Doctor_specialty from DOCTOR where Doctor_ID = ?;");

        st.setInt(1, doctorID);

        ResultSet rs = st.executeQuery();

        if(rs.next()) {
            return new DoctorDTO(rs);
        }
        else {
            return null;
        }
    }

    public void insertDoctor(Doctor doctor) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();

        PreparedStatement st = conn.prepareStatement("insert into DOCTOR (Doctor_first_name, Doctor_last_name, Doctor_specialty, Doctor_email, Doctor_password, Doctor_phone) values (?, ?, ?, ?, ?, ?);");

        st.setString(1, doctor.getDoctor_first_name());
        st.setString(2, doctor.getDoctor_last_name());
        st.setString(3, doctor.getDoctor_specialty());
        st.setString(4, doctor.getDoctor_email());
        st.setString(5, doctor.getDoctor_password());
        st.setString(6, doctor.getDoctor_phone());

        st.executeUpdate();
    }

}
