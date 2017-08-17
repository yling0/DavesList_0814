package me.yling.daveslist0814.models;

import org.springframework.boot.autoconfigure.web.ResourceProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room
{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;
    private int roomno;
    private String description;
    private String rule;
    private boolean wifi;
    private String cable;
    private boolean pbath;
    private String status;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRoomno() {
        return roomno;
    }

    public void setRoomno(int roomno) {
        this.roomno = roomno;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public String getCable() {
        return cable;
    }

    public void setCable(String cable) {
        this.cable = cable;
    }

    public boolean isPbath() {
        return pbath;
    }

    public void setPbath(boolean pbath) {
        this.pbath = pbath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void set(int roomno, String description, String rule, boolean wifi, String cable, boolean pbath, String status)
    {
        setRoomno(roomno);
        setDescription(description);
        setRule(rule);
        setWifi(wifi);
        setCable(cable);
        setPbath(pbath);
        setStatus(status);
    }




}
