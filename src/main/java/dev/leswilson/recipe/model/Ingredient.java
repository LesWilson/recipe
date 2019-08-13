package dev.leswilson.recipe.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private BigDecimal amount;
    @OneToOne
    private UnitOfMeasure unitOfMeasure;
}
