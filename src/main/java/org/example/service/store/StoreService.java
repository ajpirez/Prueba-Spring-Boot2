package org.example.service.store;

import org.example.domain.Store;
import org.example.domain.dto.StoreDTO;

import java.util.List;
import java.util.Optional;

public interface StoreService {

    List<StoreDTO> getStores();

    Optional<Store> getStore(Long id);

    Store saveOrUpdateStore(Store store);

    void deleteStore(Long id);
}
