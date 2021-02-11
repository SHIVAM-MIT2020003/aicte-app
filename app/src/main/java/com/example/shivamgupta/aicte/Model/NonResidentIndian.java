package com.example.shivamgupta.aicte.Model;

import java.io.Serializable;

public class NonResidentIndian implements Serializable{
    private String aicte_id;
    private String institute_name;
    private String state;
    private String District;
    private String institute_type;
    private String program;
    private String affiliating;
    private String foreign_body;
    private String level;
    private String course_name;
    private String shift;
    private String approved_intake;
    private String nri_quota;
    private String pio;
    private String univ_board;
    private String year;

    public String getAffiliating() {
        return affiliating;
    }

    public void setAffiliating(String affiliating) {
        this.affiliating = affiliating;
    }

    public String getAicte_id() {
        return aicte_id;
    }

    public void setAicte_id(String aicte_id) {
        this.aicte_id = aicte_id;
    }

    public String getApproved_intake() {
        return approved_intake;
    }

    public void setApproved_intake(String approved_intake) {
        this.approved_intake = approved_intake;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getForeign_body() {
        return foreign_body;
    }

    public void setForeign_body(String foreign_body) {
        this.foreign_body = foreign_body;
    }

    public String getInstitute_name() {
        return institute_name;
    }

    public void setInstitute_name(String institute_name) {
        this.institute_name = institute_name;
    }

    public String getInstitute_type() {
        return institute_type;
    }

    public void setInstitute_type(String institute_type) {
        this.institute_type = institute_type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNri_quota() {
        return nri_quota;
    }

    public void setNri_quota(String nri_quota) {
        this.nri_quota = nri_quota;
    }

    public String getPio() {
        return pio;
    }

    public void setPio(String pio) {
        this.pio = pio;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUniv_board() {
        return univ_board;
    }

    public void setUniv_board(String univ_board) {
        this.univ_board = univ_board;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
