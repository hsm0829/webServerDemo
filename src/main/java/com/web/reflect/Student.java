package com.web.reflect;


public class Student {
    public String name;
    public Integer age;
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student(String name, Integer age, Integer score) {

        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student() {

    }

    public String methodTest(String name, Integer age, Integer score, String remark){
        return "Student [name="+name+",age="+age+",score="+score+"]"+" "+remark;
    }
}
