package org.example.dao;

import org.example.connection.McpConnection;
import org.example.dto.SchedulDTO;
import org.example.model.Schedul;

import java.sql.*;
import java.util.ArrayList;

public class SchedulDAO
{
    public ArrayList<SchedulDTO> selectAllSchedul() throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("SELECT SCHEDUL_ID, SCHEDUL_start_time, SCHEDUL_end_time from SCHEDUL;");

        ResultSet rs = st.executeQuery();
        ArrayList<SchedulDTO> scheduls = new ArrayList<>();

        while (rs.next()) {
            scheduls.add(new SchedulDTO(rs));
        }
        return scheduls;
    }

    public ArrayList<SchedulDTO> getDoctorAllSchedules(Integer doctorID) throws SQLException, ClassNotFoundException
    {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select SCHEDUL.SCHEDUL_ID, SCHEDUL.SCHEDUL_start_time, SCHEDUL.SCHEDUL_end_time from DOCTOR join SCHEDUL on DOCTOR.Doctor_ID = SCHEDUL.Doctor_ID where DOCTOR.Doctor_ID = ?;");

        st.setInt(1, doctorID);

        ResultSet rs = st.executeQuery();
        ArrayList<SchedulDTO> doctors = new ArrayList<>();

        while (rs.next()) {
            doctors.add(new SchedulDTO(rs));
        }
        return doctors;
    }

    public Schedul getSchedul(Integer SchedulID) throws SQLException, ClassNotFoundException {


        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select * from SCHEDUL where SCHEDUL_ID = ?;");

        st.setInt(1, SchedulID);

        ResultSet rs = st.executeQuery();

        if(rs.next()) {
            return new Schedul(rs);
        }
        else {
            return null;
        }
    }

    public void insertSchedul(Schedul schedul) throws SQLException, ClassNotFoundException {


        Connection conn = McpConnection.getconnection();

        PreparedStatement st = conn.prepareStatement("insert into SCHEDUL (SCHEDUL_start_time, SCHEDUL_end_time, is_available, Doctor_ID) values (?, ?, true, ?)");

        st.setTime(1, Time.valueOf(schedul.getSCHEDUL_start_time()));
        st.setTime(2, Time.valueOf(schedul.getSCHEDUL_end_time()));
        st.setInt(3, schedul.getDoctor_ID());

        st.executeUpdate();
    }

    public void updateSchedule(SchedulDTO schedul) throws SQLException, ClassNotFoundException
    {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("UPDATE SCHEDUL SET SCHEDUL_start_time = ?, SCHEDUL_end_time = ? WHERE schedul_id = ?");

        st.setTime(1, Time.valueOf(schedul.getSCHEDUL_start_time()));
        st.setTime(2, Time.valueOf(schedul.getSCHEDUL_end_time()));
        st.setInt(3, schedul.getSCHEDUL_ID());

        st.executeUpdate();
    }

    public void updateScheduleAvailability(Boolean available, Integer id) throws SQLException, ClassNotFoundException
    {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("UPDATE SCHEDUL set is_available = ? where schedul_id = ?;");

        st.setInt(2, id);
        st.setBoolean(1, available);

        st.executeUpdate();
    }

}
