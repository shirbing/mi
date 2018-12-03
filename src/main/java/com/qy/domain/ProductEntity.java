package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "product", schema = "secondproject", catalog = "")
@DynamicInsert(value = true)
public class ProductEntity {
    private int pId;
    private String pStyle;
    private int pNum;
    private String pName;
    private String pPackage;
    private int pWeight;
    private String pTryeat;
    private String pUnit;

    @Id
    @Column(name = "p_id")
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "p_style")
    public String getpStyle() {
        return pStyle;
    }

    public void setpStyle(String pStyle) {
        this.pStyle = pStyle;
    }

    @Basic
    @Column(name = "p_num")
    public int getpNum() {
        return pNum;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
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
    @Column(name = "p_package")
    public String getpPackage() {
        return pPackage;
    }

    public void setpPackage(String pPackage) {
        this.pPackage = pPackage;
    }

    @Basic
    @Column(name = "p_weight")
    public int getpWeight() {
        return pWeight;
    }

    public void setpWeight(int pWeight) {
        this.pWeight = pWeight;
    }

    @Basic
    @Column(name = "p_tryeat")
    public String getpTryeat() {
        return pTryeat;
    }

    public void setpTryeat(String pTryeat) {
        this.pTryeat = pTryeat;
    }

    @Basic
    @Column(name = "p_unit")
    public String getpUnit() {
        return pUnit;
    }

    public void setpUnit(String pUnit) {
        this.pUnit = pUnit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (pId != that.pId) return false;
        if (pNum != that.pNum) return false;
        if (pWeight != that.pWeight) return false;
        if (pStyle != null ? !pStyle.equals(that.pStyle) : that.pStyle != null) return false;
        if (pName != null ? !pName.equals(that.pName) : that.pName != null) return false;
        if (pPackage != null ? !pPackage.equals(that.pPackage) : that.pPackage != null) return false;
        if (pTryeat != null ? !pTryeat.equals(that.pTryeat) : that.pTryeat != null) return false;
        if (pUnit != null ? !pUnit.equals(that.pUnit) : that.pUnit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pId;
        result = 31 * result + (pStyle != null ? pStyle.hashCode() : 0);
        result = 31 * result + pNum;
        result = 31 * result + (pName != null ? pName.hashCode() : 0);
        result = 31 * result + (pPackage != null ? pPackage.hashCode() : 0);
        result = 31 * result + pWeight;
        result = 31 * result + (pTryeat != null ? pTryeat.hashCode() : 0);
        result = 31 * result + (pUnit != null ? pUnit.hashCode() : 0);
        return result;
    }
}
