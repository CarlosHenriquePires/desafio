/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ind.guararapes.chalenge.json;

/**
 *
 * @author carlzenriques
 */
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleDTO {

    private List<String> films;

    private FilmsDTO filmsObj;

    private String name;

    private Long height;

    private Long mass;

    private String hair_color;

    private String skin_color;

    private String eye_color;

    private String birth_year;

    private String gender;

}
