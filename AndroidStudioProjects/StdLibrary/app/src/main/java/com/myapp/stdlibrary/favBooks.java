package com.myapp.stdlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class favBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav_books);

        TextView noBooksYet = findViewById(R.id.noBooksYet);

        RecyclerView revViewFavBooks = findViewById(R.id.recyclerViewFavBooks);
        ArrayList<books> favBooks = Utils.getSingletonInstance(this).getFavBooks();
        BooksAdapterClass adapter = new BooksAdapterClass(this , "FavroiteBook");
        if (Utils.getSingletonInstance(this).anyBooksExist(favBooks)) {
            noBooksYet.setVisibility(View.VISIBLE);
            revViewFavBooks.setVisibility(View.GONE);
        } else {
            noBooksYet.setVisibility(View.GONE);
            revViewFavBooks.setVisibility(View.VISIBLE);
        }
        adapter.setAllBooks(favBooks);
        revViewFavBooks.setAdapter(adapter);
        revViewFavBooks.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(favBooks.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
