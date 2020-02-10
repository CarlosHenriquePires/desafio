/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ind.guararapes.chalenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author carlzenriques
 */
@Entity
@Table(name = "peoplefilm")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleFilmModel implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id; 

    public PeopleFilmModel( PeopleModel people, FilmModel film) {
        this.people = people;
        this.film = film;
    }
    
    
    @ManyToOne
    @JoinColumn(name = "idpeople")
    PeopleModel people;

    @ManyToOne
    @JoinColumn(name = "idfilm")
    FilmModel film;
}
