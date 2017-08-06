package com.ky.workover.boreturn.model;

public class Boreturn {
    private Integer id;

    private String orderId;

    private Integer sum;

    private String userId;

    private String lqTime;

    private String spId;

    private String spTime;

    private String ghTime;

    private Integer type;

    private String note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLqTime() {
        return lqTime;
    }

    public void setLqTime(String lqTime) {
        this.lqTime = lqTime == null ? null : lqTime.trim();
    }

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId == null ? null : spId.trim();
    }

    public String getSpTime() {
        return spTime;
    }

    public void setSpTime(String spTime) {
        this.spTime = spTime == null ? null : spTime.trim();
    }

    public String getGhTime() {
        return ghTime;
    }

    public void setGhTime(String ghTime) {
        this.ghTime = ghTime == null ? null : ghTime.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}