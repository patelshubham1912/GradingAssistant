package com.shubham.Beans;

/**
 * Created by $hubham on 22/11/2016.
 */

public class grading_criteria {
    private String course_id;
    private float assignment_percentage;
    private float quiz_percentage;
    private float project_percentage;
    private float midterm_percentage;
    private float final_percentage;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public float getAssignment_percentage() {
        return assignment_percentage;
    }

    public void setAssignment_percentage(float assignment_percentage) {
        this.assignment_percentage = assignment_percentage;
    }

    public float getQuiz_percentage() {
        return quiz_percentage;
    }

    public void setQuiz_percentage(float quiz_percentage) {
        this.quiz_percentage = quiz_percentage;
    }

    public float getProject_percentage() {
        return project_percentage;
    }

    public void setProject_percentage(float project_percentage) {
        this.project_percentage = project_percentage;
    }

    public float getMidterm_percentage() {
        return midterm_percentage;
    }

    public void setMidterm_percentage(float midterm_percentage) {
        this.midterm_percentage = midterm_percentage;
    }

    public float getFinal_percentage() {
        return final_percentage;
    }

    public void setFinal_percentage(float final_percentage) {
        this.final_percentage = final_percentage;
    }
}
