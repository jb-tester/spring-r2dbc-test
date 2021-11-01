package com.mytests.spring.springr2dbctest;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * *
 * <p>Created by irina on 10/19/2021.</p>
 * <p>Project: spring-r2dbc-test</p>
 * *
 */
@Table("customer")
public class Customer {

    @Id
    int id;
    @Column("firstname")
    String firstName;
    @Column("lastname")
    String lastName;
    String birthday;
    String city;
    String street;
    int card;
    @Column("mobilephone")
    String mobilePhone;
    @Column("homephone")
    String homePhone;
    int credit;
    boolean vip;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isVip() {
        return vip;
    }

    public void setVip(boolean vip) {
        this.vip = vip;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", card=" + card +
                ", mobilephone='" + mobilePhone + '\'' +
                ", homephone='" + homePhone + '\'' +
                ", credit=" + credit +
                ", vip=" + vip +
                '}';
    }


}
