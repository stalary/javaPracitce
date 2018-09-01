/**
 * @(#)Express.java, 2018-09-01.
 * <p>
 * Copyright 2018 Stalary.
 */
package com.stalary.designpattern.prototype;

/**
 * Express
 *
 * @author lirongqian
 * @since 2018/09/01
 */
public class Express implements Cloneable {

    private String receiver;

    private String sender;

    private String goods;

    private String receiveAddress;

    private String sendAddress;

    public Express(String sender, String sendAddress) {
        this.sender = sender;
        this.sendAddress = sendAddress;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public void setReceiveAddress(String receiveAddress) {
        this.receiveAddress = receiveAddress;
    }

    @Override
    protected Express clone() {
        try {
            return (Express) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Express{" +
                "receiver='" + receiver + '\'' +
                ", sender='" + sender + '\'' +
                ", goods='" + goods + '\'' +
                ", receiveAddress='" + receiveAddress + '\'' +
                ", sendAddress='" + sendAddress + '\'' +
                '}';
    }
}