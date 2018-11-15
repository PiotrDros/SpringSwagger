package com.example.springswagger;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@Api(value = "books")
public interface IBookController {
    @ApiOperation(value = "Adds book")
    @ApiResponses(value = {

            @ApiResponse(code = 200, message = "Book added", response = Void.class) })
    @RequestMapping(value = "books", method = RequestMethod.POST)
    void addBook(@RequestBody Book book);

    @ApiOperation(value = "Get books")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Books retrieved", response = BookController.ListOfBooks.class) })
    @RequestMapping(value = "books", method = RequestMethod.GET)
    List<Book> getBooks(@RequestParam(required = false) String filter);
}
