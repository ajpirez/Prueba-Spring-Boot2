package org.example.service.store;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.domain.Store;
import org.example.domain.dto.StoreDTO;
import org.example.repo.StoreRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepo storeRepo;


    @Override
    public List<StoreDTO> getStores() {
        List<Store> stores = storeRepo.findAll();
        ModelMapper modelMapper = new ModelMapper();
        List<StoreDTO>storeDTOListL = new ArrayList<>();
        stores.forEach(store ->{
            StoreDTO storeDTO = modelMapper.map(store,StoreDTO.class);
            storeDTO.setCantSections(store.getSections().size());
            storeDTOListL.add(storeDTO);
        });
        return storeDTOListL;
    }

    @Override
    public Optional<Store> getStore(Long id) {
        return Optional.of(storeRepo.findById(id).orElse(new Store()));
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
