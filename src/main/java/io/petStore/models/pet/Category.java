package io.petStore.models.pet;
/*
 * @(#) Category.java 11.0
 * Copyright 2023 SQA. Todos los derechos reservados.
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor Rafael Chica
 * @Fecha: --o--
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("name")
    public String name;
}
