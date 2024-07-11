package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import org.example.dao.*;
import org.example.dto.*;
import org.example.model.Consultations;
import org.example.model.Login;
import org.example.model.Patient;

import java.sql.SQLException;
import java.util.ArrayList;

@Path("/Patient")
public class PatientController
{
    PatientDAO patientDAO = new PatientDAO();
    ConsultationsDAO consultationsDAO = new ConsultationsDAO();


    @GET
    public Response getAllPatient() {
        try {
            GenericEntity<ArrayList<Patient>> patients = new GenericEntity<ArrayList<Patient>>(patientDAO.selectAllPatient()) {};

            return Response
                    .ok(patients)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{patientID}/Consultation")
    public Response getAllPatientConsults(@PathParam("patientID") Integer patientID) {
        try {

            GenericEntity<ArrayList<ConsultationsPatientDTO>> consults = new GenericEntity<ArrayList<ConsultationsPatientDTO>>(consultationsDAO.selectAllPatientConsults(patientID)) {};

            return Response
                    .ok(consults)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{patientID}")
    public Response getPatient(@PathParam("patientID") Integer patientID) throws SQLException
    {
        try
        {
            PatientDTO dto = patientDAO.getPatient(patientID);

            return Response.ok(dto).build();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    public Response insertPatient(Patient patient) {
        try {
            patientDAO.insertPatient(patient);
            RegesterPatientDTO dto = new RegesterPatientDTO(null, patient.getPatient_first_name(), patient.getPatient_last_name());

            Login login = new Login(1, "Patient", patient.getPatient_email(), patient.getPatient_password());
            LoginController.register(login);

            return Response.ok(dto).build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("{patientID}/Doctor/{doctorID}/Consultation")
    public Response insertConsults(@PathParam("patientID") Integer patientID, @PathParam("doctorID") Integer doctorID) {
        try {
            Consultations consultations = new Consultations();
            consultations.setPatient_ID(patientID);
            consultations.setDoctor_ID(doctorID);
            consultations.setRate(0);
            consultationsDAO.insertConsultation(consultations);
            ConsultationsDTO dto = new ConsultationsDTO(0, consultations.getConsulting_status(), consultations.getRate());

            return Response
                    .ok(dto)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @PUT
    @Path("/rate/{consultId}")
    public Response updateConsultStatus(@PathParam("consultId") int consultId, ConsultationsDTO consultations)
    {
        try {
            consultations.setConsultation_ID(consultId);
            consultationsDAO.updateConsultationRate(consultations);

            return Response
                    .ok(consultations)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
