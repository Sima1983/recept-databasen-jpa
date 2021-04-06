package receptdatabase.com.data;

import org.springframework.data.repository.CrudRepository;
import receptdatabase.com.entity.RecipeCategory;

public interface RecipeCategoryRepository extends CrudRepository<RecipeCategory,Integer> {
}
