package com.ky.workover.boreturn.model;

import com.ky.workover.corp.model.CorpSummaryDetail;

import java.util.List;

/**
 * Created by Administrator on 2017/2/25.
 */
public class BRList {
    private Boreturn boreturn;

    private List<CorpSummaryDetail> list;

    public Boreturn getBoreturn() {
        return boreturn;
    }

    public void setBoreturn(Boreturn boreturn) {
        this.boreturn = boreturn;
    }

    public List<CorpSummaryDetail> getList() {
        return list;
    }

    public void setList(List<CorpSummaryDetail> list) {
        this.list = list;
    }
}
