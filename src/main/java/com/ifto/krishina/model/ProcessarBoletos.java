package com.ifto.krishina.model;

import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.function.Function;

public class ProcessarBoletos {
    public static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private Function<URI,List<Boleto>> leituraRetorno;
    //private Function<String,List<Boleto>> leituraRetornoA;
    public ProcessarBoletos (Function<URI,List<Boleto>> leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }

    //predicate
    //function
    //bifunction
    //consumer
    //biconsumer
    //lksdjflaskjf

    public void processar(URI caminhoArquivo){
        System.out.println("_______________BOLETOS________________");
        System.out.println("______________________________________");
        List<Boleto> boletos = leituraRetorno.apply(caminhoArquivo);
        boletos.forEach(System.out::println);
//        for (Boleto boleto : boletos){
//            System.out.println(boleto);
//        }
    }

    public void setLeituraRetorno(Function<URI,List<Boleto>> leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }
}
