package com.ifto.krishina.model;

import java.net.URI;
import java.util.List;

public class ProcessarBoletos {
    private LeituraRetorno leituraRetorno;

    public ProcessarBoletos (LeituraRetorno leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }

    public void processar(URI caminhoArquivo){
        System.out.println("_______________BOLETOS________________");
        System.out.println("______________________________________");
        List<Boleto> boletos = leituraRetorno.lerArquivo(caminhoArquivo);
        boletos.forEach(System.out::println);
//        for (Boleto boleto : boletos){
//            System.out.println(boleto);
//        }
    }

    public void setLeituraRetorno(LeituraRetorno leituraRetorno){
        this.leituraRetorno = leituraRetorno;
    }

}
