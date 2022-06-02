package org.example.service.Store;

import org.example.domain.Section;
import org.example.domain.Store;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    List<Store> getStores();

    Optional<Store> getStore(Long id);

    Store saveOrUpdateStore(Store store);

    void deleteStore(Long id);
}
