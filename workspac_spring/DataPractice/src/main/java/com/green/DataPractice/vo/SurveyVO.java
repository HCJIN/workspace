package com.green.DataPractice.vo;

import java.util.List;

public class SurveyVO {
    private String intro;
    private String man;
    private List<String> check;
    private String select;

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public List<String> getCheck() {
        return check;
    }

    public void setCheck(List<String> check) {
        this.check = check;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    @Override
    public String toString() {
        return "SurveyVO{" +
                "intro='" + intro + '\'' +
                ", man='" + man + '\'' +
                ", check=" + check +
                ", select='" + select + '\'' +
                '}';
    }
}
