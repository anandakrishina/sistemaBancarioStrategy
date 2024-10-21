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

import static com.ifto.krishina.model.ProcessarBoletos.FORMATO_DATA;
import static com.ifto.krishina.model.ProcessarBoletos.FORMATO_DATA_HORA;

public class LeituraRetornoBradesco {


    public static List<Boleto> lerArquivo(URI nomeArquivo) {
        try{
            List<String> lineList = Files.readAllLines(Paths.get(nomeArquivo));
            List<Boleto> boletoList = new ArrayList<>();

            for (String linha : lineList) {
                String[] vetor = linha.split(";");
                Boleto boleto = new Boleto();
                boleto.setId(Integer.parseInt(vetor[0]));
                boleto.setCodBanco(vetor[1]);
                boleto.setAgencia(vetor[2]);
                boleto.setContaBancaria(vetor[3]);
                boleto.setDataVencimento(LocalDate.parse(vetor[4],FORMATO_DATA));
                boleto.setDataPagamento(LocalDateTime.parse(vetor[5],FORMATO_DATA_HORA));
                boleto.setCpfCliente(vetor[6]);
                boleto.setValor(Double.parseDouble(vetor[7]));
                boleto.setMulta(Double.parseDouble(vetor[8]));
                boleto.setJuros(Double.parseDouble(vetor[9]));

                boletoList.add(boleto);

            }

            return boletoList;
        } catch (IOException e){
            throw new UncheckedIOException(e);
        }

    }
}
