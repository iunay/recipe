package com.demo.recipe.boostrap;

import com.demo.recipe.domain.*;
import com.demo.recipe.repositories.CategoryRepository;
import com.demo.recipe.repositories.RecipeRepository;
import com.demo.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Slf4j
@Component
public class DataLoader implements CommandLineRunner {

   private RecipeRepository recipeRepository;
   private UnitOfMeasureRepository unitOfMeasureRepository;
   private CategoryRepository categoryRepository;

    public DataLoader(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Notes guacaNotes = new Notes();
        guacaNotes.setRecipeNotes("Be careful handling chiles if using. Wash your hands thoroughly after handling and do not touch your eyes or the area near your eyes with your hands for several hours.");

        Optional<UnitOfMeasure> unit = unitOfMeasureRepository.findByDescription("unit");
        Optional<Category> mexicat =categoryRepository.findByDescription("Mexican");


        Recipe guacamole = new Recipe();

    guacamole.setDescription("The Perfect Guacamole");
    guacamole.setDirections("1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" +
            "\n" +
            "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" +
            "\n" +
            "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
            "\n" +
            "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" +
            "\n" +
            "Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" +
            "\n" +
            "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" +
            "\n" +
            "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.");

    guacamole.setPrepTime(10);
    guacamole.setCookTime(0);
    guacamole.setServings(4);
    guacamole.setDifficulty(Difficulty.EASY);
    guacamole.getCategories().add(mexicat.get());

    guacamole.addIngredient(new Ingredient("Avocado",new BigDecimal(2), unit.get()));
    guacamole.addIngredient(new Ingredient("Lime",new BigDecimal(1), unit.get()));


    guacamole.setNotes(guacaNotes);

    recipeRepository.save(guacamole);

    }
}
