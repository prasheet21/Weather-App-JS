package com.myapp.stdlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class AlreadyReadBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read_books);

        TextView noBooksYet = findViewById(R.id.noBooksYet) ;

        RecyclerView recAlreadyRead = findViewById(R.id.AlreadyReadBooksRecView) ;
        ArrayList<books> alredyReadBooks = Utils.getSingletonInstance(this).getAlreadyRead() ;
        BooksAdapterClass adapter = new BooksAdapterClass(this , "AlreadyRead") ;
        if(Utils.getSingletonInstance(this).anyBooksExist(alredyReadBooks)){
            noBooksYet.setVisibility(View.VISIBLE);
            recAlreadyRead.setVisibility(View.GONE);
        }
        else{
            noBooksYet.setVisibility(View.GONE);
            recAlreadyRead.setVisibility(View.VISIBLE);
        }
        adapter.setAllBooks(alredyReadBooks);
        recAlreadyRead.setAdapter(adapter);
        recAlreadyRead.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AlreadyReadBooks.this , MainActivity.class) ;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK) ;
        startActivity(intent);
    }
}
