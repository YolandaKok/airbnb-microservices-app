package com.yolanda.kokkinou.airbnbservice.dto;

public class ReviewDto {
    private String comment;
    private Integer score;

    private Long unitId;

    private Long userId;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ReviewDto{" +
                "comment='" + comment + '\'' +
                ", score=" + score +
                ", unitId=" + unitId +
                ", userId=" + userId +
                '}';
    }
}
