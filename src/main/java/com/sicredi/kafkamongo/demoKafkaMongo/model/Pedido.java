package com.sicredi.kafkamongo.demoKafkaMongo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "pedido")
public class Pedido {
    private String codCliente;
    private List<String> itens;
}
