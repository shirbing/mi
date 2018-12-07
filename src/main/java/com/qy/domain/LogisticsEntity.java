package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity

@Table(name = "logistics", schema = "secondproject", catalog = "")
@DynamicInsert(value = true)
public class LogisticsEntity {
    private int lId;
    private Integer lNum;

    private Timestamp lTime;
    private String lName;
    private int oId;

    @Id
    @Column(name = "l_id")
    public int getlId() {
        return lId;
    }

    public void setlId(int lId) {
        this.lId = lId;
    }

    @Basic
    @Column(name = "l_num")

    public Integer getlNum() {
        return lNum;
    }

    public void setlNum(Integer lNum) {

        this.lNum = lNum;
    }

    @Basic
    @Column(name = "l_time")
    public Timestamp getlTime() {
        return lTime;
    }

    public void setlTime(Timestamp lTime) {
        this.lTime = lTime;
    }

    @Basic
    @Column(name = "l_name")
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Basic
    @Column(name = "o_id")
    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LogisticsEntity that = (LogisticsEntity) o;

        if (lId != that.lId) return false;
        if (lNum != that.lNum) return false;
        if (oId != that.oId) return false;
        if (lTime != null ? !lTime.equals(that.lTime) : that.lTime != null) return false;
        if (lName != null ? !lName.equals(that.lName) : that.lName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = lId;
        result = 31 * result + lNum;
        result = 31 * result + (lTime != null ? lTime.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + oId;
        return result;
    }
}
