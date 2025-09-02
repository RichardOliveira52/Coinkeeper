package com.curso.Coinkeeper.repositories;

import com.curso.Coinkeeper.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByEmailUsuario(String emailUsuario);
}
