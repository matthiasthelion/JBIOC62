package org.portaltasks.productmgmt;

import java.util.List;

public class ProductUtilities {
    private static List<Product> products;

    public String addProduct(String SKUID, String productName, double price){
        try{
            if(products.stream().anyMatch(p -> p.getSKUID().equals(SKUID))){
                return "Error: Duplicated SKUID";
            }
            products.add(new Product(SKUID, productName, price));
            return "OK";
        } catch (Exception e){
            return "Error: "+e.getMessage();
        }
    }

    public String removeProduct(String SKUID){
        try{
            Product product = products.stream().filter(p -> p.getSKUID().equals(SKUID)).findFirst().get();
            products.remove(product);
            return "OK";
        } catch (Exception e){
            return "Error: "+e.getMessage();
        }
    }
    public String updateProduct(String SKUID, String productName, double price){
        try{
            Product product = products.stream().filter(p -> p.getSKUID().equals(SKUID)).findFirst().get();
            product.setProductName(productName);
            product.setPrice(price);
            return "OK";
        } catch (Exception e){
            return "Error: "+e.getMessage();
        }
    }

    public void printAllProducts(){
        products.forEach(System.out::println);
    }
    public void printProduct(String SKUID){
        products.stream().filter(p -> p.getSKUID().equals(SKUID)).findFirst().ifPresent(System.out::println);
    }
}
