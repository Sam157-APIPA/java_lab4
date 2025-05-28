package org.example;
import java.util.Date;

public class Department {
    private String id;
    private String name;

    // Конструктор, геттеры и сеттеры
    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Геттеры и сеттеры
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}