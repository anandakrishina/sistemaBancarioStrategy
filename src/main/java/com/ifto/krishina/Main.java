package com.ifto.krishina;

import com.ifto.krishina.model.LeituraRetornoBancoDoBrasil;
import com.ifto.krishina.model.LeituraRetornoBradesco;
import com.ifto.krishina.model.ProcessarBoletos;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        URI boletoBrasil = Main.class.getClassLoader().getResource("banco-brasil-1.csv").toURI();
        URI boletoBradesco= Main.class.getClassLoader().getResource("bradesco-1.csv").toURI();

        //var leituraRetorno = new LeituraRetornoBancoDoBrasil();

        final ProcessarBoletos processador = new ProcessarBoletos(LeituraRetornoBancoDoBrasil::lerArquivo);
        processador.processar(boletoBrasil);
        processador.setLeituraRetorno(LeituraRetornoBradesco::lerArquivo);
        processador.processar(boletoBradesco);

        System.out.println(Path.of(boletoBradesco).toString());
        //processador.setLeituraRetorno();

//        var leituraRetorno = new LeituraRetornoBancoDoBrasil();
//        processador.setLeituraRetorno(leituraRetorno);
//
//        processador.getLeituraRetorno().lerArquivo(boletoBrasil);
    }
}