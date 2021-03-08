package org.company.app.data.entity;

import java.sql.Timestamp;
import java.util.Date;

public class DTPEntity {
    private int id;
    private int number_situation;
    private char status;
    private char tip;
    private String area;
    private String area_radius;
    private Date time_of_detect;
    private String Situations_weathercol;
    private String road_quality;
    private String kordFild;


    public DTPEntity(int id, int number_situation, char status, char tip, String area, String area_radius, Date time_of_detect, String situations_weathercol, String road_quality, String kordFild) {
        this.id = id;
     
        this.status = status;
        this.tip = tip;
        this.area = area;
        this.area_radius = area_radius;
        this.time_of_detect = time_of_detect;
        Situations_weathercol = situations_weathercol;
        this.road_quality = road_quality;
        this.kordFild = kordFild;
    }

    public DTPEntity(char status, char tip, String area, String area_radius, Date time_of_detect, String situations_weathercol, String road_quality, String kordFild) {
        this.status = status;
        this.tip = tip;
        this.area = area;
        this.area_radius = area_radius;
        this.time_of_detect = time_of_detect;
        Situations_weathercol = situations_weathercol;
        this.road_quality = road_quality;
        this.kordFild = kordFild;
    }

    public DTPEntity(int id, char status, char tip, String area, String area_radius, Timestamp time_of_detect, String situations_weathercol, String road_quality, String kordFild) {
        this.id = id;
        this.status = status;
        this.tip =  tip;
        this.area = area;
        this.area_radius = area_radius;
        this.time_of_detect = time_of_detect;
        Situations_weathercol = situations_weathercol;
        this.road_quality = road_quality;
        this.kordFild = kordFild;
    }
    public DTPEntity( char status, char tip, String area, String area_radius, Timestamp time_of_detect, String situations_weathercol, String road_quality, String kordFild) {

        this.status = status;
        this.tip =  tip;
        this.area = area;
        this.area_radius = area_radius;
        this.time_of_detect = time_of_detect;
        Situations_weathercol = situations_weathercol;
        this.road_quality = road_quality;
        this.kordFild = kordFild;
    }




    @Override
    public String toString() {
        return "DTPEntity{" +
                "id=" + id +
                ", number_situation=" + number_situation +
                ", status=" + status +
                ", tip=" + tip +
                ", area='" + area + '\'' +
                ", area_radius=" + area_radius +
                ", time_of_detect=" + time_of_detect +
                ", Situations_weathercol='" + Situations_weathercol + '\'' +
                ", road_quality='" + road_quality + '\'' +
                ", kordFild=" + kordFild +
                '}';
    }

    public String getRoad_quality() {
        return road_quality;
    }

    public void setRoad_quality(String road_quality) {
        this.road_quality = road_quality;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber_situation() {
        return number_situation;
    }

    public void setNumber_situation(int number_situation) {
        this.number_situation = number_situation;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public char getTip() {
        return tip;
    }

    public void setTip(char tip) {
        this.tip = tip;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }



    public Date getTime_of_detect() {
        return time_of_detect;
    }

    public void setTime_of_detect(Date time_of_detect) {
        this.time_of_detect = time_of_detect;
    }

    public String getSituations_weathercol() {
        return Situations_weathercol;
    }

    public void setSituations_weathercol(String situations_weathercol) {
        Situations_weathercol = situations_weathercol;
    }

    public String getArea_radius() {
        return area_radius;
    }

    public void setArea_radius(String area_radius) {
        this.area_radius = area_radius;
    }

    public String getKordFild() {
        return kordFild;
    }

    public void setKordFild(String kordFild) {
        this.kordFild = kordFild;
    }

    public char status() {
        return status;
    }

    public String road_quality() {
        return road_quality;
    }
}