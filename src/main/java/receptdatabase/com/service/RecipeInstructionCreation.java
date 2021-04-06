package receptdatabase.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import receptdatabase.com.data.RecipeInstructionRepository;
import receptdatabase.com.entity.RecipeInstruction;

import static receptdatabase.com.service.CreateIngredientServiceImpl.hasNull;


@Service
    public class RecipeInstructionCreation implements RecipeInstructionService {

        private RecipeInstructionRepository instructionRepository;

        @Autowired
        public RecipeInstructionCreation(RecipeInstructionRepository instructionRepository) {
            this.instructionRepository = instructionRepository;
        }

        @Override
        @Transactional(rollbackFor = RuntimeException.class)
        public RecipeInstruction createAndSave(String instruction) {
            if(hasNull(instruction)){
                throw new RuntimeException("Instruction can not be null");
            }
            RecipeInstruction recipeInstruction = instructionRepository.save(new RecipeInstruction(instruction));

            return recipeInstruction;
        }
    }

