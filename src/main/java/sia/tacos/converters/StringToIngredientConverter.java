package sia.tacos.converters;

import org.springframework.core.convert.converter.Converter;
import sia.tacos.model.Ingredient;
import sia.tacos.model.IngredientUDT;
import sia.tacos.repositories.IngredientRepository;

import java.util.Optional;

public class StringToIngredientConverter implements Converter<String, IngredientUDT> {

    private final IngredientRepository ingredientRepository;

    public StringToIngredientConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientUDT convert(String id) {
        Optional<Ingredient> ingredient = ingredientRepository.findById(id);
        if(ingredient.isEmpty()){
            return null;
        }

        return ingredient.map(i -> {
            return new IngredientUDT(i.getName(),i.getType());
        }).get();
    }
}
