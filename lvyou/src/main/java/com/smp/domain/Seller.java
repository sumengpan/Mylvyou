package com.smp.domain;

public class Seller {
    private int sid;//商家id
    private String sname;//商家名称
    private String consphone;//商家电话
    private String address;//商家地址

    //全参
    public Seller(int sid, String sname, String consphone, String address){
        this.sid=sid;
        this.sname=sname;
        this.consphone=consphone;
        this.address=address;
    }
    //无参
    public Seller(){

    }

    @Override
    public String toString() {
        return "Seller{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", consphone='" + consphone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getConsphone() {
        return consphone;
    }

    public void setConsphone(String consphone) {
        this.consphone = consphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
