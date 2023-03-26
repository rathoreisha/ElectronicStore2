package com.shruteekatech.electronicStore.dtos;

import com.shruteekatech.electronicStore.constant.AppConstant;

import com.shruteekatech.electronicStore.constant.ValidationConstant;
import com.shruteekatech.electronicStore.entity.User;
import com.shruteekatech.electronicStore.validation.ImageNameValid;
import lombok.*;
import lombok.experimental.SuperBuilder;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto extends BaseEntityDto {
//Data transfer object-DTO

    private Long id;

    @NotEmpty
    @Size(min=3,max=15,message = ValidationConstant.USER )
    private String name;

    @NotEmpty
    @Email(message = ValidationConstant.EMAIL)
    private String email;

    @NotEmpty
    @Pattern(regexp = ValidationConstant.PASSWORD_PATTERN,message= ValidationConstant.PASSWORD)
    private String password;

    @NotEmpty
    @Size(min = 4,max = 6,message = ValidationConstant.GENDER_MSG)
    private String gender;

    @NotEmpty
    @Size(min = 10,max = 100,message = ValidationConstant.ABOUT)
    private String about;

    @NotEmpty
    @ImageNameValid
    private String imageName;



}
