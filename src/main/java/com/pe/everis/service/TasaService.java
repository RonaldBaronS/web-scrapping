package com.pe.everis.service;

import com.pe.everis.entity.TasaRequest;
import com.pe.everis.entity.TasaResponse;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.UnsupportedMimeTypeException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TasaService {

    /** URL de la web de consulta de publicaciones de la tasa sbs. */
    private static final String URL_COMMISIONS_WEB = "https://www.sbs.gob.pe/app/retasas/paginas/retasasInicio.aspx";

    /** URL del servicio de consulta de publicaciones de la tasa sbs. */
    private static final String URL_COMMISIONS_SERVICE = "https://www.sbs.gob.pe/app/retasas/paginas/RetasasResultados.aspx";
    
    public List<TasaResponse> getTasas(TasaRequest request) throws MalformedURLException, HttpStatusException,
            UnsupportedMimeTypeException, SocketTimeoutException, IOException {
        
        List<TasaResponse> tasas = new ArrayList<>();
        
      //Realizamos petición a la página de la sbs para obtener las cookies.
        Connection.Response response = Jsoup
                .connect(URL_COMMISIONS_WEB)
                .method(Connection.Method.GET)
                .execute();
        
      //Realizamos petición al servicio de consulta de tasas
        Document serviceResponse = Jsoup
                .connect(URL_COMMISIONS_SERVICE)
                .userAgent("Chrome/80.0.3987.149")
                .timeout(10 * 1000)
                .cookies(response.cookies())
                .data("region",request.getRegion())
                .data("operacion",request.getOperacion())
                .data("producto",request.getProducto())
                .data("condicion",request.getCondicion())
                .post();
        
     // Procesamos la tabla de resultados: formulario + resultados.
        Element table = serviceResponse.select("table").first();
        
        if (table!=null) {
            Elements rows = table.select("tr");
            log.info("Tamanio if : "+rows.size());
            for (int i = 1; i < rows.size(); i++) {
                Elements values = rows.get(i).select("td");
                String entidad = values.get(0).text();
                String tasa = values.get(1).text();
                log.info("Entidad : "+entidad);
                log.info("Tasas : "+tasa);
                tasas.add(new TasaResponse(entidad, tasa));
                log.info("Lista Tasas -> "+tasas);
            }
        }
        return tasas;
    }
    
    
    
}
