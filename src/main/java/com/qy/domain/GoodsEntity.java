package com.qy.domain;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Table(name = "goods", schema = "secondproject", catalog = "")
@DynamicInsert(value = true)
public class GoodsEntity {
    private int gId;
    private Integer pNum;
    private String gName;
    private String gNum;
    private String gImg;
    private String gDetail;
    private Double gPrice;
    private Double gOffer;
    private Integer gInventory;
    private String gState;
    private Double gDiscount;
    private String gRecommend;
    private String gTryeat;

    @Id
    @Column(name = "g_id")
    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    @Basic
    @Column(name = "p_num")

    public Integer getpNum() {
        return pNum;
    }

    public void setpNum(Integer pNum) {

        this.pNum = pNum;
    }

    @Basic
    @Column(name = "g_name")
    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
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
    @Column(name = "g_img")
    public String getgImg() {
        return gImg;
    }

    public void setgImg(String gImg) {
        this.gImg = gImg;
    }

    @Basic
    @Column(name = "g_detail")
    public String getgDetail() {
        return gDetail;
    }

    public void setgDetail(String gDetail) {
        this.gDetail = gDetail;
    }

    @Basic
    @Column(name = "g_price")
    public Double getgPrice() {
        return gPrice;
    }

    public void setgPrice(Double gPrice) {
        this.gPrice = gPrice;
    }

    @Basic
    @Column(name = "g_offer")
    public Double getgOffer() {
        return gOffer;
    }

    public void setgOffer(Double gOffer) {
        this.gOffer = gOffer;
    }

    @Basic
    @Column(name = "g_inventory")
    public Integer getgInventory() {
        return gInventory;
    }

    public void setgInventory(Integer gInventory) {
        this.gInventory = gInventory;
    }

    @Basic
    @Column(name = "g_state")
    public String getgState() {
        return gState;
    }

    public void setgState(String gState) {
        this.gState = gState;
    }

    @Basic
    @Column(name = "g_discount")
    public Double getgDiscount() {
        return gDiscount;
    }

    public void setgDiscount(Double gDiscount) {
        this.gDiscount = gDiscount;
    }

    @Basic
    @Column(name = "g_recommend")
    public String getgRecommend() {
        return gRecommend;
    }

    public void setgRecommend(String gRecommend) {
        this.gRecommend = gRecommend;
    }

    @Basic
    @Column(name = "g_tryeat")
    public String getgTryeat() {
        return gTryeat;
    }

    public void setgTryeat(String gTryeat) {
        this.gTryeat = gTryeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodsEntity that = (GoodsEntity) o;

        if (gId != that.gId) return false;
        if (pNum != that.pNum) return false;
        if (gName != null ? !gName.equals(that.gName) : that.gName != null) return false;
        if (gNum != null ? !gNum.equals(that.gNum) : that.gNum != null) return false;
        if (gImg != null ? !gImg.equals(that.gImg) : that.gImg != null) return false;
        if (gDetail != null ? !gDetail.equals(that.gDetail) : that.gDetail != null) return false;
        if (gPrice != null ? !gPrice.equals(that.gPrice) : that.gPrice != null) return false;
        if (gOffer != null ? !gOffer.equals(that.gOffer) : that.gOffer != null) return false;
        if (gInventory != null ? !gInventory.equals(that.gInventory) : that.gInventory != null) return false;
        if (gState != null ? !gState.equals(that.gState) : that.gState != null) return false;
        if (gDiscount != null ? !gDiscount.equals(that.gDiscount) : that.gDiscount != null) return false;
        if (gRecommend != null ? !gRecommend.equals(that.gRecommend) : that.gRecommend != null) return false;
        if (gTryeat != null ? !gTryeat.equals(that.gTryeat) : that.gTryeat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {

        int result = gId;

        result = 31 * result + pNum;
        result = 31 * result + (gName != null ? gName.hashCode() : 0);
        result = 31 * result + (gNum != null ? gNum.hashCode() : 0);
        result = 31 * result + (gImg != null ? gImg.hashCode() : 0);
        result = 31 * result + (gDetail != null ? gDetail.hashCode() : 0);
        result = 31 * result + (gPrice != null ? gPrice.hashCode() : 0);
        result = 31 * result + (gOffer != null ? gOffer.hashCode() : 0);
        result = 31 * result + (gInventory != null ? gInventory.hashCode() : 0);
        result = 31 * result + (gState != null ? gState.hashCode() : 0);
        result = 31 * result + (gDiscount != null ? gDiscount.hashCode() : 0);
        result = 31 * result + (gRecommend != null ? gRecommend.hashCode() : 0);
        result = 31 * result + (gTryeat != null ? gTryeat.hashCode() : 0);
        return result;
    }
}
