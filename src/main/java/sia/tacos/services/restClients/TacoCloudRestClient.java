package sia.tacos.services.restClients;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.client.Traverson;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sia.tacos.model.Ingredient;

import java.util.List;

@Service
public class TacoCloudRestClient {

    private final RestTemplate rest;


    public TacoCloudRestClient(RestTemplate rest) {
        this.rest = rest;
    }

    public Ingredient getIngredientById(String ingredientId){
        return rest.getForObject(
                "http://localhost:8080/ingredients/{id}",
                Ingredient.class,
                ingredientId
        );
    }

    public List<Ingredient> getAllIngredients(){
        return rest.exchange(
                "http://localhost:8080/ingredients",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Ingredient>>() {})
                .getBody();
    }

    public void updateIngredient(Ingredient ingredient){
        rest.put(
                "http://localhost:8080/ingredients/{id}",
                ingredient,
                ingredient.getId()
        );
    }

    public Ingredient createIngredient(Ingredient ingredient){
        return rest.postForObject(
                "http://localhost:8080/ingredients",
                ingredient,
                Ingredient.class
        );
    }

    public void deleteIngredient(Ingredient ingredient){
        rest.delete(
                "http://localhost:8080/ingredients/{id}",
                ingredient.getId()
        );
    }


//    public Ingredient getIngredientById(String ingredientId){
//        ResponseEntity<Ingredient> responseEntity = rest.getForEntity(
//                "http://localhost:8080/ingredients/{id}",
//                Ingredient.class,
//                ingredientId
//        );
//        return responseEntity.getBody();
//    }


}
