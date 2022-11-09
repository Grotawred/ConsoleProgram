package org.example.entities;

import lombok.*;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Getter
    private int id;
    @Getter
    @Setter
    private String login;
    @Getter
    @Setter
    private String password;

}