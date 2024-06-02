package com.springboot.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
@Document
public class Employee {

    @Id
    private String id;
    private String name;
    private String email;
    private double salary;
    private Status status;
}
