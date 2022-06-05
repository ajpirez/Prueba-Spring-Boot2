package org.example.service.section;


import org.example.domain.Section;

import java.util.List;
import java.util.Optional;

public interface SectionService {

    List<Section> getSections();

    Optional<Section> getSection(Long id);

    Section saveOrUpdateSection(Section section);


    void deleteSection(Long id);
}
