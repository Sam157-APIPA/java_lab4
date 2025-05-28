package org.example;
import java.util.Date;

/**
 * Класс, представляющий подразделение организации.
 * <p>
 * Каждый объект содержит уникальный идентификатор и название подразделения.
 * </p>
 */
public class Department {
    /**
     * Уникальный идентификатор подразделения.
     */
    private String id;

    /**
     * Название подразделения.
     */
    private String name;

    /**
     * Создает новое подразделение с указанными идентификатором и названием.
     *
     * @param id   уникальный идентификатор подразделения
     * @param name название подразделения
     */
    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Возвращает уникальный идентификатор подразделения.
     *
     * @return идентификатор подразделения
     */
    public String getId() {
        return id;
    }

    /**
     * Устанавливает уникальный идентификатор подразделения.
     *
     * @param id новый идентификатор
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Возвращает название подразделения.
     *
     * @return название подразделения
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает название подразделения.
     *
     * @param name новое название подразделения
     */
    public void setName(String name) {
        this.name = name;
    }
}