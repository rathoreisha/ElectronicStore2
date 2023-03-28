package com.shruteekatech.electronicStore.dtos;

import com.shruteekatech.electronicStore.constant.ValidationConstant;
import com.shruteekatech.electronicStore.validation.ImageNameValid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto extends BaseEntityDto {

    private Long categoryId;

    @NotEmpty
    @Size(min=5,max = 50,message =ValidationConstant.TITLE_MSG)
    private String title;


    @NotEmpty
    @Size(min=5,max = 50,message =ValidationConstant.DESCRIPTION_MSG)
    private String description;


    @ImageNameValid
    private String coverImage;
}
