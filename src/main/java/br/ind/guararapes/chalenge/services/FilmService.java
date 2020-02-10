/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ind.guararapes.chalenge.services;

import br.ind.guararapes.chalenge.models.FilmModel;
import br.ind.guararapes.chalenge.models.PeopleModel;
import br.ind.guararapes.chalenge.repository.FilmRepository;
import java.util.List;
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
@RequestMapping("/film")
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmModel salvar(@RequestBody FilmModel film) {

        FilmModel filmNew = new FilmModel();
        if (filmRepository.findByTitle(film.getTitle()) == null) {
            filmRepository.save(film);
            filmNew = film;
        } else {
                for (FilmModel f : filmRepository.findAll())
                    if (film.getTitle().equals(f.getTitle()))
                        filmNew = f;
                }
        return filmNew;
}
//    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public FilmModel salvar(@RequestBody FilmModel film) {
//        if (filmRepository.findByTitle(film.getTitle()) == null) {
//            filmRepository.save(film);
//        }
//        return film;
//    }

    @RequestMapping(value = "/findOne/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmModel buscaPeloId(@PathVariable("idfilme") Long idfilme) {

        return filmRepository.findById(idfilme).get();
    }
    
        @RequestMapping(value = "/saveAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmModel> salvarTodos(@RequestBody List<FilmModel> filmes) {
        filmRepository.saveAll(filmes);
        return filmes;
    }
}
