package com.shruteekatech.electronicStore.dtos;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class ProductDto {

    private Long pid;
    @NotEmpty
    private String title;

    @NotEmpty
    @Size(min=10,max = 10000,message = "Please Enter at least 10 Character")
    private String description;
    @NotEmpty
    private Double price;
    @NotEmpty
    private Integer quantity;

    @NotEmpty
    private  boolean live;
    @NotEmpty
    private boolean stock;
}
