package br.edu.famper.getrestaurante.service;


import br.edu.famper.getrestaurante.Repository.RestauranteRepository;
import br.edu.famper.getrestaurante.dto.RestauranteDto;
import br.edu.famper.getrestaurante.model.Restaurante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RestauranteService {
    @Autowired
    private RestauranteRepository restauranteRepository;

    public List<RestauranteDto> getAllRestaurante(){
        return restauranteRepository
                .findAll()
                .stream()
                .map(restaurante -> RestauranteDto
                        .builder()
                        .nome(restaurante.getNome())
                        .id(restaurante.getId())
                        .build()
                )
                .toList();
    }


    public RestauranteDto getRestauranteById(Long id){
        Restaurante cid = restauranteRepository.findById(id).orElseThrow();
        return new RestauranteDto()
                .builder()
                .nome(cid.getNome())
                .id(cid.getId())
                .build();
    }

    // inserir uma cidade
    public Restaurante saveRestaurante(RestauranteDto restauranteDto){
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(restauranteDto.getNome());
        restaurante.setId(restauranteDto.getId());
        return restauranteRepository.save(restaurante);
    }

    // editar uma cidade
    public RestauranteDto editRestaurante(Long id, RestauranteDto restauranteDto){
        Restaurante restaurante = restauranteRepository.findById(id).orElseThrow();
        restaurante.setNome(restauranteDto.getNome());
        restaurante.setId(restauranteDto.getId());
        Restaurante restauranteEdited = restauranteRepository.save(restaurante);
        return new RestauranteDto()
                .builder()
                .nome(restauranteEdited.getNome())
                .id(restauranteEdited.getId())
                .build();
    }

    public boolean deleteRestaurante(Long id){
        try{
            Restaurante restaurante = restauranteRepository.findById(id).orElseThrow();
            restauranteRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
