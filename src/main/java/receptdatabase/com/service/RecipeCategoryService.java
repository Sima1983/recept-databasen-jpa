package receptdatabase.com.service;
import org.springframework.transaction.annotation.Transactional;
import receptdatabase.com.entity.Recipe;
import receptdatabase.com.entity.RecipeCategory;

import java.util.List;


public interface RecipeCategoryService {

@Transactional(rollbackFor = RuntimeException.class)
     RecipeCategory createAndSave(String category, List<Recipe> recipes);

}
