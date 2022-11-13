package com.cep.br.service;

import com.cep.br.model.Address;
import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.AbstractDriverBasedDataSource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Slf4j
@Service
public class CepService {
    public Address search(Address address) throws IOException {

        URL url = new URL("https://viacep.com.br/ws/"+address.getCep()+"/json/");
        URLConnection connection = url.openConnection();
        InputStream is = connection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));

        String cep;

        StringBuilder jsonCep = new StringBuilder();

        while((cep = br.readLine()) != null) {
            jsonCep.append(cep);
        }

        JSONObject jsonObject = (JSONObject) JSONValue.parse(String.valueOf(jsonCep));

        address.setCdIbge((String)jsonObject.get("ibge"));
        address.setLogradouro((String)jsonObject.get("logradouro"));
        address.setComplemento((String)jsonObject.get("complemento"));
        address.setBairro((String)jsonObject.get("bairro"));
        address.setLocalidade((String)jsonObject.get("localidade"));
        address.setEstado((String)jsonObject.get("uf"));

        return address;
    }
}
