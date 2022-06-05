package org.example.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Section;
import org.example.service.section.SectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/section")//No mayusculas, aqui las mismas anotaciones que para Product
@RequiredArgsConstructor
@Slf4j
public class SectionController {
    private final SectionService sectionService;

    @GetMapping
    public ResponseEntity<List<Section>> getSections() {
        return ResponseEntity.ok(sectionService.getSections());
    }

    @GetMapping("/{id}")
    public Section getSection(@PathVariable() Long id) {//No devuelvas Optional nunca, devuelve el objeto de adentro y maneja la excepcion en un Exception Handler
        return sectionService.getSection(id).get();
    }

    @PostMapping()
    public ResponseEntity<Section> saveOrUpdateSection(@RequestBody Section section) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/rol/save").toUriString());
        return ResponseEntity.created(uri).body(sectionService.saveOrUpdateSection(section));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> deleteSection(@PathVariable() Long id) {
        sectionService.deleteSection(id);
        return ResponseEntity.ok("Section deleted");
    }
}
