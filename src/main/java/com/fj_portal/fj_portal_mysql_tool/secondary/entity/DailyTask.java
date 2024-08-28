package com.fj_portal.fj_portal_mysql_tool.secondary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DAILYTASK")
public class DailyTask {

    @Id
    @Column(name = "EMPID")
    private String EmpId;

    @Column(name = "WORKDAY")
    private String Workday;

    @Column(name = "TASK")
    private String Task;

    @Column(name = "DESCRIPTION")
    private String Description;

    @Column(name = "STARTTIME")
    private String StartTime;

    @Column(name = "ENDTIME")
    private String EndTime;

    @Column(name = "EMPNAME")
    private String EmpName;

    @Column(name = "DIVN")
    private String Divn;

    // Getters and Setters
    public String getEmpId() {
        return EmpId;
    }

    public void setEmpId(String empId) {
        EmpId = empId;
    }

    public String getWorkday() {
        return Workday;
    }

    public void setWorkday(String workday) {
        Workday = workday;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getEmpName() {
        return EmpName;
    }

    public void setEmpName(String empName) {
        EmpName = empName;
    }

    public String getDivn() {
        return Divn;
    }

    public void setDivn(String divn) {
        Divn = divn;
    }
}
