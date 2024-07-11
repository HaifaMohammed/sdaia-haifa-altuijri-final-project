package org.example.dao;

import org.example.connection.McpConnection;
import org.example.dto.Medical_ReportDTO;
import org.example.model.Medical_Report;

import java.sql.*;
import java.util.ArrayList;

public class Medical_ReportDAO
{

    public ArrayList<Medical_ReportDTO> selectAllMedical_reportByPatient(Integer PatientID) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st =
                conn.prepareStatement("select Medical_Report.Medical_Report_ID, Medical_Report.Medical_Report_Date, Medical_Report.Diagnose, Medical_Report.Treatment from Medical_Report join PATIENT on Medical_Report.Patient_ID = PATIENT.Patient_ID where Medical_Report.Patient_ID = ?;");

        st.setInt(1, PatientID);

        ResultSet rs = st.executeQuery();
        ArrayList<Medical_ReportDTO> medicalReports = new ArrayList<>();

        while (rs.next()) {
            medicalReports.add(new Medical_ReportDTO(rs));
        }
        return medicalReports;
    }

    public void insertMedical_report(Medical_Report medicalReport) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();

        PreparedStatement st = conn.prepareStatement("INSERT INTO Medical_Report (Medical_Report_Date, Diagnose, Treatment, Doctor_ID, Patient_ID) VALUES (?, ?, ?, ?, ?)");

        Timestamp current = new Timestamp(System.currentTimeMillis());

        st.setTimestamp(1, current);
        st.setString(2, medicalReport.getDiagnose());
        st.setString(3, medicalReport.getTreatment());
        st.setInt(4, medicalReport.getDoctor_ID());
        st.setInt(5, medicalReport.getPatient_ID());

        st.executeUpdate();
    }

    public Medical_ReportDTO getMedical_Report(Integer Medical_Report_id) throws SQLException, ClassNotFoundException {

        Connection conn = McpConnection.getconnection();
        PreparedStatement st = conn.prepareStatement("select Medical_Report.Medical_Report_ID, Medical_Report.Medical_Report_Date, Medical_Report.Diagnose, Medical_Report.Treatment from Medical_Report join PATIENT on Medical_Report.Patient_ID = PATIENT.Patient_ID where Medical_Report_ID = ?;");

        st.setInt(1, Medical_Report_id);

        ResultSet rs = st.executeQuery();

        if(rs.next()) {
            return new Medical_ReportDTO(rs);
        }
        else {
            return null;
        }
    }

}
