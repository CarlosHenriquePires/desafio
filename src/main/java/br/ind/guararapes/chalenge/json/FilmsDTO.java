/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ind.guararapes.chalenge.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author carlzenriques
 */
@Setter
@Getter
@EqualsAndHashCode
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FilmsDTO {
    
    private Long episode_id;
    private String title;
    private String opening_crawl; 
    private String director; 
    private String producer; 
    private String release_date;
    
}
