package com.ky.workover.boreturn.model;

import com.ky.workover.corp.model.CorpSummaryDetail;

import java.util.List;

/**
 * Created by Administrator on 2017/2/22.
 */
public class BoreturnCustom {
    private List<CorpSummaryDetail> list;

    private String no;

    private String userId1;

    private String userId2;

    private String lqTime;

    private String ghTime;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public List<CorpSummaryDetail> getList() {
        return list;
    }

    public void setList(List<CorpSummaryDetail> list) {
        this.list = list;
    }

    public String getUserId1() {
        return userId1;
    }

    public void setUserId1(String userId1) {
        this.userId1 = userId1;
    }

    public String getUserId2() {
        return userId2;
    }

    public void setUserId2(String userId2) {
        this.userId2 = userId2;
    }

    public String getLqTime() {
        return lqTime;
    }

    public void setLqTime(String lqTime) {
        this.lqTime = lqTime;
    }

    public String getGhTime() {
        return ghTime;
    }

    public void setGhTime(String ghTime) {
        this.ghTime = ghTime;
    }
}
