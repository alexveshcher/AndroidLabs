package com.naukma.alex.task3sqlite;

/**
 * Created by alex on 4/16/16.
 */
public class Todo {
    private int id;
    private String title, descr;


    public Todo(int id, String title, String descr) {
        this.id = id;
        this.title = title;
        this.descr = descr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
