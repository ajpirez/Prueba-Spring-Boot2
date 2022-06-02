package org.example.repo;

import org.example.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
//Falta
public interface SectionRepo extends JpaRepository<Section, Long> {
}
