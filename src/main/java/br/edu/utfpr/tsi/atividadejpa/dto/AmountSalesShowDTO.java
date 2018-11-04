package br.edu.utfpr.tsi.atividadejpa.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class AmountSalesShowDTO implements Serializable {
   private long id;
   private String banda;
   private long amountSales;
}
