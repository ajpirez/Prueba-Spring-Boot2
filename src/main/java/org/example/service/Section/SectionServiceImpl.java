package org.example.service.Section;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Section;
import org.example.repo.SectionRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class SectionServiceImpl implements SectionService {

    private final SectionRepo sectionRepo;


    @Override
    public List<Section> getSections() {
        return sectionRepo.findAll();
    }

    @Override
    public Optional<Section> getSection(Long id) {
        return sectionRepo.findById(id);
    }

    @Override
    public Section saveOrUpdateSection(Section Section) {
        return sectionRepo.save(Section);
    }

    @Override
    public void deleteSection(Long id) {
        sectionRepo.deleteById(id);
    }
}
