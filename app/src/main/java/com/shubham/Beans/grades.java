package com.shubham.Beans;

/**
 * Created by $hubham on 22/11/2016.
 */

public class grades {

    private String student_id;
    private String course_id;
    private float assignment_percentage;
    private float quiz_grade;
    private float project_percentage;
    private float midterm_grade;
    private float final_grade;

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

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

    public float getQuiz_grade() {
        return quiz_grade;
    }

    public void setQuiz_grade(float quiz_grade) {
        this.quiz_grade = quiz_grade;
    }

    public float getProject_percentage() {
        return project_percentage;
    }

    public void setProject_percentage(float project_percentage) {
        this.project_percentage = project_percentage;
    }

    public float getMidterm_grade() {
        return midterm_grade;
    }

    public void setMidterm_grade(float midterm_grade) {
        this.midterm_grade = midterm_grade;
    }

    public float getFinal_grade() {
        return final_grade;
    }

    public void setFinal_grade(float final_grade) {
        this.final_grade = final_grade;
    }
}
