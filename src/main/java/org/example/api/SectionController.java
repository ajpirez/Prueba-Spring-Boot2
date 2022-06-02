package org.example.api;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Product;
import org.example.domain.Section;
import org.example.service.Product.ProductService;
import org.example.service.Section.SectionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Section")
@RequiredArgsConstructor
@Slf4j
public class SectionController {
    private final SectionService sectionService;

    @GetMapping("")
    public ResponseEntity<List<Section>> getSections() {
        return ResponseEntity.ok(sectionService.getSections());
    }

    @GetMapping(path = "/{id}")
    public Optional<Section> getSection(@PathVariable() Long id) {
        return sectionService.getSection(id);
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
