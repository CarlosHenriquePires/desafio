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
 */
@Entity
@Table(name = "film")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idfilm;

    @Column
    private String title;
    @Column
    private Long episode_id;
    //@Size(max = 1000)
    //@Column
    //private String opening_crawl;
    @Column
    private String director;
    @Column
    private String producer;
    @Column
    private String release_date;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {
//                CascadeType.PERSIST,
//                CascadeType.MERGE
//            },
//            mappedBy = "film")
//    @JoinTable(name = "people_film", joinColumns = {
//    @JoinColumn(name = "idfilm", nullable = false, updatable = false)}, inverseJoinColumns = {
//    @JoinColumn(name = "idpeople", nullable = false, updatable = false)})
    //@ManyToMany(mappedBy = "film", fetch = FetchType.LAZY)
   // private Set<PeopleModel> people = new HashSet<PeopleModel>();
//    @OneToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL, mappedBy = "film")
//    private Set<PeopleFilmModel> peoplefilm;

    public FilmModel(String title, Long episode_id, String director, String producer, String release_date){
        this.title = title;
        this.episode_id = episode_id;
        //this.opening_crawl = opening_crawl;
        this.director = director;
        this.producer = producer;
        this.release_date = release_date;
    }

}
