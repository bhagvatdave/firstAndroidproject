package com.example.firsttestproject.josn_parsing;

public class Tempdata {
    String title;

    @Override
    public String toString() {
        return "Tempdata{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }

    String body;

    public Tempdata(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
