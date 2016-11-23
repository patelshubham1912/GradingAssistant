package com.shubham.Beans;

/**
 * Created by $hubham on 22/11/2016.
 */

public class graded_report {

    private String course_id;
    private String type_id;
    private float mean;
    private float median;
    private float standard_deviation;
    private float highest_score;
    private float lowest_score;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public float getMean() {
        return mean;
    }

    public void setMean(float mean) {
        this.mean = mean;
    }

    public float getMedian() {
        return median;
    }

    public void setMedian(float median) {
        this.median = median;
    }

    public float getStandard_deviation() {
        return standard_deviation;
    }

    public void setStandard_deviation(float standard_deviation) {
        this.standard_deviation = standard_deviation;
    }

    public float getHighest_score() {
        return highest_score;
    }

    public void setHighest_score(float highest_score) {
        this.highest_score = highest_score;
    }

    public float getLowest_score() {
        return lowest_score;
    }

    public void setLowest_score(float lowest_score) {
        this.lowest_score = lowest_score;
    }
}
