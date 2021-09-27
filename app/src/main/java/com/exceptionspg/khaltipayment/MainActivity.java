package com.exceptionspg.khaltipayment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvProducts;
    RecyclerAdapter myAdapter;
    LinearLayoutManager layoutManager;
    List<ProductModel> myProducts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvProducts = findViewById(R.id.rv_products);
        layoutManager = new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false);

        rvProducts.setLayoutManager(layoutManager);

        Drawable drawable1 =  getResources().getDrawable(getResources()
                .getIdentifier("ic_product1", "drawable", getPackageName()));
        Drawable drawable2 =  getResources().getDrawable(getResources()
                .getIdentifier("ic_product2", "drawable", getPackageName()));
        Drawable drawable3 =  getResources().getDrawable(getResources()
                .getIdentifier("ic_product3", "drawable", getPackageName()));

        myProducts.add(new ProductModel(drawable1,"Iphone", 2000L, "ex1001"));
        myProducts.add(new ProductModel(drawable2,"Laptop", 2500L, "ex1002"));
        myProducts.add(new ProductModel(drawable3,"Phone", 1500L, "ex1003"));



        myAdapter = new RecyclerAdapter(myProducts);
        rvProducts.setAdapter(myAdapter);




    }
}