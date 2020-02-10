/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ind.guararapes.chalenge.services;

import br.ind.guararapes.chalenge.models.FilmModel;
import br.ind.guararapes.chalenge.models.PeopleFilmModel;
import br.ind.guararapes.chalenge.repository.FilmRepository;
import br.ind.guararapes.chalenge.repository.PeopleFilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlzenriques
 */
@RestController
@RequestMapping("/peoplefilm")
public class PeopleFilmService {
   @Autowired
    private PeopleFilmRepository peoplefilmRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PeopleFilmModel salvar(@RequestBody PeopleFilmModel peoplefilm) {

        peoplefilmRepository.save(peoplefilm);

        return peoplefilm;

    }
    
//    @RequestMapping(value = "/findOne/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
//    public FilmModel buscaPeloId(@PathVariable("idfilme") Long idfilme) {
//
//        return filmRepository.findById(idfilme).get();
//    } 
}
