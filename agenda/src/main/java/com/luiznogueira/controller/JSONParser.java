package com.luiznogueira.controller;

import com.luiznogueira.entidades.Contato;
import com.luiznogueira.view.Tela;

import lombok.extern.slf4j.Slf4j;

import com.google.gson.*;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.*;

@Slf4j
public class JSONParser {

    private Gson gson = new Gson();

    public List<String> contatosToJSON(Collection<Contato> contatos) {
        List<String> json = new ArrayList<>();
        for (Contato contato : contatos) {
            json.add(contatoToJSON(contato));
        }
        return json;
    }

    public List<Contato> JSONToContatos(Collection<String> jsons) {
        List<Contato> contatos = new ArrayList<>();
        for (String json : jsons) {
            contatos.add(JSONToContato(json));
        }
        return contatos;
    }

    private String contatoToJSON(Contato contato) {
        return gson.toJson(contato);
    }

    private Contato JSONToContato(String json) {
        return gson.fromJson(json, Contato.class);
    }
    
    public static void main(String[] args) {
        List<Contato> contatos = Arrays.asList(Tela.getListaContatosStub());
        JSONParser parser = new JSONParser();
        List<String> jsons = parser.contatosToJSON(contatos);
        log.debug(jsons.toString());

        String pathStr2 = "agenda/src/main/resources/contatos.json";
        Path path = Paths.get(pathStr2);
        try {
            String json = Files.readString(path);
            log.debug(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
