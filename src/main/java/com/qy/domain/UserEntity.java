package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user", schema = "secondproject")
@DynamicInsert(value = true)
public class UserEntity {
    private int uId;
    private String uName;
    private String uIcon;
    private String uPhone;
    private String uPwd;
    private String uState;
    private Timestamp uRegister;

    @Id
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_name")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "u_icon")
    public String getuIcon() {
        return uIcon;
    }

    public void setuIcon(String uIcon) {
        this.uIcon = uIcon;
    }

    @Basic
    @Column(name = "u_phone")
    public String getuPhone() {
        return uPhone;
    }

    public void setuPhone(String uPhone) {
        this.uPhone = uPhone;
    }

    @Basic
    @Column(name = "u_pwd")
    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Basic
    @Column(name = "u_state")
    public String getuState() {
        return uState;
    }

    public void setuState(String uState) {
        this.uState = uState;
    }

    @Basic
    @Column(name = "u_register")
    public Timestamp getuRegister() {
        return uRegister;
    }

    public void setuRegister(Timestamp uRegister) {
        this.uRegister = uRegister;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (uId != that.uId) return false;
        if (uName != null ? !uName.equals(that.uName) : that.uName != null) return false;
        if (uIcon != null ? !uIcon.equals(that.uIcon) : that.uIcon != null) return false;
        if (uPhone != null ? !uPhone.equals(that.uPhone) : that.uPhone != null) return false;
        if (uPwd != null ? !uPwd.equals(that.uPwd) : that.uPwd != null) return false;
        if (uState != null ? !uState.equals(that.uState) : that.uState != null) return false;
        if (uRegister != null ? !uRegister.equals(that.uRegister) : that.uRegister != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + (uIcon != null ? uIcon.hashCode() : 0);
        result = 31 * result + (uPhone != null ? uPhone.hashCode() : 0);
        result = 31 * result + (uPwd != null ? uPwd.hashCode() : 0);
        result = 31 * result + (uState != null ? uState.hashCode() : 0);
        result = 31 * result + (uRegister != null ? uRegister.hashCode() : 0);
        return result;
    }
}
