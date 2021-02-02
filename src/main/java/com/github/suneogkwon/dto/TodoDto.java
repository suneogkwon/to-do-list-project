package com.github.suneogkwon.dto;

import java.time.LocalDate;

public class TodoDto {
    private Long id;
    private String title;
    private String name;
    private int sequence;
    private String type = "TODO";
    private String regdate = String.valueOf(LocalDate.now());

    @Override
    public String toString() {
        return "TodoDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name='" + name + '\'' +
                ", sequence=" + sequence +
                ", type='" + type + '\'' +
                ", regdate='" + regdate + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }
}
