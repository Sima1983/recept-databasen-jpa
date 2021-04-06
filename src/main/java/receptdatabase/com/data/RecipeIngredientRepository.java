package receptdatabase.com.data;

import org.springframework.data.repository.CrudRepository;
import receptdatabase.com.entity.RecipeIngredient;

public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient,String> {

}
