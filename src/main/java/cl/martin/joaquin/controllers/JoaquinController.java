package cl.martin.joaquin.controllers;

import cl.martin.joaquin.entities.JoaquinRequest;
import cl.martin.joaquin.entities.JoaquinResponse;
import cl.martin.joaquin.entities.Product;
import org.apache.camel.ProducerTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoaquinController {

    @Autowired
    private ProducerTemplate producerTemplate;

    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<JoaquinResponse> post(@RequestBody JoaquinRequest joaquinRequest) {
        JoaquinResponse joaquinResponse = new JoaquinResponse();
        joaquinResponse.setName("Joaquin");
        return new ResponseEntity<>(joaquinResponse, HttpStatus.OK);
    }

    @GetMapping("/products/{category}")
    @ResponseBody
    public List<Product> getProductsByCategory(@PathVariable("category") final String category){
        producerTemplate.start();
        List<Product> products = producerTemplate.requestBody("direct:getKids", category, List.class);
        producerTemplate.stop();
        return products;

    }

}
