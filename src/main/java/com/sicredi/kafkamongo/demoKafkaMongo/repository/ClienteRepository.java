package com.sicredi.kafkamongo.demoKafkaMongo.repository;

import com.sicredi.kafkamongo.demoKafkaMongo.model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
