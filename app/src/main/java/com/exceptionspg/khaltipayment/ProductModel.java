package com.exceptionspg.khaltipayment;

import android.graphics.drawable.Drawable;

public class ProductModel {
    Drawable productImage;
    String productName;
    Long productPrice;
    String productId;

    public ProductModel(Drawable productImage, String productName, Long productPrice, String productId) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productId = productId;
    }

    public Drawable getProductImage() {
        return productImage;
    }

    public String getProductName() {
        return productName;
    }

    public Long getProductPrice() {
        return productPrice;
    }

    public String getProductId() {
        return productId;
    }
}
