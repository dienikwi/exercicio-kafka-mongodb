package com.sicredi.kafkamongo.demoKafkaMongo.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    private String codCliente;
    private List<String> itens;

}
