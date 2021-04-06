package receptdatabase.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import receptdatabase.com.data.RecipeIngredientRepository;
import receptdatabase.com.entity.Ingredient;
import receptdatabase.com.entity.Measurement;
import receptdatabase.com.entity.Recipe;
import receptdatabase.com.entity.RecipeIngredient;
import javax.transaction.Transactional;
import static receptdatabase.com.service.CreateIngredientServiceImpl.hasNull;




    @Service
    public class RecipeIngredientCreation implements RecipeIngredientService {

        private RecipeIngredientRepository ingredientRepository;

        @Autowired
        public RecipeIngredientCreation(RecipeIngredientRepository ingredientRepository) {
            this.ingredientRepository = ingredientRepository;
        }

        @Override
        @Transactional(rollbackOn = RuntimeException.class)
        public RecipeIngredient createAndSave(Ingredient ingredient, double amount, Measurement measurement, Recipe recipe) {
            if (hasNull(ingredient,amount,measurement)){
                throw new RuntimeException("one or more parameter is null");
            }
            RecipeIngredient recipeIngredient = new RecipeIngredient(ingredient,amount,measurement,recipe);

            return ingredientRepository.save(recipeIngredient);
        }


    }

