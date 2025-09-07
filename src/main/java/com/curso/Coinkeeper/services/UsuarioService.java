package com.curso.Coinkeeper.services;

import com.curso.Coinkeeper.domains.Banco;
import com.curso.Coinkeeper.domains.Usuario;
import com.curso.Coinkeeper.domains.dtos.BancoDTO;
import com.curso.Coinkeeper.domains.dtos.UsuarioDTO;
import com.curso.Coinkeeper.repositories.UsuarioRepository;
import com.curso.Coinkeeper.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private PasswordEncoder encoder;

    public List<UsuarioDTO> findAll() {
        return usuarioRepo.findAll().stream().map
                (obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
    }
    public Usuario findbyId (Integer id){
        Optional<Usuario> obj = usuarioRepo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuario não encontrado! Id: " + id));
    }
    public Usuario create(UsuarioDTO objDto) {
        objDto.setIdUsuario(null);
        objDto.setSenhaUsuario(encoder.encode(objDto.getSenhaUsuario()));
        Usuario obj = new Usuario(objDto);
        return usuarioRepo.save(obj);
    }
    public Usuario update(Integer id, UsuarioDTO objDto){
        objDto.setIdUsuario(id);
        Usuario oldObj = findbyId(id);
        oldObj = new Usuario(objDto);
        return usuarioRepo.save(oldObj);
    }
    public void delete(Integer id){
        Usuario obj = findbyId(id);
        usuarioRepo.deleteById(id);
    }
}