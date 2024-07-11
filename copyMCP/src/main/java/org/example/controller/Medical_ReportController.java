package org.example.controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import org.example.dao.Medical_ReportDAO;
import org.example.dto.Medical_ReportDTO;

import java.util.ArrayList;

@Path("/Medical_Report")
public class Medical_ReportController
{
    Medical_ReportDAO medicalReportDAO = new Medical_ReportDAO();

    @GET
    @Path("/Patient/{PatientID}")
    public Response getAllPatientMR(@PathParam("PatientID") Integer PatientID) {
        try {


            GenericEntity<ArrayList<Medical_ReportDTO>> dto = new GenericEntity<ArrayList<Medical_ReportDTO>>(medicalReportDAO.selectAllMedical_reportByPatient(PatientID)) {};

            return Response
                    .ok(dto)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
