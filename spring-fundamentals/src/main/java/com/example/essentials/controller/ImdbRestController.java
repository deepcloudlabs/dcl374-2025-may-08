package com.example.essentials.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.essentials.domain.Movie;
import com.example.essentials.model.CriteriaBean;
import com.example.essentials.service.MovieService;

import jakarta.annotation.PostConstruct;

@RestController
@RequestScope // == // @Scope("request")
@RequestMapping("/movies")
@CrossOrigin
@Validated
public class ImdbRestController extends BaseController {
	@Autowired // Field Injection
	private MovieService movieService;
	
	
	public ImdbRestController() {
		super();
		System.out.println("ImdbRestController()");
		System.out.println(movieService);
		for (var method: ImdbRestController.class.getMethods()) {
			if (method.isAnnotationPresent(PostConstruct.class)) {
				System.out.println(method.getName());
			}
		}
	}

	@PostConstruct
	public void ilklendir1() {
		System.out.println("ilklendir1()");
		System.out.println(movieService);		
	}

	@PostConstruct
	public void ilklendir2() {
		System.out.println("ilklendir2()");
		System.out.println(movieService);		
	}
	
	// POST http://localhost:8200/imdb/api/v1/movies
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Collection<Movie> searchMovies(@RequestBody CriteriaBean criteria){
		return movieService.findAllMoviesByCriteria(criteria);
	}
	
	// GET http://localhost:8200/imdb/api/v1/movies?begin=1970&end=1979
	@GetMapping(params= {"begin","end"})
	public Collection<Movie> searchMoviesByYearRange(
			  @RequestParam(value="begin",defaultValue = "1970") int beginYear,
			  @RequestParam(value="end", defaultValue="1979")int endYear
			){
		System.out.println(movieService.getClass().getName());
		return movieService.findAllMoviesByYearRange(beginYear, endYear);
	}	
	
	// GET http://localhost:8200/imdb/api/v1/movies/128
	@GetMapping("{id}")
	public Movie searchMoviesByImdb(@PathVariable int id){
		return movieService.findMovieById(id);
	}	
}
