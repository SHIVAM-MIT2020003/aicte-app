package com.example.shivamgupta.aicte.Model;


public class Faculty {
    private String facultyId;
    private String name;
    private String gender;
    private String designation;
    private String dateOfJoining;
    private String areaOfSpecialisation;
    private String appointmentType;
    private String instituteName;

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getAreaOfSpecialisation() {
        return areaOfSpecialisation;
    }

    public void setAreaOfSpecialisation(String areaOfSpecialisation) {
        this.areaOfSpecialisation = areaOfSpecialisation;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(String facultyId) {
        this.facultyId = facultyId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

