package com.pe.everis.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class TasaRequest {
    
    private String region;
    private String operacion;
    private String producto;
    private String condicion;
    
}
