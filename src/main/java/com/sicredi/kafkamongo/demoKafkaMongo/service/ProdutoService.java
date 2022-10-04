package com.sicredi.kafkamongo.demoKafkaMongo.service;
import com.sicredi.kafkamongo.demoKafkaMongo.dto.ProdutoDTO;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Cliente;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Produto;
import com.sicredi.kafkamongo.demoKafkaMongo.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public Produto cadastraProduto(ProdutoDTO produto) {
        Produto produtoModel = null;

        if (produto != null) {
            Optional<Produto> aux = produtoRepository.findById(produto.getCodProduto());
            if (aux != null) {
                throw new IllegalArgumentException("Produto já cadastrado.");
            }
            produtoModel = new Produto(produto.getCodProduto(), produto.getNomeProduto());
            produtoRepository.insert(produtoModel);
        }
        return produtoModel;
    }

    public Optional<Produto> listar(String codigo) {
        Optional<Produto> aux = produtoRepository.findById(codigo);
        if (aux == null) {
            throw new IllegalArgumentException("Produto não existe.");
        }
        return aux;
    }
}
