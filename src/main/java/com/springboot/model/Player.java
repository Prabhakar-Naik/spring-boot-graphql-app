package com.springboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public record Player(
        Integer id,
        String name,
        Team team) {
}
