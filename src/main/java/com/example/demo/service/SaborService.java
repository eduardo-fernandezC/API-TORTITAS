package com.example.demo.service;

import com.example.demo.model.Sabor;
import com.example.demo.repository.SaborRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class SaborService {

    @Autowired
    private SaborRepository saborRepository;

    public Sabor findById(Long id) {
        return saborRepository.findById(id).orElse(null);
    }

    public List<Sabor> findAll() {
        return saborRepository.findAll();
    }

    public Sabor save(Sabor sabor) {
        return saborRepository.save(sabor);
    }

    public Sabor update(Long id, Sabor sabor) {
        Sabor saborToUpdate = saborRepository.findById(id).orElse(null);
        if (saborToUpdate != null) {
            saborToUpdate.setNombre_sabor(sabor.getNombre_sabor());
            return saborRepository.save(saborToUpdate);
        }
        return null;
    }

    public Sabor patch(Long id, Sabor sabor) {
        Sabor saborToPatch = saborRepository.findById(id).orElse(null);
        if (saborToPatch != null && sabor.getNombre_sabor() != null) {
            saborToPatch.setNombre_sabor(sabor.getNombre_sabor());
            return saborRepository.save(saborToPatch);
        }
        return null;
    }

    public void delete(Long id) {
        saborRepository.deleteById(id);
    }
}
