package br.com.bernard.tutoriais.list_view_example.model;

import java.io.Serializable;

/**
 * Created by bernard on 10/09/16.
 */
public class Car implements Serializable{
    private static final long serialVersionUID = 1L;


    Integer id;
    String name;
    String model;
    String engine;
    Integer year;

    public Car() {
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    public Car(Integer id, String name, String model, String engine, Integer year) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.engine = engine;
        this.year = year;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", engine='" + engine + '\'' +
                ", year=" + year +
                '}';
    }
}
