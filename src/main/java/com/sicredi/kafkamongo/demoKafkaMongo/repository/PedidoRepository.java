package com.sicredi.kafkamongo.demoKafkaMongo.repository;
import com.sicredi.kafkamongo.demoKafkaMongo.model.Pedido;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, String> {
}
