package com.qy.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "admin", schema = "secondproject", catalog = "")
public class AdminEntity {
    private int aId;
    private String aAccount;
    private String aName;
    private String aPwd;
    private String aPhone;
    private Timestamp aDate;

    @Id
    @Column(name = "a_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    @Basic
    @Column(name = "a_account")
    public String getaAccount() {
        return aAccount;
    }

    public void setaAccount(String aAccount) {
        this.aAccount = aAccount;
    }

    @Basic
    @Column(name = "a_name")
    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Basic
    @Column(name = "a_pwd")
    public String getaPwd() {
        return aPwd;
    }

    public void setaPwd(String aPwd) {
        this.aPwd = aPwd;
    }

    @Basic
    @Column(name = "a_phone")
    public String getaPhone() {
        return aPhone;
    }

    public void setaPhone(String aPhone) {
        this.aPhone = aPhone;
    }

    @Basic
    @Column(name = "a_date")
    public Timestamp getaDate() {
        return aDate;
    }

    public void setaDate(Timestamp aDate) {
        this.aDate = aDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdminEntity that = (AdminEntity) o;

        if (aId != that.aId) return false;
        if (aAccount != null ? !aAccount.equals(that.aAccount) : that.aAccount != null) return false;
        if (aName != null ? !aName.equals(that.aName) : that.aName != null) return false;
        if (aPwd != null ? !aPwd.equals(that.aPwd) : that.aPwd != null) return false;
        if (aPhone != null ? !aPhone.equals(that.aPhone) : that.aPhone != null) return false;
        if (aDate != null ? !aDate.equals(that.aDate) : that.aDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aId;
        result = 31 * result + (aAccount != null ? aAccount.hashCode() : 0);
        result = 31 * result + (aName != null ? aName.hashCode() : 0);
        result = 31 * result + (aPwd != null ? aPwd.hashCode() : 0);
        result = 31 * result + (aPhone != null ? aPhone.hashCode() : 0);
        result = 31 * result + (aDate != null ? aDate.hashCode() : 0);
        return result;
    }
}
