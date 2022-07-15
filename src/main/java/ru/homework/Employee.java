package ru.homework;

public class Employee {
    private String name, job;

    public Employee(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public Employee(){

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString(){
        return "Сотрудник: Name = " + this.name + ", Job = " + this.job;
    }
}
