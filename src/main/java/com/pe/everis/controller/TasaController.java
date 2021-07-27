package com.pe.everis.controller;

import com.pe.everis.entity.TasaRequest;
import com.pe.everis.entity.TasaResponse;
import com.pe.everis.service.TasaService;
import javax.validation.Valid;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.List;

import org.jsoup.HttpStatusException;
import org.jsoup.UnsupportedMimeTypeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/sbs")
public class TasaController {

    @Autowired
    private TasaService service;

    @GetMapping("/tasas")
    private List<TasaResponse> getTasas(@Valid TasaRequest request) throws MalformedURLException, HttpStatusException,
            UnsupportedMimeTypeException, SocketTimeoutException, IOException {
        final List<TasaResponse> tasas = service.getTasas(request);
        log.info("request finished -> results ({})", tasas.size());
        return tasas;
    }

}
