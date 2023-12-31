package br.com.api.backprodutos.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.backprodutos.modelo.ProdutoModelo;
import br.com.api.backprodutos.modelo.RespostaModelo;
import br.com.api.backprodutos.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    
    @Autowired
    private ProdutoRepositorio pr;

    @Autowired
    private RespostaModelo rm;

    public Iterable<ProdutoModelo> listar(){
        return pr.findAll();
    }

    public ResponseEntity<?> cadastrarAlterar(ProdutoModelo pm, String acao){
        if(pm.getNome().equals("")){
            rm.setMensagem("O nome do produto não pode ser vazio!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else if(pm.getMarca().equals("")){
            rm.setMensagem("A marca do produto não pode ser vazia!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        }else{
            if(acao.equals("cadastrar")){
                pr.save(pm);
                rm.setMensagem("Produto cadastrado com sucesso!");
                return new ResponseEntity<RespostaModelo>(rm, HttpStatus.CREATED);
            }else{
                return new ResponseEntity<ProdutoModelo>(pr.save(pm), HttpStatus.OK);
            }
        }
    }

    public ResponseEntity<RespostaModelo> remover(long codigo){
        pr.deleteById(codigo);
        rm.setMensagem("Produto removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
