package com.shruteekatech.electronicStore.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_name")
    private String name;
    @Column(name="user_email",unique = true)
    private String email;
    @Column(name="user_password")
    private String password;

    private String gender;

    @Column()
    private String about;

    @Column(name="user_image_name")
    private String imageName;



}
