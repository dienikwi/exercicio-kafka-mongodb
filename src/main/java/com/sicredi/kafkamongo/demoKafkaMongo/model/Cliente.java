package com.sicredi.kafkamongo.demoKafkaMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "cliente")
public class Cliente {
    @Id
    private String codCliente;
    private String nomeCliente;
}
