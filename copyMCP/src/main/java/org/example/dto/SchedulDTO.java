package org.example.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class SchedulDTO
{
    Integer SCHEDUL_ID;
    LocalTime SCHEDUL_start_time;
    LocalTime SCHEDUL_end_time;


    public SchedulDTO() {
    }

    public SchedulDTO(ResultSet rs) throws SQLException
    {
        SCHEDUL_ID = rs.getInt("SCHEDUL_ID");
        SCHEDUL_start_time = rs.getObject("SCHEDUL_start_time", LocalTime.class);
        SCHEDUL_end_time = rs.getObject("SCHEDUL_end_time", LocalTime.class);
    }

    public SchedulDTO(Integer SCHEDUL_ID, LocalTime SCHEDUL_start_time, LocalTime SCHEDUL_end_time) {
        this.SCHEDUL_ID = SCHEDUL_ID;
        this.SCHEDUL_start_time = SCHEDUL_start_time;
        this.SCHEDUL_end_time = SCHEDUL_end_time;
    }

    public Integer getSCHEDUL_ID() {
        return SCHEDUL_ID;
    }

    public void setSCHEDUL_ID(Integer SCHEDUL_ID) {
        this.SCHEDUL_ID = SCHEDUL_ID;
    }

    public void setSCHEDUL_start_time(LocalTime SCHEDUL_start_time) {
        this.SCHEDUL_start_time = SCHEDUL_start_time;
    }

    public void setSCHEDUL_end_time(LocalTime SCHEDUL_end_time) {
        this.SCHEDUL_end_time = SCHEDUL_end_time;
    }

    public LocalTime getSCHEDUL_start_time() {
        return SCHEDUL_start_time;
    }

    public LocalTime getSCHEDUL_end_time() {
        return SCHEDUL_end_time;
    }

}
