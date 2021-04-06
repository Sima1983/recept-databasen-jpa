package receptdatabase.com.service;

import org.springframework.transaction.annotation.Transactional;
import receptdatabase.com.entity.RecipeInstruction;


public interface RecipeInstructionService {

    @Transactional(rollbackFor = RuntimeException.class)
    RecipeInstruction createAndSave(String instruction);
}
