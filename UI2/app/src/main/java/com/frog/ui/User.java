package com.frog.ui;

import cn.bmob.v3.BmobUser;

public class User extends BmobUser {

    private String nickname;
    private String img;
    private String yid;
    private Double cash;
    private int coin;

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public Double getCash() {
        return cash;
    }

    public int getCoin() {
        return coin;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getYid() {
        return yid;
    }

    public void setYid(String yid) {
        this.yid = yid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


}
