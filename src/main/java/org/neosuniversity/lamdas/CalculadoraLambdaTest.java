package org.neosuniversity.lamdas;

import java.util.Optional;

public class CalculadoraLambdaTest {


    public static void main(String args[]){

        Calculadora calculadora1 = new Calculadora(5,5,"+");
        calculadora1 = CalculadoraLambdaTest.executeOperation(calculadora1);

        System.out.println(calculadora1.getResultado()  +  " operacion: " + calculadora1.getOperacion());

        // si calculadora es null
        //Calculadora calculadoraNull = null;
        //calculadoraNull = CalculadoraLambdaTest.executeOperation(calculadoraNull);

        //System.out.println(calculadoraNull.getResultado()  +  " operacion: " + calculadoraNull.getOperacion());

        //Si calculadora tiene espacios en el operador
        //Calculadora calculadoraEspacios = new Calculadora(5,5," + ");
        //calculadoraEspacios = CalculadoraLambdaTest.executeOperation(calculadoraEspacios);

        //System.out.println(calculadoraEspacios.getResultado()  +  " operacion: " + calculadoraEspacios.getOperacion());


        //Si calculadora tiene espacios en el operador
        Calculadora calculadoraEspacios = new Calculadora(5,5," + ");
        calculadoraEspacios = CalculadoraLambdaTest.executeOperationWithValidation(calculadoraEspacios);

        System.out.println(calculadoraEspacios.getResultado()  +  " operacion: " + calculadoraEspacios.getOperacion());

        //Si calculadora es null
        Calculadora calculadoraNull = null;
        calculadoraNull = CalculadoraLambdaTest.executeOperationWithValidation(calculadoraNull);

        System.out.println(calculadoraNull.getResultado()  +  " operacion: " + calculadoraNull.getOperacion());



    }


    private static Calculadora execute(Calculadora calculadora, IOperacion operacion){
        return operacion.calcula(calculadora);
    }

    private static Calculadora executeOperation(Calculadora calculadora) {

        switch (calculadora.getOperacion()) {
            case "+": {
                execute(calculadora,operacion -> {
                    operacion.setResultado(operacion.getOperadorA() + operacion.getOperadorB());
                    return operacion;
                });

                break;
            }
            case "-": {
                execute(calculadora,operacion -> {
                    operacion.setResultado(operacion.getOperadorA() - operacion.getOperadorB());
                    return operacion;
                });
                break;
            }
            case "*": {
                execute(calculadora,operacion -> {
                    operacion.setResultado(operacion.getOperadorA() * operacion.getOperadorB());
                    return operacion;
                });
                break;
            }
            case "/": {
                execute(calculadora,operacion -> {
                    operacion.setResultado(operacion.getOperadorA() / operacion.getOperadorB());
                    return operacion;
                });
                break;
            }
            default: {
                calculadora.setResultado(0);
                calculadora.setOperacion("::NOT FOUND::");
                break;
            }
        }
        return calculadora;
    }


    private static Calculadora executeOperationWithValidation(Calculadora calculadora){
        return  Optional
                .ofNullable(calculadora)
                .map(CalculadoraLambdaTest::executeStringTrim)
                .map(CalculadoraLambdaTest::executeOperation)
                .orElse(new Calculadora(0,0,"NOT-FOUND"));
    }
    private static Calculadora executeStringTrim(Calculadora calculadora){
        calculadora.setOperacion(calculadora.getOperacion().trim());
        return calculadora;
    }

}
