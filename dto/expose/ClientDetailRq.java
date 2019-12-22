package com.intercorp.retotech.dto.expose;

import lombok.Data;

@Data
public class ClientDetailRq {
    private String name;
    private String lastName;
    private int age;
    private String date;
}
