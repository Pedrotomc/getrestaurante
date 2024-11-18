package br.edu.famper.getrestaurante.service;


import br.edu.famper.getrestaurante.Repository.GarcomRepository;
import br.edu.famper.getrestaurante.dto.ClienteDto;
import br.edu.famper.getrestaurante.dto.GarcomDto;
import br.edu.famper.getrestaurante.model.Cliente;
import br.edu.famper.getrestaurante.model.Garcom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class GarcomService {
    @Autowired
    private GarcomRepository garcomRepository;

    public List<GarcomDto> getAllGarcom(){
        return garcomRepository
                .findAll()
                .stream()
                .map(garcom -> GarcomDto
                        .builder()
                        .nome(garcom.getNome())
                        .id(garcom.getId())
                        .build()
                )
                .toList();
    }


    public GarcomDto getGarcomById(Long id){
        Garcom cid = garcomRepository.findById(id).orElseThrow();
        return new GarcomDto()
                .builder()
                .nome(cid.getNome())
                .id(cid.getId())
                .build();
    }

    public Garcom saveGarcom(GarcomDto garcomDto){
        Garcom garcom = new Garcom();
        garcom.setNome(garcomDto.getNome());
        garcom.setId(garcom.getId());
        return garcomRepository.save(garcom);
    }

    public GarcomDto editGarcom(Long id, GarcomDto garcomDto){
        Garcom garcom = garcomRepository.findById(id).orElseThrow();
        garcom.setNome(garcomDto.getNome());
        garcom.setId(garcomDto.getId());
        Garcom garcomEdited = garcomRepository.save(garcom);
        return new GarcomDto()
                .builder()
                .nome(garcomEdited.getNome())
                .id(garcomEdited.getId())
                .build();
    }

    public boolean deleteGarcom(Long id){
        try{
            Garcom garcom = garcomRepository.findById(id).orElseThrow();
            garcomRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
