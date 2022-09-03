package com.letscode.ecommerce.models;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductsDummyJsonList {
    private List<ProductsDummyJson> products;
    private float total;
    private float skip;
    private float limit;
}
