package ro.sci.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sci.ticketservice.dto.DepartmentRequest;
import ro.sci.ticketservice.service.DepartmentService;

@RestController
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody DepartmentRequest departmentRequest) {
        departmentService.add(departmentRequest);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }
}
