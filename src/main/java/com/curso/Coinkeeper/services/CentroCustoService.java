package com.curso.Coinkeeper.services;

import com.curso.Coinkeeper.domains.Banco;
import com.curso.Coinkeeper.domains.CentroCusto;
import com.curso.Coinkeeper.domains.dtos.BancoDTO;
import com.curso.Coinkeeper.domains.dtos.CentroCustoDTO;
import com.curso.Coinkeeper.domains.dtos.UsuarioDTO;
import com.curso.Coinkeeper.repositories.CentroCustoRepository;
import com.curso.Coinkeeper.repositories.UsuarioRepository;
import com.curso.Coinkeeper.services.exceptions.DataIntegrityViolationException;
import com.curso.Coinkeeper.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CentroCustoService {
    @Autowired
    private CentroCustoRepository centroCustoRepo;

    public List<CentroCustoDTO> findAll() {
        return centroCustoRepo.findAll().stream().map
                (obj -> new CentroCustoDTO(obj)).collect(Collectors.toList());
    }
    public CentroCusto findbyId (Integer id){
        Optional<CentroCusto> obj = centroCustoRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Centro Custo não encontrado! Id: " +id));
    }
    public CentroCusto create(CentroCustoDTO dto) {
        dto.setId(null);
        CentroCusto obj = new CentroCusto(dto);
        return centroCustoRepo.save(obj);
    }
    public CentroCusto update(Integer id, CentroCustoDTO objDto){
        objDto.setId(id);
        CentroCusto oldObj = findbyId(id);
        oldObj = new CentroCusto(objDto);
        return centroCustoRepo.save(oldObj);
    }
    public void delete(Integer id) {
        CentroCusto obj = findbyId(id);
        if (obj.getLancamentos().size() > 0) {
            throw new DataIntegrityViolationException("Centro Custo não pode ser deletado pois possui Lançamentos vinculados!");
        }
        centroCustoRepo.deleteById(id);
    }
}
