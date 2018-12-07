package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "evaluation", schema = "secondproject")
@DynamicInsert(value = true)
public class EvaluationEntity  {
    private int eId;
    private String gNum;
    private String oNum;

    /*private OrdersEntity ordersEntity;*/
    private UserEntity userEntity;
    /*private int uId; */
    private BigDecimal eStar;
    private String eEval;
    private Timestamp eTime;
    private String eReply;



    /*@ManyToOne(targetEntity = OrdersEntity.class)
    @JoinColumn(name="o_num",referencedColumnName = "o_num")
    public OrdersEntity getOrdersEntity() {
        return ordersEntity;
    }

    public void setOrdersEntity(OrdersEntity ordersEntity) {
        this.ordersEntity = ordersEntity;
    }*/

    @ManyToOne(targetEntity = UserEntity.class)
    @JoinColumn(name="u_id",referencedColumnName = "u_id")

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }


    @Id
    @Column(name = "e_id")
    public int geteId() {
        return eId;
    }

    public void seteId(int eId) {
        this.eId = eId;
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
    @Column(name = "o_num")
    public String getoNum() {
        return oNum;
    }

    public void setoNum(String oNum) {
        this.oNum = oNum;
    }

  /*  @Basic
    @Column(name = "u_id")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }*/
    @Basic
    @Column(name = "e_star",columnDefinition = "double(10,2) default '1.00'")
    public BigDecimal geteStar() {
        return eStar;
    }

    public void seteStar(BigDecimal eStar) {
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

    @Basic
    @Column(name = "e_reply")
    public String geteReply() {
        return eReply;
    }

    public void seteReply(String eReply) {
        this.eReply = eReply;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EvaluationEntity that = (EvaluationEntity) o;

        if (eId != that.eId) return false;

        /*if (uId != that.uId) return false;*/
        if (gNum != null ? !gNum.equals(that.gNum) : that.gNum != null) return false;
        /*if (oNum != null ? !oNum.equals(that.oNum) : that.oNum != null) return false;*/

        if (eStar != null ? !eStar.equals(that.eStar) : that.eStar != null) return false;
        if (eEval != null ? !eEval.equals(that.eEval) : that.eEval != null) return false;
        if (eTime != null ? !eTime.equals(that.eTime) : that.eTime != null) return false;
        if (eReply != null ? !eReply.equals(that.eReply) : that.eReply != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = eId;
        result = 31 * result + (gNum != null ? gNum.hashCode() : 0);

       /* result = 31 * result + (oNum != null ? oNum.hashCode() : 0);*/
       /* result = 31 * result + uId;*/

        result = 31 * result + (eStar != null ? eStar.hashCode() : 0);
        result = 31 * result + (eEval != null ? eEval.hashCode() : 0);
        result = 31 * result + (eTime != null ? eTime.hashCode() : 0);
        result = 31 * result + (eReply != null ? eReply.hashCode() : 0);
        return result;
    }
}
