package com.myapp.stdlibrary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import java.util.ArrayList;

public class AllBooksActivity extends AppCompatActivity {
    RecyclerView recViewBooks ;
    BooksAdapterClass adapter ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        recViewBooks = findViewById(R.id.booksRecyclerView) ;

//        overridePendingTransition(R.anim.slide_in , R.anim.slide_out);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        adapter = new BooksAdapterClass(this , "AllBooks");
        recViewBooks.setAdapter(adapter);
        recViewBooks.setLayoutManager(new LinearLayoutManager(this));
        adapter.setAllBooks(Utils.getSingletonInstance(this).getAllbooks());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
