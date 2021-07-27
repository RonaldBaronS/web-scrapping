package com.pe.everis;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pe.everis.entity.TasaResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebJsoupApplication {
    
    public static void main(String[] args) throws IOException {
        
        SpringApplication.run(WebJsoupApplication.class, args);
        
        /*String url = "https://www.nfl.com/stats/player-stats/";
        System.out.println("Conectando a url :" + url);
        
        // Conectando a url:
        Document doc = Jsoup.connect(url).get();
        
        Element titulo = doc.getElementsByClass("nfl-c-content-header__roofline").first();
        System.out.println(titulo.text());
        
        Element tbody = doc.getElementsByTag("tbody").first();
        // System.out.println(tbody.text());
        
        List<Element> qbs = tbody.getElementsByTag("tr");
        List<TasaResponse> listQuarterback = new ArrayList<>();
        
        for (Element qb : qbs) {
            //System.out.println(qb.text());
            List<Element> atributos = qb.getElementsByTag("td");
            
            TasaResponse tasaResponse = new TasaResponse();
            
            tasaResponse.setNone(atributos.get(0).text());
            tasaResponse.setAtt(atributos.get(1).text());
            tasaResponse.setPassYds(atributos.get(2).text());
            tasaResponse.setYdsAtt(atributos.get(3).text());
            
            listQuarterback.add(tasaResponse);
        }
        
        for (TasaResponse qb : listQuarterback) {
            //System.out.println("None: "+qb.getNone()+" | "+"jardas passadas: "+qb.getPassYds());
            converterToJson(qb);
        }
    }
    
    public static void converterToJson(TasaResponse qb) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(qb);
        System.out.println("ResultinJSONstring = "+json);
        
    }*/
    }
}
