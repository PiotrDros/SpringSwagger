package com.example.endpoint;

import com.example.model.Actor;
import com.example.model.AddMovie;
import com.example.model.Movie;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import io.swagger.Swagger2SpringBoot;
import io.swagger.annotations.ApiParam;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-15T23:45:57.158+02:00")

@Controller
@CrossOrigin(origins = "*")
public class MoviesApiController implements MoviesApi {

    public ResponseEntity<Void> addMovie(@ApiParam(value = "") @Valid @RequestBody AddMovie addMovie) {

        Movie movie = new Movie().title(addMovie.getTitle()).year(addMovie.getYear());
        for (Actor actor : Swagger2SpringBoot.actors) {
            for (Integer idActor : addMovie.getActors()) {
                if (idActor.equals(actor.getId())) {
                    movie.addActorsItem(actor);
                }
            }
        }

        Swagger2SpringBoot.movies.add(movie);
        System.out.println("Add movie: " + movie);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> updateMovie(@ApiParam(value = "Movie's id", required = true) @PathVariable("id") Integer id,
            @ApiParam(value = "") @Valid @RequestBody Map<String, Object> updateMovie) {

        Optional<Movie> findFirst = Swagger2SpringBoot.movies.stream().filter(m -> m.getId().equals(id)).findFirst();
        System.out.println("Update movie");
        if (findFirst.isPresent()) {
            Movie movie = findFirst.get();

            for (Entry<String, Object> entry : updateMovie.entrySet()) {
                switch (entry.getKey()) {

                case "title":
                    movie.setTitle((String) entry.getValue());
                    break;
                case "year":
                    movie.setYear((Integer) entry.getValue());
                    break;
                case "actors":
                    List<Integer> actors = (List<Integer>) entry.getValue();
                    for (Actor actor : Swagger2SpringBoot.actors) {
                        for (Integer idActor : actors) {
                            if (idActor.equals(actor.getId())) {
                                movie.addActorsItem(actor);
                            }
                        }
                    }
                    break;
                }
            }

            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Void> deleteMovie(@ApiParam(value = "Movie's id", required = true) @PathVariable("id") Integer id) {
        boolean removed = Swagger2SpringBoot.movies.removeIf(a -> a.getId().equals(id));
        System.out.println("Delete movie");
        if (removed) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Movie> getMovie(@ApiParam(value = "Movie's id", required = true) @PathVariable("id") Integer id) {
        Optional<Movie> movie = Swagger2SpringBoot.movies.stream().filter(m -> m.getId().equals(id)).findFirst();
        System.out.println("Get movie");
        if (movie.isPresent()) {
            return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Movie>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Movie>> getMovies(
            @ApiParam(value = "Movie was released in or after this year") @RequestParam(value = "fromYear", required = false) Integer fromYear,
            @ApiParam(value = "Movie was realeas in or before this year") @RequestParam(value = "toYear", required = false) Integer toYear) {
        List<Movie> movies = Swagger2SpringBoot.movies.stream().filter(m -> fromYear == null ? true : m.getYear() >= fromYear)
                .filter(m -> toYear == null ? true : m.getYear() <= toYear).collect(Collectors.toList());
        System.out.println("Get movies");
        return new ResponseEntity<List<Movie>>(movies, HttpStatus.OK);
    }

}
