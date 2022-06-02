package org.example.service.Store;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Section;
import org.example.domain.Store;
import org.example.repo.StoreRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepo storeRepo;


    @Override
    public List<Store> getStores() {
        return storeRepo.findAll();
    }

    @Override
    public Optional<Store> getStore(Long id) {
        return storeRepo.findById(id);
    }

    @Override
    public Store saveOrUpdateStore(Store store) {
        return storeRepo.save(store);
    }

    @Override
    public void deleteStore(Long id) {
        storeRepo.deleteById(id);
    }
}
