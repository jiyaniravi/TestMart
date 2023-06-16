/*
 * COPYRIGHT (C) 2023 MEREDITH COMPANY. ALL RIGHTS RESERVED.
 * UNAUTHORIZED COPYING, USE, OR DISTRIBUTION OF THIS SOFTWARE, OR ANY PORTION OF IT,
 * IS STRICTLY PROHIBITED. PROPRIETARY AND CONFIDENTIAL.
 */

package com.testmart.model;

import lombok.Data;

/**
 * @author Ravi Jiyani
 * @since 1.0.0
 */
@Data
public class User {
    private int id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private char[] password;
    private String birthDate;
    private String image;
    private String bloodGroup;
    private float height;
    private float weight;
    private String eyeColor;
    private UserHair hair;
    private String domain;
    private String ip;
    private Address address;
    private String macAddress;
    private String university;
    private Bank bank;
    private Company company;
    private String ein;
    private String ssn;
    private String userAgent;

    @Data
    class UserHair {
        private String color;
        private String type;
    }
}


