package com.green.DataPractice.vo;

public class ChickenVO {
    private String chicken;
    private int num;
    private String check;
    private String review;
    private String order;
    private String tel;
    private String add;

    public String getChicken() {
        return chicken;
    }

    public void setChicken(String chicken) {
        this.chicken = chicken;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    @Override
    public String toString() {
        return "ChickenVO{" +
                "chicken='" + chicken + '\'' +
                ", num=" + num +
                ", check='" + check + '\'' +
                ", review='" + review + '\'' +
                ", order='" + order + '\'' +
                ", tel='" + tel + '\'' +
                ", add='" + add + '\'' +
                '}';
    }
}
