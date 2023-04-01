package com.shruteekatech.electronicStore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

    @Id
    private Long pid;

    private String pname;


}
