package dev.leswilson.recipe.repositories;

import dev.leswilson.recipe.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
