package dev.leswilson.recipe.model;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Notes extends BaseEntity {
    private Recipe recipe;
    private String description;
}
