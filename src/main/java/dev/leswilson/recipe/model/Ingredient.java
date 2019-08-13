package dev.leswilson.recipe.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "ingredient")
@TableGenerator(
        name="idGen",
        table="next_ids",
        pkColumnName = "table_name",
        valueColumnName = "next_id",
        pkColumnValue="ingredient",
        allocationSize=5,
        initialValue = 1
)
public class Ingredient extends BaseEntity {
    @ManyToOne
    private Recipe recipe;
    private String description;
    private String amount;
    @OneToOne
    private UnitOfMeasure unitOfMeasure;
}
