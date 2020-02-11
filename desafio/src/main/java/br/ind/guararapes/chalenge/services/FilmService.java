/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ind.guararapes.chalenge.services;

import br.ind.guararapes.chalenge.models.FilmModel;
import br.ind.guararapes.chalenge.repository.FilmRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlzenriques
 */
@CrossOrigin()
@RestController
@RequestMapping("/film")
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmModel salvar(@RequestBody FilmModel film) {

        if (filmRepository.findByTitle(film.getTitle()) == null) {
            filmRepository.save(film);
        }        
//        FilmModel filmNew = new FilmModel();
//        if (filmRepository.findByTitle(film.getTitle()) == null) {
//            filmRepository.save(film);
//            filmNew = film;
//        } else {
//                for (FilmModel f : filmRepository.findAll())
//                    if (film.getTitle().equals(f.getTitle()))
//                        filmNew = f;
//                    else
//                        filmRepository.save(film);
//                        filmNew = film;
//                }
        return film;
}
    @RequestMapping(value = "/saveNovo", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmModel salvarNovo (@RequestBody FilmModel film) {
            filmRepository.save(film);
        return film;
    }
    
    @RequestMapping(value = "/atualizar", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmModel atualizar(@RequestBody FilmModel film) {

            filmRepository.save(film);

            return film;
}

    @RequestMapping(value = "/findOne/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public FilmModel buscaPeloId(@PathVariable("idfilme") Long idfilme) {

        return filmRepository.findById(idfilme).get();
    }
    
    @RequestMapping(value = "/saveAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmModel> salvarTodos(@RequestBody List<FilmModel> filmes) {
        filmRepository.saveAll(filmes);
        return filmes;
    }
    
    @RequestMapping(value = "/delOne/{idfilm}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public  String delPeloId(@PathVariable("idfilm") Long idfilm) {
        
        FilmModel f = filmRepository.findById(idfilm).get();
        filmRepository.delete(f);
        
        return "Removido com Sucesso";
    }
    
        @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FilmModel> findAll() {
        return (List<FilmModel>) filmRepository.findAll();
    }

}
