package com.letscode.ecommerce.restclient;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.letscode.ecommerce.models.ProductsDummyJsonList;

@FeignClient(value = "financeiroRestClient", url = "https://dummyjson.com")
public interface FinanceiroRestClient {

    @RequestMapping(path = "/products/categories", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    List<String> findAll();

    @RequestMapping(path = "/products/search", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
    ProductsDummyJsonList searchProducts(@RequestParam(value = "q") String product);
}
