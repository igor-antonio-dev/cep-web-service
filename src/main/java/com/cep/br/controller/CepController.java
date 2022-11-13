package com.cep.br.controller;

import com.cep.br.model.Address;
import com.cep.br.service.CepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@Controller
public class CepController {

    @Autowired
    protected CepService service;

    @PostMapping(path="/search")
    public String search(@ModelAttribute Address address) throws IOException {
        service.search(address);
        return "result";
    }
}
