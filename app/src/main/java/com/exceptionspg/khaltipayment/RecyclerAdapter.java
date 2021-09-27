package com.exceptionspg.khaltipayment;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khalti.checkout.helper.Config;
import com.khalti.checkout.helper.KhaltiCheckOut;
import com.khalti.checkout.helper.OnCheckOutListener;
import com.khalti.checkout.helper.PaymentPreference;
import com.khalti.utils.Constant;
import com.khalti.widget.KhaltiButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.viewHolder> {

    List<ProductModel> products;
    ProductModel myProduct;

    public RecyclerAdapter(List<ProductModel> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        myProduct = products.get(position);
        holder.tvProductPrice.setText("Rs. "+myProduct.getProductPrice());
        holder.ivProductImage.setImageDrawable(myProduct.getProductImage());
        holder.tvProductName.setText(myProduct.getProductName());

        khaltiImplement(holder.itemView.getContext(),holder.kbBuy,myProduct.getProductId(),myProduct.getProductName(),myProduct.getProductPrice());



    }

    @Override
    public int getItemCount() {
        return products.size();
    }


    public void khaltiImplement(Context mCtx, KhaltiButton kBuy,String productId, String productName, Long price){

        Long priceInPaisa = price*100;

        Config.Builder builder = new Config.Builder(Constant.pub, productId, productName, priceInPaisa, new OnCheckOutListener() {
            @Override
            public void onError(@NonNull String action, @NonNull Map<String, String> errorMap) {
                Log.i(action, errorMap.toString());

            }

            @Override
            public void onSuccess(@NonNull Map<String, Object> data) {
                Log.i("success", data.toString());
                Toast.makeText(mCtx, "Success: "+data.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Config config = builder.build();
        kBuy.setCheckOutConfig(config);
//        KhaltiCheckOut khaltiCheckOut1 = new KhaltiCheckOut(mCtx, config);
//        kBuy.setOnClickListener(v -> khaltiCheckOut1.show());



    }

    public class  viewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName, tvProductPrice;
        ImageView ivProductImage;
        KhaltiButton kbBuy;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tv_product_name);
            tvProductPrice = itemView.findViewById(R.id.tv_price);
            ivProductImage = itemView.findViewById(R.id.iv_product_image);
            kbBuy = itemView.findViewById(R.id.kb_buy);
        }
    }
}
