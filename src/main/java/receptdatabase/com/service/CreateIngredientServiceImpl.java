package receptdatabase.com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import receptdatabase.com.data.IngredientRepository;
import receptdatabase.com.entity.Ingredient;


import java.util.Arrays;
import java.util.Objects;

@Service
public class CreateIngredientServiceImpl implements CreateIngredientService {


    private IngredientRepository ingredientRepository;

    @Autowired
    public CreateIngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public Ingredient createAndSave(String ingredientName) {
        if(hasNull(ingredientName)){
            throw new RuntimeException("Ingredient name is null");
        }

        Ingredient ingredient = new Ingredient(ingredientName);
        return ingredientRepository.save(ingredient);
    }

    public static boolean hasNull(Object... objects) {
        return Arrays.stream(objects)
                .anyMatch(obj -> Objects.isNull(obj));
    }
}
