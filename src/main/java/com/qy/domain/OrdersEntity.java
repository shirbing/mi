package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders", schema = "secondproject", catalog = "")
@DynamicInsert(value = true)
public class OrdersEntity {
    private int oId;
    private String oNum;
    private String uName;
    private String gNum;
    private double oMoney;
    private double oPost;
    private String oMsg;
    private String ggName;
    private Timestamp oOrdertime;
    private String oPaytime;
    private String oPaystate;
    private String oSendstate;
    private String oOk;
    private String oIsevaluate;

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
    public double getoPost() {
        return oPost;
    }

    public void setoPost(double oPost) {
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
    @Column(name = "gg_name")
    public String getGgName() {
        return ggName;
    }

    public void setGgName(String ggName) {
        this.ggName = ggName;
    }

    @Basic
    @Column(name = "o_ordertime")
    public Timestamp getoOrdertime() {
        return oOrdertime;
    }

    public void setoOrdertime(Timestamp oOrdertime) {
        this.oOrdertime = oOrdertime;
    }

    @Basic
    @Column(name = "o_paytime")
    public String getoPaytime() {
        return oPaytime;
    }

    public void setoPaytime(String oPaytime) {
        this.oPaytime = oPaytime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrdersEntity that = (OrdersEntity) o;

        if (oId != that.oId) return false;
        if (Double.compare(that.oMoney, oMoney) != 0) return false;
        if (Double.compare(that.oPost, oPost) != 0) return false;
        if (oNum != null ? !oNum.equals(that.oNum) : that.oNum != null) return false;
        if (uName != null ? !uName.equals(that.uName) : that.uName != null) return false;
        if (gNum != null ? !gNum.equals(that.gNum) : that.gNum != null) return false;
        if (oMsg != null ? !oMsg.equals(that.oMsg) : that.oMsg != null) return false;
        if (ggName != null ? !ggName.equals(that.ggName) : that.ggName != null) return false;
        if (oOrdertime != null ? !oOrdertime.equals(that.oOrdertime) : that.oOrdertime != null) return false;
        if (oPaytime != null ? !oPaytime.equals(that.oPaytime) : that.oPaytime != null) return false;
        if (oPaystate != null ? !oPaystate.equals(that.oPaystate) : that.oPaystate != null) return false;
        if (oSendstate != null ? !oSendstate.equals(that.oSendstate) : that.oSendstate != null) return false;
        if (oOk != null ? !oOk.equals(that.oOk) : that.oOk != null) return false;
        if (oIsevaluate != null ? !oIsevaluate.equals(that.oIsevaluate) : that.oIsevaluate != null) return false;

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
        temp = Double.doubleToLongBits(oPost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (oMsg != null ? oMsg.hashCode() : 0);
        result = 31 * result + (ggName != null ? ggName.hashCode() : 0);
        result = 31 * result + (oOrdertime != null ? oOrdertime.hashCode() : 0);
        result = 31 * result + (oPaytime != null ? oPaytime.hashCode() : 0);
        result = 31 * result + (oPaystate != null ? oPaystate.hashCode() : 0);
        result = 31 * result + (oSendstate != null ? oSendstate.hashCode() : 0);
        result = 31 * result + (oOk != null ? oOk.hashCode() : 0);
        result = 31 * result + (oIsevaluate != null ? oIsevaluate.hashCode() : 0);
        return result;
    }
}
