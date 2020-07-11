package com.myapp.stdlibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CurrReadingBooks extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curr_reading_books);

        TextView noBooksYet = findViewById(R.id.noBooksYet) ;

        RecyclerView revViewCurrReading = findViewById(R.id.currentlyReadingBooksRecView);
        ArrayList<books> currReadingBooks = Utils.getSingletonInstance(this).getCurrentlyReading() ;
        BooksAdapterClass adapter = new BooksAdapterClass(this , "CurrentlyReading") ;
        if(Utils.getSingletonInstance(this).anyBooksExist(currReadingBooks)){
            noBooksYet.setVisibility(View.VISIBLE);
            revViewCurrReading.setVisibility(View.GONE);
        }
        else{
            noBooksYet.setVisibility(View.GONE);
            revViewCurrReading.setVisibility(View.VISIBLE);
        }

        adapter.setAllBooks(currReadingBooks);
        revViewCurrReading.setAdapter(adapter);
        revViewCurrReading.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this , MainActivity.class) ;
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK) ;
        startActivity(intent);
    }
}

