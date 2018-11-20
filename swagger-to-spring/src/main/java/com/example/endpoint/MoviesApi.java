/**
 * NOTE: This class is auto generated by the swagger code generator program (2.2.3).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.example.endpoint;

import com.example.model.AddMovie;
import com.example.model.Movie;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;
import java.util.Map;

import io.swagger.annotations.*;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-15T23:45:57.158+02:00")

@Api(value = "movies", description = "the movies API")
public interface MoviesApi {

    @ApiOperation(value = "", notes = "Add a new movie", response = Void.class, tags = { "Movies", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Movie added", response = Void.class),
            @ApiResponse(code = 404, message = "Not found", response = Void.class) })

    @RequestMapping(value = "/movies", method = RequestMethod.POST)
    ResponseEntity<Void> addMovie(@ApiParam(value = "") @Valid @RequestBody AddMovie addMovie);

    @ApiOperation(value = "", notes = "Delete movie", response = Void.class, tags = { "Movies", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Movie delted", response = Void.class),
            @ApiResponse(code = 404, message = "Movie not found", response = Void.class) })

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMovie(@ApiParam(value = "Movie's id", required = true) @PathVariable("id") Integer id);

    @ApiOperation(value = "", notes = "Returns single movie", response = Movie.class, tags = { "Movies", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response", response = Movie.class),
            @ApiResponse(code = 404, message = "Not found", response = Void.class) })

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
    ResponseEntity<Movie> getMovie(@ApiParam(value = "Movie's id", required = true) @PathVariable("id") Integer id);

    @ApiOperation(value = "", notes = "Returns a list of movies", response = Movie.class, responseContainer = "List", tags = { "Movies", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Successful response", response = Movie.class, responseContainer = "List") })

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    ResponseEntity<List<Movie>> getMovies(
            @ApiParam(value = "Movie was released in or after this year") @RequestParam(value = "fromYear", required = false) Integer fromYear,
            @ApiParam(value = "Movie was realeas in or before this year") @RequestParam(value = "toYear", required = false) Integer toYear);

    @ApiOperation(value = "", notes = "Update movie", response = Void.class, tags = { "Movies", })
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Movie updated", response = Void.class),
            @ApiResponse(code = 404, message = "Movie not found", response = Void.class) })

    @RequestMapping(value = "/movies/{id}", method = RequestMethod.PATCH)
    ResponseEntity<Void> updateMovie(@ApiParam(value = "Movie's id", required = true) @PathVariable("id") Integer id,
            @ApiParam(value = "") @Valid @RequestBody Map<String, Object> updateMovie);

}