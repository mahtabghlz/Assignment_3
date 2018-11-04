package com.company.company;

import com.company.company.employee;

public class user extends employee {

    String username ,password;;

    public user(String name, String lastName, String natCode, String address, String mobile, int birth, String username, String password) {
        super(name, lastName, natCode, address, mobile, birth);

        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
