package com.sicredi.kafkamongo.demoKafkaMongo.controller;
import com.sicredi.kafkamongo.demoKafkaMongo.dto.ClienteDTO;
import com.sicredi.kafkamongo.demoKafkaMongo.dto.ProdutoDTO;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Cliente;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Produto;
import com.sicredi.kafkamongo.demoKafkaMongo.service.ClienteService;
import com.sicredi.kafkamongo.demoKafkaMongo.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.util.List;
import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@RestController
public class ProdutoController {
    private ProdutoService produtoService;

    @PostMapping("/produto/add")
    public ResponseEntity<Void> cadastraProduto(@RequestBody ProdutoDTO produtoDto) {
        Produto produto = produtoService.cadastraProduto(produtoDto);

        if (produto == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(produto.getCodProduto()).toUri();
        return  ResponseEntity.created(location).build();
    }

    @GetMapping("/produto/listar/{codigo}")
    public ResponseEntity<Optional<Produto>> listar(@PathVariable String codigo){
        Optional<Produto> produto = null;
        produto = produtoService.listar(codigo);
        return ResponseEntity.ok(produto);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException excp){
        return ResponseEntity.
                status(HttpStatus.EXPECTATION_FAILED).
                body(excp.getMessage());
    }
}
