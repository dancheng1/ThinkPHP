package com.ky.workover.common.utils;

/**
 */
public class Result {

    public final static int SUCCESS = 0;
    public final static int NETERROR = 100;
    public final static int EXCEPTION = 200;
    public final static int FAIL = 300;

    private Object result;
    private int status;
    private long timestamp;


    public boolean isSuccess() {
        if (this.getStatus() == Result.SUCCESS) {
            return true;
        }

        return false;
    }



    public static Result success(Object result) {
        Result ret = new Result();
        ret.setResult(result);
        ret.setStatus(Result.SUCCESS);
        ret.setTimestamp(System.currentTimeMillis());

        return ret;
    }

    public static Result neterr(Exception e) {
        Result ret = new Result();
        ret.setResult(e.getMessage());
        ret.setStatus(Result.NETERROR);
        ret.setTimestamp(System.currentTimeMillis());

        e.printStackTrace();

        return ret;
    }

    public static Result err(Exception e) {
        Result ret = new Result();
        ret.setResult(e.getMessage());
        ret.setStatus(Result.EXCEPTION);
        ret.setTimestamp(System.currentTimeMillis());

        e.printStackTrace();

        return ret;
    }

    public static Result fail(Object result) {
        Result ret = new Result();
        ret.setResult(result);
        ret.setStatus(Result.EXCEPTION);
        ret.setTimestamp(System.currentTimeMillis());

        return ret;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
