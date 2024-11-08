package com.example.teste.controller;

import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.tag.Tags;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Enumeration;

@RestController
public class TesteController {

    // private final Tracer tracer;         Span span = tracer.buildSpan("GET /teste")
    //                .withTag(Tags.HTTP_METHOD.getKey(), request.getMethod())
    //                .withTag(Tags.HTTP_URL.getKey(), request.getRequestURL().toString())
    //                .start();

    @Autowired
    public TesteController() {
       // this.tracer = tracer;
    }

    @GetMapping("/teste")
    //@Trace(operationName = "requestLogger",measured = true)
    public ResponseEntity<Void> getData(HttpServletRequest request) {
        // Criar um novo Span para a requisição atual


        try {
            // Capturar os headers da requisição
            HttpHeaders headers = new HttpHeaders();
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String headerName = headerNames.nextElement();
                headers.add(headerName, request.getHeader(headerName));
            }

            // Adicionar os headers capturados como tags ao Span
          //  headers.forEach((key, value) -> span.setTag(key, String.join(",", value)));

            // Qualquer lógica adicional do controlador

            return ResponseEntity.ok().build();
        } finally {
            //span.finish(); // Finalizar o Span
        }
    }
}
