package receptdatabase.com.service;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import receptdatabase.com.entity.Ingredient;

@Repository
public interface CreateIngredientService {
    @Transactional
    Ingredient createAndSave(String IngredientName);
}