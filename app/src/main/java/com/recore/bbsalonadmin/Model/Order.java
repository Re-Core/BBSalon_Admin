package com.recore.bbsalonadmin.Model;

import com.google.firebase.database.ServerValue;

public class Order {
    private String orderId;
    private String username;
    private String phone;
    private String date;
    private String time;
    private String state;
    private String bill;
    private String paid;
    private Object timeStamp;

    public Order() {
        timeStamp = ServerValue.TIMESTAMP;
    }

    public Order(String orderId, String username, String phone, String date, String time, String state, String bill, String paid) {
        this.orderId = orderId;
        this.username = username;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.state = state;
        this.bill = bill;
        this.paid = paid;
        timeStamp = ServerValue.TIMESTAMP;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getBill() {
        return bill;
    }

    public void setBill(String bill) {
        this.bill = bill;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public Object getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Object timeStamp) {
        this.timeStamp = timeStamp;
    }


}
