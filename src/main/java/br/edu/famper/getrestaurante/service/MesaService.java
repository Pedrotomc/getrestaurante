package br.edu.famper.getrestaurante.service;

import br.edu.famper.getrestaurante.Repository.ClienteRepository;
import br.edu.famper.getrestaurante.Repository.MesaRepository;
import br.edu.famper.getrestaurante.dto.ClienteDto;
import br.edu.famper.getrestaurante.dto.MesaDto;
import br.edu.famper.getrestaurante.model.Cliente;
import br.edu.famper.getrestaurante.model.Mesa;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;

    public List<MesaDto> getAllMesa(){
        return mesaRepository
                .findAll()
                .stream()
                .map(mesa -> MesaDto
                        .builder()
                        .id(mesa.getId())
                        .build()
                )
                .toList();
    }


    public MesaDto getMesaById(Long id){
        Mesa cid = mesaRepository.findById(id).orElseThrow();
        return new MesaDto()
                .builder()
                .id(cid.getId())
                .build();
    }

    public Mesa saveMesa(MesaDto mesaDto){
        Mesa mesa = new Mesa();
        mesa.setId(mesa.getId());
        return mesaRepository.save(mesa);
    }

    public MesaDto editMesa(Long id, MesaDto mesaDto){
        Mesa mesa = mesaRepository.findById(id).orElseThrow();
        mesa.setId(mesaDto.getId());
        Mesa clienteEdited = mesaRepository.save(mesa);
        return new MesaDto()
                .builder()
                .id(clienteEdited.getId())
                .build();
    }


    public boolean deleteMesa(Long id){
        try{
            Mesa mesa = mesaRepository.findById(id).orElseThrow();
            mesaRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
