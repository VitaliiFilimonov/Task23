package ru.homework;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
    private String name;
    private int age;
    private int id;
    private String language;

    public int getId() {
        return id;
    }

    @XmlElement
    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @XmlElement
    public void setAge(int age) {
        this.age = age;
    }

    public String getLanguage() {
        return language;
    }

    @XmlElement
    public void setLanguage(String language) {
        this.language = language;
    }

    public String toString(){
        return "Student{name = " + this.name + ", age = " + getAge() +
                ", id = " + getId() + ", language = " + getLanguage() +
                "}";
    }
}
