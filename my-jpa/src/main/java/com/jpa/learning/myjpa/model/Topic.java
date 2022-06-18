package com.jpa.learning.myjpa.model;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Topic {
    @Id
    private int id;
    private String name;
}
