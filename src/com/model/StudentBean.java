package com.model;

public class StudentBean {
    private String xh;
    private String xm;
    private String xb;
    private String password;
    public StudentBean(String xh,String xm,String xb,String password){
        this.xh = xh;
        this.xm = xm;
        this.xb = xb;
        this.password = password;
    }

    public String getXh() {
        return xh;
    }

    public void setXh(String xh) {
        this.xh = xh;
    }
    public String getXm() {
        return xm;
    }
    public void setXm(String xm) {
        this.xm = xm;
    }
    public String getXb() {
        return xb;
    }
    public void setXb(String xb) {
        this.xb = xb;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
