package com.qy.domain;

import javax.persistence.*;

@Entity
@Table(name = "unit", schema = "secondproject", catalog = "")
public class UnitEntity {
    private int uId;
    private String uValue;

    @Id
    @Column(name = "u_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "u_value")
    public String getuValue() {
        return uValue;
    }

    public void setuValue(String uValue) {
        this.uValue = uValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnitEntity that = (UnitEntity) o;

        if (uId != that.uId) return false;
        if (uValue != null ? !uValue.equals(that.uValue) : that.uValue != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uId;
        result = 31 * result + (uValue != null ? uValue.hashCode() : 0);
        return result;
    }
}
