package br.edu.famper.getrestaurante.service;


import br.edu.famper.getrestaurante.Repository.ClienteRepository;
import br.edu.famper.getrestaurante.dto.ClienteDto;
import br.edu.famper.getrestaurante.model.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

        public List<ClienteDto> getAllCliente(){
        return clienteRepository
                .findAll()
                .stream()
                .map(cliente -> ClienteDto
                        .builder()
                        .nome(cliente.getNome())
                        .id(cliente.getId())
                        .build()
                )
                .toList();
    }


    public ClienteDto getClienteById(Long id){
        Cliente cid = clienteRepository.findById(id).orElseThrow();
        return new ClienteDto()
                .builder()
                .nome(cid.getNome())
                .id(cid.getId())
                .build();
    }

    // inserir uma cidade
    public Cliente saveCliente(ClienteDto clienteDto){
        Cliente cliente = new Cliente();
        cliente.setNome(clienteDto.getNome());
        cliente.setId(cliente.getId());
        return clienteRepository.save(cliente);
    }

    // editar uma cidade
    public ClienteDto editCliente(Long id, ClienteDto cidadeDto){
        Cliente cliente = clienteRepository.findById(id).orElseThrow();
        cliente.setNome(cidadeDto.getNome());
        cliente.setId(cidadeDto.getId());
        Cliente clienteEdited = clienteRepository.save(cliente);
        return new ClienteDto()
                .builder()
                .nome(clienteEdited.getNome())
                .id(clienteEdited.getId())
                .build();
    }

    // apagar uma cidade
    public boolean deleteCliente(Long id){
        try{
            Cliente cliente = clienteRepository.findById(id).orElseThrow();
            clienteRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}

