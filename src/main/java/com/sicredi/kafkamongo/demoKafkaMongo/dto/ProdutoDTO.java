package com.sicredi.kafkamongo.demoKafkaMongo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private String codProduto;
    private String nomeProduto;
}
