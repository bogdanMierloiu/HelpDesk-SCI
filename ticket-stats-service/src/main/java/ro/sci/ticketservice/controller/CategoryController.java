package ro.sci.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sci.ticketservice.dto.CategoryRequest;
import ro.sci.ticketservice.dto.DepartmentRequest;
import ro.sci.ticketservice.service.CategoryService;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody CategoryRequest categoryRequest) {
        categoryService.add(categoryRequest);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }
}
