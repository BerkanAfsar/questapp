package com.project.questapp.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // burada bir çok post un bir user ı olabilir diyoruz ve post tablosunda user_id kolonu ile user tablosunu ilişkilendir diyoruz
    @OnDelete(action = OnDeleteAction.CASCADE) //user silinirse Post ları da sil
    @JsonIgnore
    User user;

    String title;

    @Lob
    @Column(columnDefinition = "text") //hibernate in mysql de string i text olarak algılaması için column definition koyuldu. yoksa varchar 255 olarak alıyor
    String text;
}
