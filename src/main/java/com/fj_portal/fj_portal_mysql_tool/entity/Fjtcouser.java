package com.fj_portal.fj_portal_mysql_tool.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "fjtcouser")
public class Fjtcouser {

    @Id
    @Column(name = "user_id")
    private String userId;

    @Column(name = "accesscrdNo")
    private Integer accessCardNo;

    @Column(name = "password")
    private String password;

    @Column(name = "temppassword")
    private String tempPassword;

    @Column(name = "homepage")
    private Integer homepage;

    @Column(name = "role")
    private String role;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getAccessCardNo() {
        return accessCardNo;
    }

    public void setAccessCardNo(Integer accessCardNo) {
        this.accessCardNo = accessCardNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTempPassword() {
        return tempPassword;
    }

    public void setTempPassword(String tempPassword) {
        this.tempPassword = tempPassword;
    }

    public Integer getHomepage() {
        return homepage;
    }

    public void setHomepage(Integer homepage) {
        this.homepage = homepage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
