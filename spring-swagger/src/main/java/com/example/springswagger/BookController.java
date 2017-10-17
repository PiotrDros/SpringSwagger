package com.example.springswagger;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(value = "books")
public class BookController {

    static class ListOfBooks extends ArrayList<Book> {

    }

    private static List<Book> books = new ArrayList<>();

    @ApiOperation(value = "Adds book")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Book added", response = void.class) })
    @RequestMapping(value = "books", method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {
        books.add(book);
    }

    @ApiOperation(value = "Adds book")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Book added", response = ListOfBooks.class) })
    @RequestMapping(value = "books", method = RequestMethod.GET)
    public List<Book> getBooks() {
        return books;
    }

}
