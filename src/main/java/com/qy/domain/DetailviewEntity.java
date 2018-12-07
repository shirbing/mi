package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity

@Table(name = "detailview", schema = "secondproject")

@DynamicInsert(value = true)
public class DetailviewEntity {
    private int oId;
    private String oNum;
    private String uName;
    private String gNum;
    private double oMoney;

    private Double oPost;

    private String oMsg;
    private String oPaystate;
    private String oSendstate;
    private String oOk;
    private String oIsevaluate;
    private String ggName;
    private Integer lNum;
    private Timestamp lTime;
    private String lName;
    private String sName;
    private String sIcon;
    private Double sPrice;
    private Integer sNum;
    private Double sSumprice;
    private String ggPhone;
    private String ggAddress;

    @Id
    @Column(name = "o_id")
    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    @Basic
    @Column(name = "o_num")
    public String getoNum() {
        return oNum;
    }

    public void setoNum(String oNum) {
        this.oNum = oNum;
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

    @Basic
    @Column(name = "o_money")
    public double getoMoney() {
        return oMoney;
    }

    public void setoMoney(double oMoney) {
        this.oMoney = oMoney;
    }

    @Basic
    @Column(name = "o_post")

    public Double getoPost() {
        return oPost;
    }

    public void setoPost(Double oPost) {

        this.oPost = oPost;
    }

    @Basic
    @Column(name = "o_msg")
    public String getoMsg() {
        return oMsg;
    }

    public void setoMsg(String oMsg) {
        this.oMsg = oMsg;
    }

    @Basic
    @Column(name = "o_paystate")
    public String getoPaystate() {
        return oPaystate;
    }

    public void setoPaystate(String oPaystate) {
        this.oPaystate = oPaystate;
    }

    @Basic
    @Column(name = "o_sendstate")
    public String getoSendstate() {
        return oSendstate;
    }

    public void setoSendstate(String oSendstate) {
        this.oSendstate = oSendstate;
    }

    @Basic
    @Column(name = "o_ok")
    public String getoOk() {
        return oOk;
    }

    public void setoOk(String oOk) {
        this.oOk = oOk;
    }

    @Basic
    @Column(name = "o_isevaluate")
    public String getoIsevaluate() {
        return oIsevaluate;
    }

    public void setoIsevaluate(String oIsevaluate) {
        this.oIsevaluate = oIsevaluate;
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
    public Double getsPrice() {
        return sPrice;
    }

    public void setsPrice(Double sPrice) {
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
    public Double getsSumprice() {
        return sSumprice;
    }

    public void setsSumprice(Double sSumprice) {
        this.sSumprice = sSumprice;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DetailviewEntity that = (DetailviewEntity) o;

        if (oId != that.oId) return false;
        if (Double.compare(that.oMoney, oMoney) != 0) return false;

        if (oNum != null ? !oNum.equals(that.oNum) : that.oNum != null) return false;
        if (uName != null ? !uName.equals(that.uName) : that.uName != null) return false;
        if (gNum != null ? !gNum.equals(that.gNum) : that.gNum != null) return false;
        if (oPost != null ? !oPost.equals(that.oPost) : that.oPost != null) return false;

        if (oMsg != null ? !oMsg.equals(that.oMsg) : that.oMsg != null) return false;
        if (oPaystate != null ? !oPaystate.equals(that.oPaystate) : that.oPaystate != null) return false;
        if (oSendstate != null ? !oSendstate.equals(that.oSendstate) : that.oSendstate != null) return false;
        if (oOk != null ? !oOk.equals(that.oOk) : that.oOk != null) return false;
        if (oIsevaluate != null ? !oIsevaluate.equals(that.oIsevaluate) : that.oIsevaluate != null) return false;
        if (ggName != null ? !ggName.equals(that.ggName) : that.ggName != null) return false;
        if (lNum != null ? !lNum.equals(that.lNum) : that.lNum != null) return false;
        if (lTime != null ? !lTime.equals(that.lTime) : that.lTime != null) return false;
        if (lName != null ? !lName.equals(that.lName) : that.lName != null) return false;
        if (sName != null ? !sName.equals(that.sName) : that.sName != null) return false;
        if (sIcon != null ? !sIcon.equals(that.sIcon) : that.sIcon != null) return false;
        if (sPrice != null ? !sPrice.equals(that.sPrice) : that.sPrice != null) return false;
        if (sNum != null ? !sNum.equals(that.sNum) : that.sNum != null) return false;
        if (sSumprice != null ? !sSumprice.equals(that.sSumprice) : that.sSumprice != null) return false;
        if (ggPhone != null ? !ggPhone.equals(that.ggPhone) : that.ggPhone != null) return false;
        if (ggAddress != null ? !ggAddress.equals(that.ggAddress) : that.ggAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = oId;
        result = 31 * result + (oNum != null ? oNum.hashCode() : 0);
        result = 31 * result + (uName != null ? uName.hashCode() : 0);
        result = 31 * result + (gNum != null ? gNum.hashCode() : 0);
        temp = Double.doubleToLongBits(oMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));

        result = 31 * result + (oPost != null ? oPost.hashCode() : 0);

        result = 31 * result + (oMsg != null ? oMsg.hashCode() : 0);
        result = 31 * result + (oPaystate != null ? oPaystate.hashCode() : 0);
        result = 31 * result + (oSendstate != null ? oSendstate.hashCode() : 0);
        result = 31 * result + (oOk != null ? oOk.hashCode() : 0);
        result = 31 * result + (oIsevaluate != null ? oIsevaluate.hashCode() : 0);
        result = 31 * result + (ggName != null ? ggName.hashCode() : 0);
        result = 31 * result + (lNum != null ? lNum.hashCode() : 0);
        result = 31 * result + (lTime != null ? lTime.hashCode() : 0);
        result = 31 * result + (lName != null ? lName.hashCode() : 0);
        result = 31 * result + (sName != null ? sName.hashCode() : 0);
        result = 31 * result + (sIcon != null ? sIcon.hashCode() : 0);
        result = 31 * result + (sPrice != null ? sPrice.hashCode() : 0);
        result = 31 * result + (sNum != null ? sNum.hashCode() : 0);
        result = 31 * result + (sSumprice != null ? sSumprice.hashCode() : 0);
        result = 31 * result + (ggPhone != null ? ggPhone.hashCode() : 0);
        result = 31 * result + (ggAddress != null ? ggAddress.hashCode() : 0);
        return result;
    }
}
