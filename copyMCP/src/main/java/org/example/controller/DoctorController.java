package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.GenericEntity;
import jakarta.ws.rs.core.Response;
import org.example.dao.ConsultationsDAO;
import org.example.dao.DoctorDAO;
import org.example.dao.Medical_ReportDAO;
import org.example.dao.SchedulDAO;
import org.example.dto.*;
import org.example.model.*;


import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;

@Path("/Doctor")
public class DoctorController
{
    DoctorDAO doctorDAO = new DoctorDAO();
    SchedulDAO schedulDAO = new SchedulDAO();
    ConsultationsDAO consultationsDAO = new ConsultationsDAO();
    Medical_ReportDAO medicalReportDAO = new Medical_ReportDAO();


    @GET
    public Response getAllDoctorlogin() {
        try {
            GenericEntity<ArrayList<DoctorDTO>> doctors = new GenericEntity<ArrayList<DoctorDTO>>(doctorDAO.selectAllDoctor()) {};

            return Response
                    .ok(doctors)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("search")
    public Response searchDoctors(
            @QueryParam("id") Integer id,
            @QueryParam("rate") Integer rate,
            @QueryParam("name") String name,
            @QueryParam("availability") Boolean availability,
            @QueryParam("specialty") String specialty
    )
    {
        try {
            ArrayList<DoctorDTO> doctors;

            if (id != null) {
                // Search by ID
                DoctorDTO doctor = doctorDAO.getDoctor(id);
                doctors = new ArrayList<>();
                if (doctor != null) {
                    doctors.add(doctor);
                }

            }else if (rate != null) {
                // Search by Rate
                doctors = doctorDAO.selectAllDoctorRate(rate);

            }  else if (name != null) {
                // Search by Name
                name = name.toLowerCase();
                doctors = doctorDAO.selectAllDoctorName(name);

            } else if (availability != null) {
                // Search by Availability

                ArrayList<SchedulDTO> scheduls = schedulDAO.selectAllSchedul();
                LocalTime currentTime = LocalTime.now();

                for(SchedulDTO dto : scheduls)
                {
                    boolean isAvailable = currentTime.isBefore(dto.getSCHEDUL_end_time()) && currentTime.isAfter(dto.getSCHEDUL_start_time());
                    schedulDAO.updateScheduleAvailability(isAvailable, dto.getSCHEDUL_ID());
                }

                doctors = doctorDAO.selectAllDoctorAvailable(availability);

            } else if (specialty != null) {
                // Search by Specialty
                specialty = specialty.toLowerCase();
                doctors = doctorDAO.selectAllDoctorspecialty(specialty);

            } else {
                // Handle case where no valid query parameter is provided
                doctors = doctorDAO.selectAllDoctor();
            }

            GenericEntity<ArrayList<DoctorDTO>> doctorsEntity = new GenericEntity<ArrayList<DoctorDTO>>(doctors) {};

            return Response.ok(doctorsEntity).build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("{doctorID}/Consultation")
    public Response getAllDoctorConsults(@PathParam("doctorID") Integer doctorID) {
        try {

            GenericEntity<ArrayList<ConsultationsDoctorDTO>> consults = new GenericEntity<ArrayList<ConsultationsDoctorDTO>>(consultationsDAO.selectAllDoctorConsults(doctorID)) {};

            return Response
                    .ok(consults)
                    .build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/{doctorID}/Schedule")
    public Response getDoctorSchedules(@PathParam("doctorID") Integer doctorID) throws SQLException
    {
        try
        {
            GenericEntity<ArrayList<SchedulDTO>> doctorSchedules =
                    new GenericEntity<ArrayList<SchedulDTO>>(schedulDAO.getDoctorAllSchedules(doctorID)) {};

            return Response
                    .ok(doctorSchedules)
                    .build();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/Medical_report_search/{Medical_reportID}")
    public Response getMedical_ReportWithePatient(@PathParam("Medical_reportID") Integer Medical_reportID) {
        try
        {
            Medical_ReportDTO dto = medicalReportDAO.getMedical_Report(Medical_reportID);

            return Response.ok(dto).build();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    public Response insertDoctor(Doctor doctor)
    {
        try {
            doctorDAO.insertDoctor(doctor);
            RegesterDoctorDTO doctorDTO = new RegesterDoctorDTO(null, doctor.getDoctor_first_name(), doctor.getDoctor_last_name());

            Login login = new Login(1, "Doctor", doctor.getDoctor_email(), doctor.getDoctor_password());
            LoginController.register(login);

            return Response
                    .ok(doctorDTO)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("{doctorID}/Patient/{PatientID}/Medical_Report")
    public Response insertMedical_Report(@PathParam("doctorID") Integer doctorID, @PathParam("PatientID") Integer PatientID,Medical_Report medicalReport)
    {
        try {
            medicalReport.setDoctor_ID(doctorID);
            medicalReport.setPatient_ID(PatientID);
            medicalReportDAO.insertMedical_report(medicalReport);
            Medical_ReportDTO dto = new Medical_ReportDTO(null, medicalReport.getMedical_Report_Date(), medicalReport.getDiagnose(), medicalReport.getTreatment());

            return Response
                    .ok(dto)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @POST
    @Path("{doctorID}/Schedule")
    public Response insertSchedul(@PathParam("doctorID") Integer doctorID, Schedul schedul)
    {
        try {
            schedul.setDoctor_ID(doctorID);
            schedulDAO.insertSchedul(schedul);
            SchedulDTO dto = new SchedulDTO(schedul.getSCHEDUL_ID(), schedul.getSCHEDUL_start_time(), schedul.getSCHEDUL_end_time());

            return Response
                    .ok(dto)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/status/{consultId}")
    public Response updateConsultStatus(@PathParam("consultId") int consultId, ConsultationsDTO consultationsDTO) {
        try {
            consultationsDTO.setConsultation_ID(consultId);
            consultationsDAO.updateConsultationStatus(consultationsDTO);

            return Response
                    .ok(consultationsDTO)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/Schedule/{ScheduleId}")
    public Response updateDoctorSchedule(@PathParam("ScheduleId") int ScheduleId, SchedulDTO schedulDTO) {
        try {
            schedulDTO.setSCHEDUL_ID(ScheduleId);
            schedulDAO.updateSchedule(schedulDTO);

            return Response
                    .ok(schedulDTO)
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
