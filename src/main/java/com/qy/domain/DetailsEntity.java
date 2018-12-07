package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "details", schema = "secondproject")
@DynamicInsert(value = true)
public class DetailsEntity {
    private int dId;
    private String pName;
    private int oId;
    private double dPrice;
    private double dDiscount;
    private int dCount;

    @Id
    @Column(name = "d_id")
    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    @Basic
    @Column(name = "p_name")
    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
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
    @Column(name = "d_price")
    public double getdPrice() {
        return dPrice;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    @Basic
    @Column(name = "d_discount")
    public double getdDiscount() {
        return dDiscount;
    }

    public void setdDiscount(double dDiscount) {
        this.dDiscount = dDiscount;
    }

    @Basic
    @Column(name = "d_count")
    public int getdCount() {
        return dCount;
    }

    public void setdCount(int dCount) {
        this.dCount = dCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailsEntity that = (DetailsEntity) o;

        if (dId != that.dId) return false;
        if (oId != that.oId) return false;
        if (Double.compare(that.dPrice, dPrice) != 0) return false;
        if (Double.compare(that.dDiscount, dDiscount) != 0) return false;
        if (dCount != that.dCount) return false;
        if (pName != null ? !pName.equals(that.pName) : that.pName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = dId;
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        result = 31 * result + oId;
        temp = Double.doubleToLongBits(dPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(dDiscount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + dCount;
        return result;
    }
}
