package receptdatabase.com.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import receptdatabase.com.entity.Recipe;

import java.util.List;

public interface RecipeRepository extends CrudRepository<Recipe, Integer> {


}
