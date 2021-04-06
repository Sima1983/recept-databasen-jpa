package receptdatabase.com.service;


import receptdatabase.com.entity.Ingredient;
import receptdatabase.com.entity.Measurement;
import receptdatabase.com.entity.Recipe;
import receptdatabase.com.entity.RecipeIngredient;

import javax.transaction.Transactional;

public interface RecipeIngredientService {
    @Transactional()
    RecipeIngredient createAndSave(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe);

}
