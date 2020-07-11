package com.myapp.stdlibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView app_name ;
    Button showAllBooks , CurrentBooks , favBooks , about , alreadyRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        app_name = findViewById(R.id.AppName) ;
        showAllBooks = findViewById(R.id.allBooks) ;
        CurrentBooks = findViewById(R.id.currentBooks) ;
        favBooks = findViewById(R.id.favBooks) ;
        alreadyRead = findViewById(R.id.alreadyRead) ;
        about = findViewById(R.id.about) ;
        app_name.setTextColor(Color.WHITE);

        showAllBooks.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this , AllBooksActivity.class) ;
                startActivity(intent);
            }
        });

        CurrentBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , CurrReadingBooks.class) ;
                startActivity(intent);
            }
        });

        favBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , favBooks.class) ;
                startActivity(intent);
            }
        });
        alreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , AlreadyReadBooks.class) ;
                startActivity(intent);
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this) ;
                builder.setMessage("This Application is Created By Prasheet Pathak . \n Copyright Applied . \n Do you want to visit our official page .. !!") ;
                builder.setPositiveButton("Visit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent = new Intent(MainActivity.this , webViewAbout.class) ;
                        startActivity(intent);
                    }
                }) ;
                builder.setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }) ;
            builder.create().show() ;
            }
        });


    }
}
