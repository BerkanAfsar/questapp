package com.project.questapp.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    Long Id;

    String userName;
    String password;
}
