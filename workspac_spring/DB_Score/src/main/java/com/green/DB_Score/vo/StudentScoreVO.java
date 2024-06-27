package com.green.DB_Score.vo;

import lombok.Data;

@Data
public class StudentScoreVO {
    private int stuNum;
    private String stuName;
    private int korScore;
    private int engScore;
    private String intro;
}
