package com.ky.workover.work.model;

public class PersonWorkover {
    private Integer id;

    private String personno;

    private String personname;

    private String currentdate;

    private String starttime;

    private String endtime;

    private String lehgthtime;

    private String workcost;

    private String trafficcost;

    private String mealcost;

    private String suncost;

    private String creattime;

    private String creatby;

    private String updatetime;

    private String updateby;

    private String year;

    private String mouth;

    private String aduitstate;

    private String issuestate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPersonno() {
        return personno;
    }

    public void setPersonno(String personno) {
        this.personno = personno == null ? null : personno.trim();
    }

    public String getPersonname() {
        return personname;
    }

    public void setPersonname(String personname) {
        this.personname = personname == null ? null : personname.trim();
    }

    public String getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(String currentdate) {
        this.currentdate = currentdate == null ? null : currentdate.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }

    public String getLehgthtime() {
        return lehgthtime;
    }

    public void setLehgthtime(String lehgthtime) {
        this.lehgthtime = lehgthtime == null ? null : lehgthtime.trim();
    }

    public String getWorkcost() {
        return workcost;
    }

    public void setWorkcost(String workcost) {
        this.workcost = workcost == null ? null : workcost.trim();
    }

    public String getTrafficcost() {
        return trafficcost;
    }

    public void setTrafficcost(String trafficcost) {
        this.trafficcost = trafficcost == null ? null : trafficcost.trim();
    }

    public String getMealcost() {
        return mealcost;
    }

    public void setMealcost(String mealcost) {
        this.mealcost = mealcost == null ? null : mealcost.trim();
    }

    public String getSuncost() {
        return suncost;
    }

    public void setSuncost(String suncost) {
        this.suncost = suncost == null ? null : suncost.trim();
    }

    public String getCreattime() {
        return creattime;
    }

    public void setCreattime(String creattime) {
        this.creattime = creattime == null ? null : creattime.trim();
    }

    public String getCreatby() {
        return creatby;
    }

    public void setCreatby(String creatby) {
        this.creatby = creatby == null ? null : creatby.trim();
    }

    public String getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(String updatetime) {
        this.updatetime = updatetime == null ? null : updatetime.trim();
    }

    public String getUpdateby() {
        return updateby;
    }

    public void setUpdateby(String updateby) {
        this.updateby = updateby == null ? null : updateby.trim();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year == null ? null : year.trim();
    }

    public String getMouth() {
        return mouth;
    }

    public void setMouth(String mouth) {
        this.mouth = mouth == null ? null : mouth.trim();
    }

    public String getAduitstate() {
        return aduitstate;
    }

    public void setAduitstate(String aduitstate) {
        this.aduitstate = aduitstate == null ? null : aduitstate.trim();
    }

    public String getIssuestate() {
        return issuestate;
    }

    public void setIssuestate(String issuestate) {
        this.issuestate = issuestate == null ? null : issuestate.trim();
    }
}