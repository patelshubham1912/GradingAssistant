package com.shubham.Beans;

/**
 * Created by $hubham on 22/11/2016.
 */

public class student {
    private String student_id;
    private String course_id;
    private String student_name;
    private String student_email_id;
    private String student_pwd;
    private float gpa;
    private String degree_type;
    private String specialization_type;

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

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_email_id() {
        return student_email_id;
    }

    public void setStudent_email_id(String student_email_id) {
        this.student_email_id = student_email_id;
    }

    public String getStudent_pwd() {
        return student_pwd;
    }

    public void setStudent_pwd(String student_pwd) {
        this.student_pwd = student_pwd;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getDegree_type() {
        return degree_type;
    }

    public void setDegree_type(String degree_type) {
        this.degree_type = degree_type;
    }

    public String getSpecialization_type() {
        return specialization_type;
    }

    public void setSpecialization_type(String specialization_type) {
        this.specialization_type = specialization_type;
    }
}
