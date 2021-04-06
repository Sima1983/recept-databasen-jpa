package receptdatabase.com.service;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
        import receptdatabase.com.data.RecipeRepository;
        import receptdatabase.com.entity.Recipe;
        import receptdatabase.com.entity.RecipeCategory;
        import receptdatabase.com.entity.RecipeIngredient;
        import receptdatabase.com.entity.RecipeInstruction;
        import java.util.List;

        import static receptdatabase.com.service.CreateIngredientServiceImpl.hasNull;


@Service
public class CreateRecipeServiceImpl implements CreateRecipeService {

    private RecipeRepository recipeRepository;

    @Autowired
    public CreateRecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Recipe createAndSave(String recipeName, List<RecipeIngredient> recipeIngredients, RecipeInstruction instruction, List<RecipeCategory> categories) {

        if(hasNull(recipeName,recipeIngredients)){
            throw new RuntimeException("One or more parameter is null");
        }
        Recipe recipe = recipeRepository.save(new Recipe(recipeName, recipeIngredients, instruction, categories));

        return recipe;
    }


}