package sia.tacos.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import sia.tacos.model.Ingredient;
import sia.tacos.model.Ingredient.Type;
import sia.tacos.repositories.IngredientRepository;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
