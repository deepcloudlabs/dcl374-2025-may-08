package com.example.essentials.service;

import java.util.Collection;

import com.example.essentials.domain.Director;
import com.example.essentials.domain.Genre;
import com.example.essentials.domain.Movie;
import com.example.essentials.model.CriteriaBean;

/**
 * 
 * @author Binnur Kurt
 *
 */
public interface MovieService {
	Movie findMovieById(int id);

	Collection<Movie> findAllMovies();

	Collection<Movie> findAllMoviesByYearRange(int fromYear, int toYear);

	Collection<Movie> findAllMoviesByDirectorId(int directorId);

	Collection<Movie> findAllMoviesByYearRangeAndGenre(String genre, int fromYear, int toYear);

	Collection<Movie> findAllMoviesByGenre(String genre);

	Collection<Movie> findAllMoviesByCriteria(CriteriaBean criteria);

	Movie addMovie(Movie movie);

	Genre findGenreByName(String genre);

	Collection<Genre> findAllGenres();

	Collection<Director> findAllDirectors();
}
