package com.ifto.krishina;

import com.ifto.krishina.model.LeituraRetornoBancoDoBrasil;
import com.ifto.krishina.model.LeituraRetornoBradesco;
import com.ifto.krishina.model.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        URI boletoBrasil = Main.class.getClassLoader().getResource("banco-brasil-1.csv").toURI();
        URI boletoBradesco= Main.class.getClassLoader().getResource("bradesco-1.csv").toURI();

        final ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBradesco());
        processador.processar(boletoBradesco);
        processador.setLeituraRetorno(new LeituraRetornoBancoDoBrasil());
        processador.processar(boletoBrasil);


        //processador.setLeituraRetorno();

//        var leituraRetorno = new LeituraRetornoBancoDoBrasil();
//        processador.setLeituraRetorno(leituraRetorno);
//
//        processador.getLeituraRetorno().lerArquivo(boletoBrasil);
    }
}