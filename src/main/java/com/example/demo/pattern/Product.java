package com.example.demo.pattern;

/**
 * A simple Builder Pattern
 *
 * Created by wuj42 on 7/31/2017.
 */
public class Product {

    private String x;
    private String y;
    private String z;

    private Product(Product.Builder builder){
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
    }

    public static Product.Builder builder(){
        return new Product.Builder();
    }

    @Override
    public String toString(){
        return "x:" + x + ",y:" + y + ",z:" + z;
    }

    public static final class Builder {

        private String x;
        private String y;
        private String z;

        private Builder() {}

        public final Builder x(String x){
            this.x = x;
            return this;
        }

        public final Builder y(String y){
            this.y = y;
            return this;
        }

        public final Builder z(String z){
            this.z = z;
            return this;
        }

        public Product build(){
            return new Product(this);
        }

    }

    public static void main(String[] args) {
        System.out.println(Product.builder().x("a").y("b").z("c").build());
    }

}
