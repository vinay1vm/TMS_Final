package com.example.tms_final;

public class VModel {
    String Visitor_Id, Resident_full_name,Guest_Date, Guest_Time,Guest_full_name;

    public VModel() {
    }

    public VModel(String visitor_Id, String resident_full_name, String guest_Date, String guest_Time, String guest_full_name) {
        Visitor_Id = visitor_Id;
        Resident_full_name = resident_full_name;
        Guest_Date = guest_Date;
        Guest_Time = guest_Time;
        Guest_full_name = guest_full_name;
    }

    public String getVisitor_Id() {
        return Visitor_Id;
    }

    public void setVisitor_Id(String visitor_Id) {
        Visitor_Id = visitor_Id;
    }

    public String getResident_full_name() {
        return Resident_full_name;
    }

    public void setResident_full_name(String resident_full_name) {
        Resident_full_name = resident_full_name;
    }

    public String getGuest_Date() {
        return Guest_Date;
    }

    public void setGuest_Date(String guest_Date) {
        Guest_Date = guest_Date;
    }

    public String getGuest_Time() {
        return Guest_Time;
    }

    public void setGuest_Time(String guest_Time) {
        Guest_Time = guest_Time;
    }

    public String getGuest_full_name() {
        return Guest_full_name;
    }

    public void setGuest_full_name(String guest_full_name) {
        Guest_full_name = guest_full_name;
    }
}
