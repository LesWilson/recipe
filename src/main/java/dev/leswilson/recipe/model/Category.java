package dev.leswilson.recipe.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "category")
@TableGenerator(
        name="idGen",
        table="next_ids",
        pkColumnName = "table_name",
        valueColumnName = "next_id",
        pkColumnValue="category",
        allocationSize=5,
        initialValue = 1
)
public class Category extends BaseEntity {

    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
    private String description;
}
