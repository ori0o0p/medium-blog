package com.example.mediumspringwebflux.domain.user.document;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Getter
@Document
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String email;

    private String name;

    private String password;

    @CreatedDate
    private LocalDate createdDate;

    @Builder
    public User(String email, String name, String password, LocalDate createdDate) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.createdDate = createdDate;
    }

}
