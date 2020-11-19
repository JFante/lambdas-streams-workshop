package org.neosuniversity.files;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProcesarExpediente {
//https://datos.gob.mx/busca/dataset/expedientes-de-personalidades

    public static void main(String args[]) throws Exception {

        Stream<String> lineas = Files.lines(Paths.get("src/main/resources", "datos.csv"), StandardCharsets.UTF_8);
        List<Expediente> lstExpedientes = lineas.map(linea -> {
            String[] cadenas = linea.split(",");
            Expediente expediente = new Expediente();

            expediente.setIdExpediente(cadenas[0]);
            if (cadenas.length > 2) {

                expediente.setNombreArtistico(cadenas[1]);
            }
            if (cadenas.length > 3) {
                expediente.setNombreReal(cadenas[2]);
            }
            if (cadenas.length > 4) {
                expediente.setActividad(cadenas[3]);
            }
            if (cadenas.length > 5) {
                expediente.setPais(cadenas[4]);
            }

            return expediente;
        }).collect(Collectors.toList());


        lstExpedientes.stream().forEach(expediente -> System.out.println(expediente.toString()));
    }

}

