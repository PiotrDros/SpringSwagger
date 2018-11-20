package com.example.springswagger;

import java.util.stream.Collectors;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "books")
public class BookController {

    static class ListOfBooks extends ArrayList<Book> {

    }

    private static List<Book> books = new ArrayList<>();
    static {
        Book book = new Book();
        book.setIsbn("ISBN 9780071808552");
        book.setTitle("Java: The Complete Reference, Ninth Edition");
        book.getAuthors().add("Herbert Schildt");
        books.add(book);

        Book book2 = new Book();
        book2.setIsbn("ISBN 9781904808442");
        book2.setTitle("Alice in Wonderland");
        book2.getAuthors().add("Lewis Carroll");
        books.add(book2);

    }

    @ApiOperation(value = "Adds book")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Book added", response = Void.class) })
    @RequestMapping(value = "books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {
        books.add(book);
        System.out.println("Add book: " + book);
    }

    @ApiOperation(value = "Get books")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Books retrieved", response = ListOfBooks.class) })
    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> getBooks(@RequestParam(required =  false) String filter) {
        System.out.println("Get books");

        if (StringUtils.isEmpty(filter)) {
            return books;
        } else {
            return books.stream().filter(b -> b.getTitle().contains(filter)).collect(Collectors.toList());
        }

    }

}
