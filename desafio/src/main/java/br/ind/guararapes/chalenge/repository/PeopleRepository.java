/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ind.guararapes.chalenge.repository;

import br.ind.guararapes.chalenge.models.PeopleModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author carlzenriques
 */
public interface PeopleRepository extends CrudRepository<PeopleModel, Long> {
    PeopleModel findByName(String name);
}
