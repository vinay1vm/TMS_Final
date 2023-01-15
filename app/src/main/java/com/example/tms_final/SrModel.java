package com.example.tms_final;

public class SrModel {
    String type,description,Request_Id;

    public SrModel() {

    }
    public SrModel(String type, String description, String Request_Id) {
        this.type = type;
        this.description = description;
        this.Request_Id = Request_Id;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequest_Id() {
        return Request_Id;
    }

    public void setRequest_Id(String request_Id) {
        Request_Id = request_Id;
    }
}
