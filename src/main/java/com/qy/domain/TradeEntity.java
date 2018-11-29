package com.qy.domain;

import javax.persistence.*;

@Entity
@Table(name = "trade", schema = "secondproject", catalog = "")
public class TradeEntity {
    private int tId;
    private int oId;
    private String uPhone;
    private String tType;
    private String tStyle;

    @Id
    @Column(name = "t_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int gettId() {
        return tId;
    }

    public void settId(int tId) {
        this.tId = tId;
    }

    @Basic
    @Column(name = "o_id")
    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
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
    @Column(name = "t_type")
    public String gettType() {
        return tType;
    }

    public void settType(String tType) {
        this.tType = tType;
    }

    @Basic
    @Column(name = "t_style")
    public String gettStyle() {
        return tStyle;
    }

    public void settStyle(String tStyle) {
        this.tStyle = tStyle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradeEntity that = (TradeEntity) o;

        if (tId != that.tId) return false;
        if (oId != that.oId) return false;
        if (uPhone != null ? !uPhone.equals(that.uPhone) : that.uPhone != null) return false;
        if (tType != null ? !tType.equals(that.tType) : that.tType != null) return false;
        if (tStyle != null ? !tStyle.equals(that.tStyle) : that.tStyle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tId;
        result = 31 * result + oId;
        result = 31 * result + (uPhone != null ? uPhone.hashCode() : 0);
        result = 31 * result + (tType != null ? tType.hashCode() : 0);
        result = 31 * result + (tStyle != null ? tStyle.hashCode() : 0);
        return result;
    }
}
