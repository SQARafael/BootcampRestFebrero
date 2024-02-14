package io.petStore.models.pet;
/*
 * @(#) PostPetModel.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostPetModel {
    @JsonProperty("id")
    public Long id;

    @JsonProperty("category")
    public Category category;

    @JsonProperty("name")
    public String name;

    @JsonProperty("photoUrls")
    public List<String> photoUrls;

    @JsonProperty("tags")
    public List<Tag> tags;

    @JsonProperty("status")
    public String status;
}
