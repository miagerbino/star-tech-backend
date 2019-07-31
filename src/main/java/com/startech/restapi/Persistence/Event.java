package com.startech.restapi.Persistence;

import javax.persistence.*;

@Entity
@Table(name="event")
public class Event {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="userID")
    private Long userID;

    @Column(name="title")
    private String title;

    @Column(name="location")
    private String location;

    @Column(name="month")
    private String month;

    @Column(name="day")
    private String day;

    @Column(name="startTime")
    private String startTime;

    @Column(name="endTime")
    private String endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userid) {
        this.userID = userid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Event(Long userID, String title, String location, String month, String day, String startTime, String endTime) {
        this.userID = userID;
        this.title = title;
        this.location = location;
        this.month = month;
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Event() {
    }
}
