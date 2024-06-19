package com.green.DataPractice.vo;

public class StudentVO {
    private String name;
    private String classNum;
    private String path;
    private String tel;
    private String gender;
    private int ko;
    private int en;
    private int math;
    private double total;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = (ko + en + math) / 3.0;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getKo() {
        return ko;
    }

    public void setKo(int ko) {
        this.ko = ko;
    }

    public int getEn() {
        return en;
    }

    public void setEn(int en) {
        this.en = en;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }


    @Override
    public String toString() {
        return "StudentVO{" +
                "name='" + name + '\'' +
                ", classNum='" + classNum + '\'' +
                ", path='" + path + '\'' +
                ", tel='" + tel + '\'' +
                ", gender='" + gender + '\'' +
                ", ko=" + ko +
                ", en=" + en +
                ", math=" + math +
                ", total=" + total +
                '}';
    }
}
