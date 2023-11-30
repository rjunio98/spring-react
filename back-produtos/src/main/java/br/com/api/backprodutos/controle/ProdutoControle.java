package br.com.api.backprodutos.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.backprodutos.modelo.ProdutoModelo;
import br.com.api.backprodutos.servico.ProdutoServico;

@RestController
public class ProdutoControle {
    @Autowired
    private ProdutoServico ps;

    @GetMapping("/listar")
    public Iterable<ProdutoModelo> listar(){
        return ps.listar();
    }


    @GetMapping("/")
    public String rota(){
        return "Rota de produtos";
    }
}
