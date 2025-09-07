package com.curso.Coinkeeper.services;

import com.curso.Coinkeeper.domains.*;
import com.curso.Coinkeeper.domains.enums.Situacao;
import com.curso.Coinkeeper.domains.enums.TipoConta;
import com.curso.Coinkeeper.domains.enums.TipoLancamento;
import com.curso.Coinkeeper.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
@Service
public class DBService {

    @Autowired
    private UsuarioRepository usuarioRepo;
    @Autowired
    private PessoaRepository pessoaRepo;
    @Autowired
    private CentroCustoRepository centroCustoRepo;
    @Autowired
    private BancoRepository bancoRepo;
    @Autowired
    private ContaRepository contaRepo;
    @Autowired
    private LancamentoRepository lancamentoRepo;

    @Autowired
    private PasswordEncoder encoder;

    public void initDB(){
        Usuario usuario01 = new Usuario(null, "Richard", "richard@email.com", encoder.encode("1234"));
        Pessoa pessoa01 = new Pessoa(null, "Fornecedor ABC");
        CentroCusto centroCusto01 = new CentroCusto(null, "Manutenção");
        Banco banco01 = new Banco(null, "Banco do Brasil");

        Conta conta01 = new Conta(null, "Conta Principal",TipoConta.POUPANCA, "1234", "5678-9", 1000.00, 5000.00,banco01);

        Lancamento lancamento01 = new Lancamento(
                null,"Compra de materiais", "1/1", LocalDate.now(),
                LocalDate.of(2025, 9, 10), null, 150.75, TipoLancamento.CREDITO,
                Situacao.ABERTO, pessoa01, centroCusto01, conta01);

        usuarioRepo.save(usuario01);
        pessoaRepo.save(pessoa01);
        centroCustoRepo.save(centroCusto01);
        bancoRepo.save(banco01);
        contaRepo.save(conta01);
        lancamentoRepo.save(lancamento01);

    }


}
