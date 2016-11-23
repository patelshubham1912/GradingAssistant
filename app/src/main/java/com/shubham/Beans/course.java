package com.shubham.Beans;

/**
 * Created by $hubham on 22/11/2016.
 */

public class course {

    private String course_id;
    private String professor_id;
    private String course_name;
    private String specialization_type;
    private String degree_type;
    private String number_of_students;
    private float average;
    private int credit_hours;
    private String pre_requisite;
    private String course_description;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(String professor_id) {
        this.professor_id = professor_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getSpecialization_type() {
        return specialization_type;
    }

    public void setSpecialization_type(String specialization_type) {
        this.specialization_type = specialization_type;
    }

    public String getDegree_type() {
        return degree_type;
    }

    public void setDegree_type(String degree_type) {
        this.degree_type = degree_type;
    }

    public String getNumber_of_students() {
        return number_of_students;
    }

    public void setNumber_of_students(String number_of_students) {
        this.number_of_students = number_of_students;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    public int getCredit_hours() {
        return credit_hours;
    }

    public void setCredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }

    public String getPre_requisite() {
        return pre_requisite;
    }

    public void setPre_requisite(String pre_requisite) {
        this.pre_requisite = pre_requisite;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }
}
