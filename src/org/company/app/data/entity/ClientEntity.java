package org.company.app.data.entity;

import java.util.Date;

public class ClientEntity
{
    private int id;
    private String firstname;
    private String lastname;
    private String patronymic;
    private Date birthday;
    private Date regDate;
    private String email;
    private String phone;
    private char genderCode;
    private char grus;
    private char pricep;
    private String photoPath;

    public ClientEntity(int id, String firstname, String lastname, String patronymic, Date birthday, Date regDate, String email, String phone, char genderCode, String photoPath) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.regDate = regDate;
        this.email = email;
        this.phone = phone;
        this.genderCode = genderCode;
        this.photoPath = photoPath;
    }

    public ClientEntity(String firstname, String lastname, String patronymic, Date birthday, Date regDate, String email, String phone, char genderCode, String photoPath) {
        this.id = -1;
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.birthday = birthday;
        this.regDate = regDate;
        this.email = email;
        this.phone = phone;
        this.genderCode = genderCode;
        this.photoPath = photoPath;
    }

    public ClientEntity(String firstname, String lastname, String patronymic, Date regDate, String email, String phone, char pricep, char grus) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.patronymic = patronymic;
        this.regDate = regDate;
        this.email = email;
        this.phone = phone;
        this.pricep = pricep;
        this.grus = grus;

    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthday=" + birthday +
                ", regDate=" + regDate +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", genderCode=" + genderCode +
                ", grus=" + grus +
                ", pricep=" + pricep +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public ClientEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getFirstname() {
        return firstname;
    }

    public ClientEntity setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public String getLastname() {
        return lastname;
    }

    public ClientEntity setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public ClientEntity setPatronymic(String patronymic) {
        this.patronymic = patronymic;
        return this;
    }

    public Date getBirthday() {
        return birthday;
    }

    public ClientEntity setBirthday(Date birthday) {
        this.birthday = birthday;
        return this;
    }

    public Date getRegDate() {
        return regDate;
    }

    public ClientEntity setRegDate(Date regDate) {
        this.regDate = regDate;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public ClientEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public ClientEntity setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public char getGenderCode() {
        return genderCode;
    }

    public ClientEntity setGenderCode(char genderCode) {
        this.genderCode = genderCode;
        return this;
    }

    public char getGrus() {
        return grus;
    }

    public void setGrus(char grus) {
        this.grus = grus;
    }

    public char getPricep() {
        return pricep;
    }

    public void setPricep(char pricep) {
        this.pricep = pricep;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public ClientEntity setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
        return this;
    }
}
