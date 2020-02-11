/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ind.guararapes.chalenge.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author carlzenriques
 *
 */
@Entity
@Table(name = "people")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PeopleModel implements Serializable {

    public PeopleModel(String name, Long height, Long mass, String hair_color, String skin_color, String eye_color, String birth_year, String gender) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
    }

        public PeopleModel(Long idpeople,String name, Long height, Long mass, String hair_color, String skin_color, String eye_color, String birth_year, String gender) {
        this.idpeople = idpeople;
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idpeople;

    @Column
    private String name;

    @Column
    private Long height;

    @Column
    private Long mass;

    @Column
    private String hair_color;

    @Column
    private String skin_color;

    @Column
    private String eye_color;

    @Column
    private String birth_year;

    @Column
    private String gender;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "people_film", joinColumns = {
        @JoinColumn(name = "idpeople", nullable = false, updatable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "idfilm", nullable = false, updatable = false)})
    private Set<FilmModel> film = new HashSet<FilmModel>();
//    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "people")
//    private Set<PeopleFilmModel> peoplefilm;

    @Override
    public String toString() {
        return "People: {"
                + "name: " + this.getName()
                + ", height: " + this.getHeight()
                + ", gender: " + this.getGender()
                + "}";
    }
}
