package receptdatabase.com.data;

import org.springframework.data.repository.CrudRepository;
import receptdatabase.com.entity.Ingredient;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient,Integer> {


}
