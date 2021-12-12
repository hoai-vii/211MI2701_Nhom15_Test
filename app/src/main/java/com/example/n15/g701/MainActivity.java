package com.example.n15.g701;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContainer;
    ArrayList<Product> products;
    ProductAdapter adapter;
    MyDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkView();
        prepareDB();
        initData();
    }

    //Menu addBook

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnAddBook) {

        }
        return super.onOptionsItemSelected(item);
    }

    private void openAddScreen() {
        Intent intent = new Intent(MainActivity.this, AddProduct.class);
        startActivity(intent);
    }



    private void linkView() {
        lvContainer = findViewById(R.id.lvProduct);
    }

    private void prepareDB() {
        db = new MyDatabase(MainActivity.this);
        Bitmap ipad = BitmapFactory.decodeResource(getResources(),
                R.drawable.ipad);
        Bitmap laptop = BitmapFactory.decodeResource(getResources(),
                R.drawable.laptop);
        db.insertData("Laptop","Dell",12000000, MyDatabase.getBitmapAsByteArray(laptop));
        db.insertData("Ipad","Sam sung", 8000000, MyDatabase.getBitmapAsByteArray(ipad));
    }


    private void initData() {
        adapter = new ProductAdapter(MainActivity.this,R.layout.item_book,getDataFromDB());
        lvContainer.setAdapter(adapter);
    }

    public ArrayList<Product> getDataFromDB(){
        products =new ArrayList<>();
        Cursor cursor = db.getData("SELECT * FROM " + MyDatabase.TBL_NAME);
        products.clear();
        while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String name = cursor.getString(1);
            String publisher = cursor.getString(2);
            float price = cursor.getFloat(3);
            byte[] image = cursor.getBlob(4);
            products.add(new Product(id,name,publisher,price,image));
        }
        cursor.close();
        return products;

    }


}