package com.ifto.krishina.model;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LeituraRetornoBancoDoBrasil implements LeituraRetorno {

    @Override
    public List<Boleto> lerArquivo(URI nomeArquivo) {
        try{
            List<String> lineList = Files.readAllLines(Paths.get(nomeArquivo));

            List<Boleto>boletoList = new ArrayList<>();

            for (String linha : lineList ) {
                String[] vetor = linha.split(";");
                Boleto boleto = new Boleto();

                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);

                boleto.setDataVencimento(LocalDate.parse(vetor[2],FORMATO_DATA));
                boleto.setDataPagamento(LocalDate.parse(vetor[3],FORMATO_DATA).atTime(0,0,0));
                boleto.setCpfCliente(vetor[4]);
                boleto.setValor(Double.parseDouble(vetor[5]));
                boleto.setMulta(Double.parseDouble(vetor[6]));
                boleto.setJuros(Double.parseDouble(vetor[7]));

                boletoList.add(boleto);
            }
            return boletoList;
        } catch (IOException e){
            throw new UncheckedIOException(e);

        }


    }
}
