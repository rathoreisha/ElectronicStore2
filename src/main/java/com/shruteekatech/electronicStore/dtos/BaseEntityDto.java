package com.shruteekatech.electronicStore.dtos;

import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;


@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntityDto {

    private LocalDate createdate;


    private LocalDate updatedate;


    private String isactive;
}
