package dev.leswilson.recipe.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "notes")
@TableGenerator(
        name="idGen",
        table="next_ids",
        pkColumnName = "table_name",
        valueColumnName = "next_id",
        pkColumnValue="notes",
        allocationSize=5,
        initialValue = 1
)
public class Notes extends BaseEntity {
    @OneToOne
    private Recipe recipe;
    @Lob
    private String description;
}
