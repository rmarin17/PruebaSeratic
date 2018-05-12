package com.seratic.net;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("success")
    private boolean exitoso;

    @SerializedName("message")
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isExitoso() {
        return exitoso;
    }

    public void setExitoso(boolean exitoso) {
        this.exitoso = exitoso;
    }
}
