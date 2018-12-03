package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "evaluation", schema = "secondproject", catalog = "")
@DynamicInsert(value = true)
public class EvaluationEntity {
    private int eId;
    private int eNum;
    private int uId;
    private String eStar;
    private String eEval;
    private Timestamp eTime;

    @Id
    @Column(name = "e_id")
    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
    }

    @Basic
    @Column(name = "e_num")
    public int geteNum() {
        return eNum;
    }

    public void seteNum(int eNum) {
        this.eNum = eNum;
    }

    @Basic
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "e_star")
    public String geteStar() {
        return eStar;
    }

    public void seteStar(String eStar) {
        this.eStar = eStar;
    }

    @Basic
    @Column(name = "e_eval")
    public String geteEval() {
        return eEval;
    }

    public void seteEval(String eEval) {
        this.eEval = eEval;
    }

    @Basic
    @Column(name = "e_time")
    public Timestamp geteTime() {
        return eTime;
    }

    public void seteTime(Timestamp eTime) {
        this.eTime = eTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationEntity that = (EvaluationEntity) o;

        if (eId != that.eId) return false;
        if (eNum != that.eNum) return false;
        if (uId != that.uId) return false;
        if (eStar != null ? !eStar.equals(that.eStar) : that.eStar != null) return false;
        if (eEval != null ? !eEval.equals(that.eEval) : that.eEval != null) return false;
        if (eTime != null ? !eTime.equals(that.eTime) : that.eTime != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eId;
        result = 31 * result + eNum;
        result = 31 * result + uId;
        result = 31 * result + (eStar != null ? eStar.hashCode() : 0);
        result = 31 * result + (eEval != null ? eEval.hashCode() : 0);
        result = 31 * result + (eTime != null ? eTime.hashCode() : 0);
        return result;
    }
}
