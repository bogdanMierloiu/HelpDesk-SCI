package ro.sci.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sci.ticketservice.dto.WorkerRequest;
import ro.sci.ticketservice.service.WorkerService;

@RestController
@RequestMapping("/author")
@RequiredArgsConstructor
public class WorkerController {

    private final WorkerService workerService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody WorkerRequest workerRequest) {
        workerService.add(workerRequest);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }
}
