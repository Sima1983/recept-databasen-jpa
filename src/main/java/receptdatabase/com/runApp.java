package receptdatabase.com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import receptdatabase.com.data.*;
import receptdatabase.com.entity.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class runApp implements CommandLineRunner {

    private RecipeIngredientRepository recipeIngredient;
    private RecipeRepository recipeRepository;
    private IngredientRepository ingredientRepository;
    private RecipeCategoryRepository recipeCategoryRepository;
    private RecipeInstructionRepository recipeInstructionRepository;

    List<Recipe> mainRecipes = new ArrayList<>();
    List<RecipeIngredient> recipeIngredients = new ArrayList<>();
    List<RecipeCategory> categories = new ArrayList<>();

    @Autowired
    public runApp(RecipeIngredientRepository recipeIngredient, RecipeRepository recipeRepository, IngredientRepository ingredientRepository, RecipeCategoryRepository recipeCategoryRepository, RecipeInstructionRepository recipeInstructionRepository) {
        this.recipeIngredient = recipeIngredient;
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeCategoryRepository = recipeCategoryRepository;
        this.recipeInstructionRepository = recipeInstructionRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void run(String... args) throws Exception {

        addIngredient();
        addRecipeIngredient();
        addRecipeCategory();
        addInstruction();
        addRecipe();

    }

    public void addRecipeIngredient(){
        Ingredient ingredient1 = new Ingredient("chicken");
        RecipeIngredient recipeIngredient1 = new RecipeIngredient(ingredient1,500, Measurement.G,null);
        recipeIngredient.save(recipeIngredient1);

    }
    public void addInstruction(){
        String instruction = "test instruction";
       // recipeInstructionRepository.save(instruction);

    }

    public void addRecipe(){
        String recipeName = "Fried chicken";
        RecipeInstruction instruction = new RecipeInstruction("Cut the whole chickens into 4 breasts, 4 thighs, 4 legs and 4 wings and set aside. Preheat your oil, " +
                "in either a heavy pan on the stove or a deep-fryer, to 325 degrees F. In a large bowl, combine the flour, salt, black pepper, garlic powder," +
                " onion powder and cayenne pepper until thoroughly mixed");


        System.out.println(recipeRepository.save(new Recipe(recipeName,recipeIngredients, instruction, categories)));
    }
    public void addIngredient(){
        String ingredientName = "onion";
        ingredientRepository.save(new Ingredient(ingredientName));

    }
    public void addRecipeCategory(){
        String category = "Main Dishes";
        RecipeCategory mainDishes = new RecipeCategory(category,mainRecipes);
        System.out.println(recipeCategoryRepository.save(mainDishes));


    }
}

