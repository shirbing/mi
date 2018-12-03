package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "getgood", schema = "secondproject", catalog = "")
@DynamicInsert(value = true)
public class GetgoodEntity {
    private int ggId;
    private String ggName;
    private String ggPhone;
    private String ggAddress;
    private String ggState;
    private int uId;

    @Id
    @Column(name = "gg_id")
    public int getGgId() {
        return ggId;
    }

    public void setGgId(int ggId) {
        this.ggId = ggId;
    }

    @Basic
    @Column(name = "gg_name")
    public String getGgName() {
        return ggName;
    }

    public void setGgName(String ggName) {
        this.ggName = ggName;
    }

    @Basic
    @Column(name = "gg_phone")
    public String getGgPhone() {
        return ggPhone;
    }

    public void setGgPhone(String ggPhone) {
        this.ggPhone = ggPhone;
    }

    @Basic
    @Column(name = "gg_address")
    public String getGgAddress() {
        return ggAddress;
    }

    public void setGgAddress(String ggAddress) {
        this.ggAddress = ggAddress;
    }

    @Basic
    @Column(name = "gg_state")
    public String getGgState() {
        return ggState;
    }

    public void setGgState(String ggState) {
        this.ggState = ggState;
    }

    @Basic
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetgoodEntity that = (GetgoodEntity) o;

        if (ggId != that.ggId) return false;
        if (uId != that.uId) return false;
        if (ggName != null ? !ggName.equals(that.ggName) : that.ggName != null) return false;
        if (ggPhone != null ? !ggPhone.equals(that.ggPhone) : that.ggPhone != null) return false;
        if (ggAddress != null ? !ggAddress.equals(that.ggAddress) : that.ggAddress != null) return false;
        if (ggState != null ? !ggState.equals(that.ggState) : that.ggState != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ggId;
        result = 31 * result + (ggName != null ? ggName.hashCode() : 0);
        result = 31 * result + (ggPhone != null ? ggPhone.hashCode() : 0);
        result = 31 * result + (ggAddress != null ? ggAddress.hashCode() : 0);
        result = 31 * result + (ggState != null ? ggState.hashCode() : 0);
        result = 31 * result + uId;
        return result;
    }
}
