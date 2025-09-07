package com.curso.Coinkeeper.services;

import com.curso.Coinkeeper.domains.Banco;
import com.curso.Coinkeeper.domains.Conta;
import com.curso.Coinkeeper.domains.dtos.BancoDTO;
import com.curso.Coinkeeper.domains.dtos.ContaDTO;
import com.curso.Coinkeeper.domains.dtos.UsuarioDTO;
import com.curso.Coinkeeper.repositories.ContaRepository;
import com.curso.Coinkeeper.repositories.UsuarioRepository;
import com.curso.Coinkeeper.services.exceptions.DataIntegrityViolationException;
import com.curso.Coinkeeper.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepo;

    public List<ContaDTO> findAll() {
        return contaRepo.findAll().stream().map
                (obj -> new ContaDTO(obj)).collect(Collectors.toList());
    }
    public Conta findbyId (Integer id){
        Optional<Conta> obj = contaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Conta não encontrado! Id: " + id));
    }
    public Conta create(ContaDTO dto) {
        dto.setId(null);
        Conta obj = new Conta(dto);
        return contaRepo.save(obj);
    }
    public Conta update(Integer id, ContaDTO objDto){
        objDto.setId(id);
        Conta oldObj = findbyId(id);
        oldObj = new Conta(objDto);
        return contaRepo.save(oldObj);
    }
    public void delete(Integer id) {
        Conta obj = findbyId(id);
        if (obj.getLancamentos().size() > 0) {
            throw new DataIntegrityViolationException("Conta não pode ser deletada pois possui Lançamentos vinculados!");
        }
        contaRepo.deleteById(id);
    }
}
