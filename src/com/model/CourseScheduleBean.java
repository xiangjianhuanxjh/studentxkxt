package com.model;

public class CourseScheduleBean {
    private String kh;
    private String km;
    private String xf;
    private String gh;
    private String xm;
    private String sksj;
    private String jidian;

    public CourseScheduleBean(String kh, String km, String xf, String gh, String xm, String sksj) {
        this.kh = kh;
        this.km = km;
        this.xf = xf;
        this.gh = gh;
        this.xm = xm;
        this.sksj = sksj;
    }

    public CourseScheduleBean(String kh, String km, String xf, String xm, String jidian) {
        this.kh = kh;
        this.km = km;
        this.xf = xf;
        this.xm = xm;
        this.jidian = jidian;
    }

    public CourseScheduleBean(String kh, String km,String xf,String sksj){
        this.kh = kh;
        this.km = km;
        this.xf = xf;
        this.sksj = sksj;
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
    public String getXf() {
        return xf;
    }
    public void setXf(String xf) {
        this.xf = xf;
    }

    public String getGh() {
        return gh;
    }

    public void setGh(String gh) {
        this.gh = gh;
    }

    public String getXm() {
        return xm;
    }

    public void setXm(String xm) {
        this.xm = xm;
    }
    public String getSksj() {
        return sksj;
    }
    public void setSksj(String sksj) {
        this.sksj = sksj;
    }
    public String getJidian(){return jidian;}

    public void setJidian(String jidian) {
        this.jidian = jidian;
    }
}
