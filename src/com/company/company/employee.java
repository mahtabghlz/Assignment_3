package com.company.company;

import java.util.ArrayList;

public class employee {
    String name ,lastName;
    String natCode ,address ,mobile;
    int birth;

    public employee(String name, String lastName, String natCode, String address, String mobile ,int birth) {
        this.name = name;
        this.lastName = lastName;
        this.natCode = natCode;
        this.address = address;
        this.mobile = mobile;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNatCode() {
        return natCode;
    }

    public String getAddress() {
        return address;
    }

    public String getMobile() {
        return mobile;
    }

    public int getBirth() {
        return birth;
    }

    public int age(int currentYear){
        return currentYear - birth;
    }

}
