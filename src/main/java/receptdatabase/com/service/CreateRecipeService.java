package receptdatabase.com.service;

import org.springframework.transaction.annotation.Transactional;
import receptdatabase.com.entity.Recipe;
import receptdatabase.com.entity.RecipeCategory;
import receptdatabase.com.entity.RecipeIngredient;
import receptdatabase.com.entity.RecipeInstruction;

import java.util.List;


public interface CreateRecipeService {

    Recipe createAndSave(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories);
}
