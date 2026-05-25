package com.nahuel.clinic_api.controller;

import com.nahuel.clinic_api.dto.request.PractitionerResquestDto;
import com.nahuel.clinic_api.dto.response.PractitionerResponseDto;
import com.nahuel.clinic_api.service.PractitionerService;
import com.nahuel.clinic_api.service.impl.PractitionerServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practitioner")
public class PractitionerController {

    private final PractitionerService practitionerService;

    public PractitionerController(PractitionerService practitionerService){
        this.practitionerService = practitionerService;
    }

    @PostMapping
    public ResponseEntity<PractitionerResponseDto> create(@RequestBody PractitionerResquestDto practitionerResquestDto) {
        return ResponseEntity.ok(practitionerService.create(practitionerResquestDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PractitionerResponseDto> update(
            @PathVariable Long id,
            @RequestBody PractitionerResquestDto practitionerResquestDto
    ) {
        return ResponseEntity.ok(practitionerService.update(id, practitionerResquestDto));
    }

    @GetMapping
    public List<PractitionerResponseDto> getAll() {
        return practitionerService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PractitionerResponseDto> getById(@PathVariable Long id) {
        return practitionerService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        practitionerService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
