package com.techproed.pojos;

public class TodosPojo1 {

       /*
    {
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
}
     */

    private int userId;
    private int Id;
    private String title;
    private boolean completed;

    public TodosPojo1(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        Id = id;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "TodosPojo1{" +
                "userId=" + userId +
                ", Id=" + Id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
