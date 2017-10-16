package io.swagger;

import com.example.model.Actor;
import com.example.model.Movie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "io.swagger", "com.example.endpoint" })
public class Swagger2SpringBoot implements CommandLineRunner {

    public static List<Actor> actors = new ArrayList<>();
    public static List<Movie> movies = new ArrayList<>();

    static {
        Actor arnold = new Actor().firstName("Arnold").lastName("Schwarzenegger").id(1);
        Actor linda = new Actor().firstName("Linda").lastName("Hamilton").id(2);
        Actor mark = new Actor().firstName("Mark").lastName("Hamill").id(3);
        Actor harrison = new Actor().firstName("Harrison").lastName("Ford").id(4);

        actors.add(arnold);
        actors.add(linda);
        actors.add(mark);
        actors.add(harrison);

        Movie terminator = new Movie().title("Terminator").year(1984).id(1);
        terminator.addActorsItem(arnold);
        terminator.addActorsItem(linda);
        movies.add(terminator);

        Movie starWars = new Movie().title("Star Wars").year(1977).id(2);
        movies.add(starWars);

    }

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
