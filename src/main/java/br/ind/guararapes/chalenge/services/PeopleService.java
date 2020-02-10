/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ind.guararapes.chalenge.services;

import br.ind.guararapes.chalenge.models.PeopleModel;
import br.ind.guararapes.chalenge.repository.FilmRepository;
import br.ind.guararapes.chalenge.repository.PeopleRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@RequestMapping("/people")
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepository;
    @Autowired
    private FilmRepository filmRepository;

    @RequestMapping(value = "/saveAll", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PeopleModel> salvarTodos(@RequestBody List<PeopleModel> pessoas) {
        System.out.println(pessoas.size());
        System.out.println(pessoas.toString());
        peopleRepository.saveAll(pessoas);
        return pessoas;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public PeopleModel salvar(@RequestBody PeopleModel people) {

        PeopleModel peopleNew = new PeopleModel();
        if (peopleRepository.findByName(people.getName()) == null) {
            peopleRepository.save(people);
            peopleNew = people;
        } else {
                for (PeopleModel p : peopleRepository.findAll())
                    if (people.getName().equals(p.getName()))
                        peopleNew = p;
                }
        return peopleNew;
}
    
    @RequestMapping(value = "/findOne/{idpeople}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PeopleModel buscaPeloId(@PathVariable("idpeople") Long idpeople) {

        return peopleRepository.findById(idpeople).get();
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PeopleModel> findAll() {
       // Map map = new HashMap();
       // map.put("people",this.peopleRepository.findAll());
//        List<PeopleModel> peoples = new ArrayList<>();
//        
//        for (PeopleModel p : peopleRepository.findAll())
//            peoples.add(p);

        return (List<PeopleModel>) peopleRepository.findAll();
    }
    @CrossOrigin(maxAge = 3600)
    @RequestMapping(value = "/findName", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public PeopleModel findName(PeopleModel people) {

        PeopleModel x = new PeopleModel();
        for (PeopleModel p : peopleRepository.findAll()) {
            if (people.getName().equals(p.getName())) {
                x = p;
            } else {
                x = people;
            }
        }
        return x;
    }

}
