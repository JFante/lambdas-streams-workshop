package org.neosuniversity.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamsNames {

    public static void main(String args[]){

        // Ordenar los nombres por orden alfabetico de a -z y desplegar en pantalla
        List<String> lstNames = Arrays.asList("zeus","hugo","mario","erika","judith","janet","emiliano","jessica","juan","bertha","adriana", "JULIA");
        orderNames(lstNames);
        System.out.println("-----------------");

        // Ordenar los nombres por orden alfabetico de a -z , convertir a mayusculas el nombre y desplegar en pantalla
        orderNamesUpper(lstNames);
        System.out.println("-----------------");

        // Ordenar los nombres por orden alfabetico de a -z , convertir a mayusculas el nombre y obtener nombres que comiencen con la letra J y desplegar en pantalla
        orderNamesOnlyJUpper(lstNames);
        System.out.println("-----------------");

        // Que pasaria agregamos el nombre "JULIA" a la lista?, en caso de existir algun problema cual es la solucion?
        orderNamesOnlyJFirtsLambdaUpper(lstNames);
        System.out.println("-----------------");
    }

    private static void orderNames(List<String> lstNames){
        lstNames
                .stream()
                .sorted()
        // .forEach(System.out::println);
         .forEach(name ->System.out.println(name));
    }

    public static void orderNamesUpper(List<String> lstNames){
        lstNames
                .stream()
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
    public static void orderNamesOnlyJUpper(List<String> lstNames){
        lstNames
                .stream()
                .filter(name -> name.startsWith("j")||name.startsWith("J"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
    public static void orderNamesOnlyJFirtsLambdaUpper(List<String> lstNames){
        lstNames
                .stream()
                .filter(name -> name.startsWith("j")||name.startsWith("J"))
                .map(String::toUpperCase)
                .map(name -> {
                    if(Optional.ofNullable(name).isPresent()){
                        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                    }else {
                        return name;
                    }
                })
                .sorted()
                .forEach(System.out::println);
    }

}
