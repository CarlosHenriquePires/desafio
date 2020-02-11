package br.ind.guararapes.chalenge;

import br.ind.guararapes.chalenge.json.FilmsDTO;
import br.ind.guararapes.chalenge.json.ResultDTO;
import br.ind.guararapes.chalenge.models.FilmModel;
import br.ind.guararapes.chalenge.models.PeopleModel;
import br.ind.guararapes.chalenge.services.FilmService;
import br.ind.guararapes.chalenge.services.PeopleService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ChalengeApplication {

    //private static final Logger log = LoggerFactory.getLogger(ChalengeApplication.class);
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ChalengeApplication.class, args);
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public static CommandLineRunner run(RestTemplate restTemplate, PeopleService peopleService, FilmService filmService) throws Exception {
        return args -> {
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity entity = new HttpEntity(headers);
            ResponseEntity<ResultDTO> responseResult = restTemplate.exchange("https://swapi.co/api/people", HttpMethod.GET, entity, ResultDTO.class);

            ResultDTO peoples = responseResult.getBody();

            PeopleModel p = new PeopleModel();
            FilmModel f = new FilmModel();

            //Set<FilmModel> filmes = new HashSet<FilmModel>();
            List<String> link_films = new ArrayList();

            for (int i = 0; i < responseResult.getBody().getResults().size(); i++) {

                String name = peoples.getResults().get(i).getName();
                Long height = peoples.getResults().get(i).getHeight();
                Long mass = peoples.getResults().get(i).getMass();
                String hair_color = peoples.getResults().get(i).getHair_color();
                String skin_color = peoples.getResults().get(i).getSkin_color();
                String eye_skin = peoples.getResults().get(i).getEye_color();
                String birth_year = peoples.getResults().get(i).getBirth_year();
                String gender = peoples.getResults().get(i).getGender();
               
                p = new PeopleModel(name, height, mass, hair_color, skin_color, eye_skin, birth_year, gender);
                peopleService.salvar(p);
                
                for (int j = 0; j < responseResult.getBody().getResults().get(i).getFilms().size(); j++) {

                    link_films.add(responseResult.getBody().getResults().get(i).getFilms().get(j));

                    for (int k = 0; k < link_films.size(); k++) {

                        String film = link_films.get(k);

                        ResponseEntity<FilmsDTO> responseFilm = restTemplate.exchange(film, HttpMethod.GET, entity, FilmsDTO.class);

                        FilmsDTO films = responseFilm.getBody();

                        f = new FilmModel(films.getTitle(), films.getEpisode_id(), films.getOpening_crawl(), films.getDirector(), films.getProducer(), films.getRelease_date());
                        //filmes.add(f);
                        filmService.salvar(f);
                    }
                }
                //p = new PeopleModel(name, height, mass, hair_color, skin_color, eye_skin, birth_year, gender, (Set<FilmModel>) filmes);
                //peopleService.salvar(p);
            }
            
        };
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
    

}
