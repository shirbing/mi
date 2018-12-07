package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity

@Table(name = "shopcar", schema = "secondproject")

@DynamicInsert(value = true)
public class ShopcarEntity {
    private int sId;
    private String sName;
    private String sIcon;
    private double sPrice;

    private Integer sNum;

    private double sSumprice;
    private String uName;
    private String gNum;

    @Id
    @Column(name = "s_id")
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Basic
    @Column(name = "s_name")
    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @Basic
    @Column(name = "s_icon")
    public String getsIcon() {
        return sIcon;
    }

    public void setsIcon(String sIcon) {
        this.sIcon = sIcon;
    }

    @Basic
    @Column(name = "s_price")
    public double getsPrice() {
        return sPrice;
    }

    public void setsPrice(double sPrice) {
        this.sPrice = sPrice;
    }

    @Basic
    @Column(name = "s_num")

    public Integer getsNum() {
        return sNum;
    }

    public void setsNum(Integer sNum) {

        this.sNum = sNum;
    }

    @Basic
    @Column(name = "s_sumprice")
    public double getsSumprice() {
        return sSumprice;
    }

    public void setsSumprice(double sSumprice) {
        this.sSumprice = sSumprice;
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
    @Column(name = "g_num")
    public String getgNum() {
        return gNum;
    }

    public void setgNum(String gNum) {
        this.gNum = gNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShopcarEntity that = (ShopcarEntity) o;

        if (sId != that.sId) return false;
        if (Double.compare(that.sPrice, sPrice) != 0) return false;
        if (sNum != that.sNum) return false;
        if (Double.compare(that.sSumprice, sSumprice) != 0) return false;
        if (sName != null ? !sName.equals(that.sName) : that.sName != null) return false;
        if (sIcon != null ? !sIcon.equals(that.sIcon) : that.sIcon != null) return false;
        if (uName != null ? !uName.equals(that.uName) : that.uName != null) return false;
        if (gNum != null ? !gNum.equals(that.gNum) : that.gNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = sId;
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (sIcon != null ? sIcon.hashCode() : 0);
        temp = Double.doubleToLongBits(sPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + sNum;
        temp = Double.doubleToLongBits(sSumprice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + (gNum != null ? gNum.hashCode() : 0);
        return result;
    }
}
