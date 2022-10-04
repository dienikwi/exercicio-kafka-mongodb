package com.sicredi.kafkamongo.demoKafkaMongo.repository;

import com.sicredi.kafkamongo.demoKafkaMongo.model.Produto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProdutoRepository extends MongoRepository<Produto, String> {
    public Produto findByCodProduto(String cod);
}
