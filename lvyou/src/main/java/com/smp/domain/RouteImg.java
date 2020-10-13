package com.smp.domain;

//详情后台
public class RouteImg {
    private int rgid;//商品图片id
    private int rid;//商品id
    private String bigPic;//商品大图
    private String smallPic;//商品小图

    //全参
    public RouteImg(int rgid, int rid,String bigPic,String smallPic){
        this.rgid=rgid;
        this.rid=rid;
        this.bigPic=bigPic;
        this.smallPic=smallPic;
    }
    //无参
    public RouteImg() {
    }

    @Override
    public String toString() {
        return "RouteImg{" +
                "rgid=" + rgid +
                ", rid=" + rid +
                ", bigPic='" + bigPic + '\'' +
                ", smallPic='" + smallPic + '\'' +
                '}';
    }

    public int getRgid() {
        return rgid;
    }

    public void setRgid(int rgid) {
        this.rgid = rgid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }
}
