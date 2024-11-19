package br.edu.famper.getrestaurante.service;

import br.edu.famper.getrestaurante.Repository.PedidoRepository;
import br.edu.famper.getrestaurante.dto.PedidoDto;
import br.edu.famper.getrestaurante.model.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoDto> getAllPedido(){
        return pedidoRepository
                .findAll()
                .stream()
                .map(pedido -> PedidoDto
                        .builder()
                        .id(pedido.getId())
                        .build()
                )
                .toList();
    }


    public PedidoDto getPedidoById(Long id){
        Pedido cid = pedidoRepository.findById(id).orElseThrow();
        return new PedidoDto()
                .builder()
                .id(cid.getId())
                .build();
    }

    public Pedido savePedido(PedidoDto pedidoDto){
        Pedido pedido = new Pedido();
        pedido.setId(pedido.getId());
        return pedidoRepository.save(pedido);
    }

    public PedidoDto editPedido(Long id, PedidoDto pedidoDto){
        Pedido pedido = pedidoRepository.findById(id).orElseThrow();
        pedido.setId(pedidoDto.getId());
        Pedido pedidoEdited = pedidoRepository.save(pedido);
        return new PedidoDto()
                .builder()
                .id(pedidoEdited.getId())
                .build();
    }

    public boolean deletePedido(Long id){
        try{
            Pedido pedido = pedidoRepository.findById(id).orElseThrow();
            pedidoRepository.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
