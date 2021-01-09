package com.back.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "application")
public class DAOApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "date_of_submission")
    private Date dateOfSubm;
    @Column
    private int number;
    @Column
    private String title;
    @Column(name = "id_confirm")
    private int idConfirmation;
    @Column
    private String superior;
    @Column(name = "date_of_check")
    private Date dateOfCheck;
    @Column(name = "is_approve")
    private boolean isApprove;
    @Column(name = "department")
    private String department;
    @Column(name = "user_id")
    private long userId;
    @Column(name = "date_of_appoiment")
    private Date dateOfApp;

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
}