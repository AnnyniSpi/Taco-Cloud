package sia.tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import sia.tacos.model.Ingredient;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
