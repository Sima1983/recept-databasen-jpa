package receptdatabase.com.data;

import org.springframework.data.repository.CrudRepository;
import receptdatabase.com.entity.RecipeInstruction;

public interface RecipeInstructionRepository extends CrudRepository<RecipeInstruction, String> {
}

