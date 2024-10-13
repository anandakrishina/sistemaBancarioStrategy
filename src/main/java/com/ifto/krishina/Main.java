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

        ProcessarBoletos processador = new ProcessarBoletos(new LeituraRetornoBradesco());
        System.out.println("lendo arquivo " + boletoBradesco + "\n");
        processador.processar(boletoBradesco);
    }
}