package com.letscode.ecommerce.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letscode.ecommerce.models.ProductsDummyJsonList;
import com.letscode.ecommerce.restclient.FinanceiroRestClient;

@RestController
public class PoductsDummyEndpoints {

    @Autowired
    FinanceiroRestClient restClient;

    @RequestMapping(path = "/productsDummy/categorias", method = RequestMethod.GET)
    public ResponseEntity<List<String>> getAllCategories() {
        return ResponseEntity.ok(restClient.findAll());
    }

    @RequestMapping(path = "/productsDummy/search", method = RequestMethod.GET)
    public ResponseEntity<ProductsDummyJsonList> searchProducts(@RequestParam(value = "q") String product) {
        return ResponseEntity.ok(restClient.searchProducts(product));
    }
}
