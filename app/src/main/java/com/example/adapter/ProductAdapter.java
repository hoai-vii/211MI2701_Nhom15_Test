package com.example.adapter;

import android.app.BackgroundServiceStartNotAllowedException;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Product;
import com.example.n15.g701.MainActivity;
import com.example.n15.g701.R;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    MainActivity context;
    int item;
    List<Product> products;

    public ProductAdapter(MainActivity context, int item, List<Product> products) {
        this.context = context;
        this.item = item;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }


    @Override
    public Object getItem(int i) {
        return products.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(item,null);
            holder.txtName = view.findViewById(R.id.txtName);
            holder.imvProduct = view.findViewById(R.id.imvProduct);
            holder.txtPrice = view.findViewById(R.id.txtPrice);
            holder.txtManufacturer = view.findViewById(R.id.txtProducer);
            holder.imvEdit = view.findViewById(R.id.imvEdit);
            holder.imvDelete = view.findViewById(R.id.imvDelete);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }

        //Biding data
        Product t = products.get(i);
        holder.txtName.setText(t.getProductName());
        holder.txtPrice.setText(String.valueOf(t.getPrice()));
        holder.txtManufacturer.setText(t.getHangSX());
        byte [] photo = t.getImageProduct();
        Bitmap bitmap = BitmapFactory.decodeByteArray(photo, 0,photo.length);
        holder.imvProduct.setImageBitmap(bitmap);

        return view;
    }

    public static class ViewHolder {
        ImageView imvProduct,imvEdit,imvDelete;
        TextView txtName,txtManufacturer, txtPrice;

    }
}
