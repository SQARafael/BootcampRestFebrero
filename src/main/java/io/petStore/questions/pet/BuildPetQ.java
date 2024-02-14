package io.petStore.questions.pet;
/*
 * @(#) BuildPetQ.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import io.petStore.models.pet.Category;
import io.petStore.models.pet.PostPetModel;
import io.petStore.models.pet.Tag;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;
import java.util.List;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
public class BuildPetQ implements Question<PostPetModel> {
    private final  String id;
    private final  String nameCategory;
    private  final  String namePet;

    public BuildPetQ(String id, String nameCategory, String namePet) {
        this.id = id;
        this.nameCategory = nameCategory;
        this.namePet = namePet;
    }

    @Override
    public PostPetModel answeredBy(Actor actor) {
        List<Tag> tags= new ArrayList<>();
        Tag tag= Tag.builder()
                .id(1)
                .name("peluditos")
                .build();

        tags.add(tag);

        Category category= Category.builder()
                .id(0)
                .name(nameCategory)
                .build();




        return PostPetModel.builder()
                .id(Long.parseLong(id))
                .category(category)
                .name(namePet)
                .tags(tags)
                .status("disponible")
                .build();
    }

    public static BuildPetQ was(String id, String nameCategory, String namePet){
        return new BuildPetQ(id,nameCategory,namePet);
    }
}
