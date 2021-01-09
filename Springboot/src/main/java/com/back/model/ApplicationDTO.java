package com.back.model;

import javax.persistence.Column;
import java.util.Date;

public class ApplicationDTO {

    private long id;
    private Date dateOfSubm;
    private int number;
    private String title;
    private int idConfirmation;
    private String superior;
    private Date dateOfCheck;
    private boolean isApprove;
    private String department;
    private long userId;
    private Date dateOfApp;

    public ApplicationDTO() {
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getDateOfApp() {
        return dateOfApp;
    }

    public void setDateOfApp(Date dateOfApp) {
        this.dateOfApp = dateOfApp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOfSubm() {
        return dateOfSubm;
    }

    public void setDateOfSubm(Date dateOfSubm) {
        this.dateOfSubm = dateOfSubm;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdConfirmation() {
        return idConfirmation;
    }

    public void setIdConfirmation(int idConfirmation) {
        this.idConfirmation = idConfirmation;
    }

    public String getSuperior() {
        return superior;
    }

    public void setSuperior(String superior) {
        this.superior = superior;
    }

    public Date getDateOfCheck() {
        return dateOfCheck;
    }

    public void setDateOfCheck(Date dateOfCheck) {
        this.dateOfCheck = dateOfCheck;
    }

    public boolean isApprove() {
        return isApprove;
    }

    public void setApprove(boolean approve) {
        isApprove = approve;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
