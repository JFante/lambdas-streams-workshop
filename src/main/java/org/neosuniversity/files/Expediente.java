package org.neosuniversity.files;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Expediente {


    private String idExpediente;
    private String nombreArtistico;
    private String nombreReal;
    private String actividad;
    private String pais;
    private String fecha;
    private String otrosDatos;
    private String observaciones;
}
