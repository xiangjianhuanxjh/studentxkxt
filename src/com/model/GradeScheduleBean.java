package com.model;

public class GradeScheduleBean {
    private String kh;
    private String km;
    private String xm;
    private String pscj;
    private String kscj;
    private String zpcj;
    public GradeScheduleBean(String kh, String km, String xm, String pscj, String kscj, String zpcj){
        this.kh = kh;
        this.km = km;
        this.xm = xm;
        this.pscj = pscj;
        this.kscj = kscj;
        this.zpcj = zpcj;
    }



    public String getKh() {
        return kh;
    }

    public void setKh(String kh) {
        this.kh = kh;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }

    public String getPscj() {
        return pscj;
    }

    public void setPscj(String pscj) {
        this.pscj = pscj;
    }

    public String getKscj() {
        return kscj;
    }

    public void setKscj(String kscj) {
        this.kscj = kscj;
    }

    public String getZpcj() {
        return zpcj;
    }

    public void setZpcj(String zpcj) {
        this.zpcj = zpcj;
    }
}
