package com.qy.domain;

import javax.persistence.*;

@Entity
@Table(name = "goods", schema = "secondproject", catalog = "")
public class GoodsEntity {
    private int gId;
    private int pId;
    private String gCover;
    private String gImg;
    private String gDetail;
    private double gPrice;
    private double gOffer;
    private int gInventory;
    private String gState;
    private double gDiscount;
    private String gRecommend;
    private String gTryeat;

    @Id
    @Column(name = "g_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getgId() {
        return gId;
    }

    public void setgId(int gId) {
        this.gId = gId;
    }

    @Basic
    @Column(name = "p_id")
    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    @Basic
    @Column(name = "g_cover")
    public String getgCover() {
        return gCover;
    }

    public void setgCover(String gCover) {
        this.gCover = gCover;
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
    public double getgPrice() {
        return gPrice;
    }

    public void setgPrice(double gPrice) {
        this.gPrice = gPrice;
    }

    @Basic
    @Column(name = "g_offer")
    public double getgOffer() {
        return gOffer;
    }

    public void setgOffer(double gOffer) {
        this.gOffer = gOffer;
    }

    @Basic
    @Column(name = "g_inventory")
    public int getgInventory() {
        return gInventory;
    }

    public void setgInventory(int gInventory) {
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
    public double getgDiscount() {
        return gDiscount;
    }

    public void setgDiscount(double gDiscount) {
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
        if (pId != that.pId) return false;
        if (Double.compare(that.gPrice, gPrice) != 0) return false;
        if (Double.compare(that.gOffer, gOffer) != 0) return false;
        if (gInventory != that.gInventory) return false;
        if (Double.compare(that.gDiscount, gDiscount) != 0) return false;
        if (gCover != null ? !gCover.equals(that.gCover) : that.gCover != null) return false;
        if (gImg != null ? !gImg.equals(that.gImg) : that.gImg != null) return false;
        if (gDetail != null ? !gDetail.equals(that.gDetail) : that.gDetail != null) return false;
        if (gState != null ? !gState.equals(that.gState) : that.gState != null) return false;
        if (gRecommend != null ? !gRecommend.equals(that.gRecommend) : that.gRecommend != null) return false;
        if (gTryeat != null ? !gTryeat.equals(that.gTryeat) : that.gTryeat != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = gId;
        result = 31 * result + pId;
        result = 31 * result + (gCover != null ? gCover.hashCode() : 0);
        result = 31 * result + (gImg != null ? gImg.hashCode() : 0);
        result = 31 * result + (gDetail != null ? gDetail.hashCode() : 0);
        temp = Double.doubleToLongBits(gPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(gOffer);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + gInventory;
        result = 31 * result + (gState != null ? gState.hashCode() : 0);
        temp = Double.doubleToLongBits(gDiscount);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (gRecommend != null ? gRecommend.hashCode() : 0);
        result = 31 * result + (gTryeat != null ? gTryeat.hashCode() : 0);
        return result;
    }
}
