package com.evaluacion.ms.mscliente.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ApiModel("Account details")
@Getter
@Setter
@ToString
@Builder
public class TelefonoDto {
    
    @ApiModelProperty(value = "Numero Telefono", example = "1234567")
    private String number;
    
    @ApiModelProperty(value = "Codigo de Ciudad", example = "1")
    private int citycode;
    
    @ApiModelProperty(value = "Codigo de Pais", example = "57")
    private int countrycode;
}