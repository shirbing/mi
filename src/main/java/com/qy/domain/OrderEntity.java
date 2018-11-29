package com.qy.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "order", schema = "secondproject", catalog = "")
public class OrderEntity {
    private int oId;
    private int oNum;
    private String uPhone;
    private int gId;
    private double oMoney;
    private double oPost;
    private String oMsg;
    private int ggId;
    private Timestamp oOrdertime;
    private String oPaytime;
    private String oPaystate;
    private String oSendstate;
    private String oOk;
    private String oTime;
    private int oCount;
    private String oName;

    @Id
    @Column(name = "o_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getoId() {
        return oId;
    }

    public void setoId(int oId) {
        this.oId = oId;
    }

    @Basic
    @Column(name = "o_num")
    public int getoNum() {
        return oNum;
    }

    public void setoNum(int oNum) {
        this.oNum = oNum;
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
    @Column(name = "g_id")
    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
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
    @Column(name = "gg_id")
    public int getGgId() {
        return ggId;
    }

    public void setGgId(int ggId) {
        this.ggId = ggId;
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
    @Column(name = "o_time")
    public String getoTime() {
        return oTime;
    }

    public void setoTime(String oTime) {
        this.oTime = oTime;
    }

    @Basic
    @Column(name = "o_count")
    public int getoCount() {
        return oCount;
    }

    public void setoCount(int oCount) {
        this.oCount = oCount;
    }

    @Basic
    @Column(name = "o_name")
    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (oId != that.oId) return false;
        if (oNum != that.oNum) return false;
        if (gId != that.gId) return false;
        if (Double.compare(that.oMoney, oMoney) != 0) return false;
        if (Double.compare(that.oPost, oPost) != 0) return false;
        if (ggId != that.ggId) return false;
        if (oCount != that.oCount) return false;
        if (uPhone != null ? !uPhone.equals(that.uPhone) : that.uPhone != null) return false;
        if (oMsg != null ? !oMsg.equals(that.oMsg) : that.oMsg != null) return false;
        if (oOrdertime != null ? !oOrdertime.equals(that.oOrdertime) : that.oOrdertime != null) return false;
        if (oPaytime != null ? !oPaytime.equals(that.oPaytime) : that.oPaytime != null) return false;
        if (oPaystate != null ? !oPaystate.equals(that.oPaystate) : that.oPaystate != null) return false;
        if (oSendstate != null ? !oSendstate.equals(that.oSendstate) : that.oSendstate != null) return false;
        if (oOk != null ? !oOk.equals(that.oOk) : that.oOk != null) return false;
        if (oTime != null ? !oTime.equals(that.oTime) : that.oTime != null) return false;
        if (oName != null ? !oName.equals(that.oName) : that.oName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = oId;
        result = 31 * result + oNum;
        result = 31 * result + (uPhone != null ? uPhone.hashCode() : 0);
        result = 31 * result + gId;
        temp = Double.doubleToLongBits(oMoney);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(oPost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (oMsg != null ? oMsg.hashCode() : 0);
        result = 31 * result + ggId;
        result = 31 * result + (oOrdertime != null ? oOrdertime.hashCode() : 0);
        result = 31 * result + (oPaytime != null ? oPaytime.hashCode() : 0);
        result = 31 * result + (oPaystate != null ? oPaystate.hashCode() : 0);
        result = 31 * result + (oSendstate != null ? oSendstate.hashCode() : 0);
        result = 31 * result + (oOk != null ? oOk.hashCode() : 0);
        result = 31 * result + (oTime != null ? oTime.hashCode() : 0);
        result = 31 * result + oCount;
        result = 31 * result + (oName != null ? oName.hashCode() : 0);
        return result;
    }
}
