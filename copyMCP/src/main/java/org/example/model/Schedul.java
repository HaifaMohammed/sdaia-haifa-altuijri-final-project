package org.example.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class Schedul
{
    Integer SCHEDUL_ID;
    LocalTime SCHEDUL_start_time;
    LocalTime SCHEDUL_end_time;
    boolean is_available;
    Integer Doctor_ID;

    public Schedul() {
    }

    public Schedul(ResultSet rs) throws SQLException
    {
        SCHEDUL_ID = rs.getInt("SCHEDUL_ID");
        SCHEDUL_start_time = rs.getTime("SCHEDUL_start_time").toLocalTime();
        SCHEDUL_end_time = rs.getTime("SCHEDUL_end_time").toLocalTime();
        is_available = rs.getBoolean("is_available");
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

    public void setIs_available(boolean is_available) {
        this.is_available = is_available;
    }

    public void setDoctor_ID(Integer doctor_ID) {
        Doctor_ID = doctor_ID;
    }

    public Integer getSCHEDUL_ID() {
        return SCHEDUL_ID;
    }

    public LocalTime getSCHEDUL_start_time() {
        return SCHEDUL_start_time;
    }

    public LocalTime getSCHEDUL_end_time() {
        return SCHEDUL_end_time;
    }

    public boolean getIs_available() {
        return is_available;
    }

    public Integer getDoctor_ID() {
        return Doctor_ID;
    }
}
