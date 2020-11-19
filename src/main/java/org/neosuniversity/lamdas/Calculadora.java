package org.neosuniversity.lamdas;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Calculadora {

    @NonNull
    private double operadorA;
    @NonNull
    private double operadorB;
    @NonNull
    private String operacion;

    private double resultado;

}
