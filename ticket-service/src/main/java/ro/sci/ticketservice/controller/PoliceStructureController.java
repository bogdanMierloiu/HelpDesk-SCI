package ro.sci.ticketservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.sci.ticketservice.dto.DepartmentRequest;
import ro.sci.ticketservice.dto.PoliceStructureRequest;
import ro.sci.ticketservice.service.PoliceStructureService;

@RestController
@RequestMapping("/police-structure")
@RequiredArgsConstructor
public class PoliceStructureController {

    private final PoliceStructureService policeStructureService;

    @PostMapping
    public ResponseEntity<String> add(@RequestBody PoliceStructureRequest policeStructureRequest) {
        policeStructureService.add(policeStructureRequest);
        return new ResponseEntity<>("Added successfully", HttpStatus.OK);
    }
}
