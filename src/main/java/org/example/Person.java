package org.example;

import java.util.Date;

/**
 * Класс, описывающий сотрудника организации.
 * <p>
 * Содержит информацию об идентификаторе, имени, поле, подразделении,
 * заработной плате и дате рождения.</p>
 */
public class Person {
    /**
     * Уникальный идентификатор сотрудника.
     */
    private String id;

    /**
     * Полное имя сотрудника.
     */
    private String name;

    /**
     * Пол сотрудника (например, "Male", "Female").
     */
    private String gender;

    /**
     * Подразделение, в котором работает сотрудник.
     */
    private Department department;

    /**
     * Заработная плата сотрудника.
     */
    private double salary;

    /**
     * Дата рождения сотрудника.
     */
    private Date birthDate;

    /**
     * Создает нового сотрудника с заданными параметрами.
     *
     * @param id          уникальный идентификатор сотрудника
     * @param name        полное имя сотрудника
     * @param gender      пол сотрудника
     * @param department  подразделение сотрудника
     * @param salary      заработная плата
     * @param birthDate   дата рождения
     */
    public Person(String id, String name, String gender, Department department, double salary, Date birthDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    /**
     * Возвращает уникальный идентификатор сотрудника.
     *
     * @return идентификатор сотрудника
     */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор сотрудника.
     *
     * @param id новый идентификатор сотрудника
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Возвращает полное имя сотрудника.
     *
     * @return имя сотрудника
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает полное имя сотрудника.
     *
     * @param name новое имя сотрудника
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает пол сотрудника.
     *
     * @return пол (например, "Male", "Female")
     */
    public String getGender() {
        return gender;
    }

    /**
     * Устанавливает пол сотрудника.
     *
     * @param gender новый пол сотрудника
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Возвращает подразделение сотрудника.
     *
     * @return объект {@link Department}
     */
    public Department getDepartment() {
        return department;
    }

    /**
     * Устанавливает подразделение сотрудника.
     *
     * @param department новое подразделение
     */
    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * Возвращает текущую заработную плату сотрудника.
     *
     * @return зарплата
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Устанавливает заработную плату сотрудника.
     *
     * @param salary новая зарплата
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Возвращает дату рождения сотрудника.
     *
     * @return дата рождения
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Устанавливает дату рождения сотрудника.
     *
     * @param birthDate новая дата рождения
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}