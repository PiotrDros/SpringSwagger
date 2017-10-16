package com.example.endpoint;

import com.example.model.Actor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

import io.swagger.Swagger2SpringBoot;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2017-10-15T23:45:57.158+02:00")

@Controller
public class ActorsApiController implements ActorsApi {

    public ResponseEntity<List<Actor>> getActors() {
        return new ResponseEntity<List<Actor>>(Swagger2SpringBoot.actors, HttpStatus.OK);
    }

}
