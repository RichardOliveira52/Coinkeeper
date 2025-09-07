package com.curso.Coinkeeper.services;

import com.curso.Coinkeeper.domains.Banco;
import com.curso.Coinkeeper.domains.Pessoa;
import com.curso.Coinkeeper.domains.dtos.BancoDTO;
import com.curso.Coinkeeper.domains.dtos.PessoaDTO;
import com.curso.Coinkeeper.domains.dtos.UsuarioDTO;
import com.curso.Coinkeeper.repositories.PessoaRepository;
import com.curso.Coinkeeper.repositories.UsuarioRepository;
import com.curso.Coinkeeper.services.exceptions.DataIntegrityViolationException;
import com.curso.Coinkeeper.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepo;

    public List<PessoaDTO> findAll() {
        return pessoaRepo.findAll().stream().map
                (obj -> new PessoaDTO(obj)).collect(Collectors.toList());
    }
    public Pessoa findbyId (Integer id){
        Optional<Pessoa> obj = pessoaRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Pessoa não encontrado! Id: " + id));
    }
    public Pessoa create(PessoaDTO dto) {
        dto.setId(null);
        Pessoa obj = new Pessoa(dto);
        return pessoaRepo.save(obj);
    }
    public Pessoa update(Integer id, PessoaDTO objDto){
        objDto.setId(id);
        Pessoa oldObj = findbyId(id);
        oldObj = new Pessoa(objDto);
        return pessoaRepo.save(oldObj);
    }
    public void delete(Integer id) {
        Pessoa obj = findbyId(id);
        if (obj.getLancamentos().size() > 0) {
            throw new DataIntegrityViolationException("Pessoa não pode ser deletada pois possui Lançamentos vinculados!");
        }
        pessoaRepo.deleteById(id);
    }
}
