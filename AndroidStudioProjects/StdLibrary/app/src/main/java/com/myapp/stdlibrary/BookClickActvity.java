package com.myapp.stdlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

import java.util.ArrayList;

public class BookClickActvity extends AppCompatActivity {

    private books book ;

    private ImageView bookImage ;
    private Button addFavroite , currentBook , alreadyRead ;
    private TextView authorName , bookName , pages , discription ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_click_actvity);
        initItems() ;
        Log.d("Test" ,"This is test message .....");


//        books book = new books(1,"Truly Devious" , "Rs. 319" , "Maureen Johnson" , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1498501619i/29589074._UY1024_SS1024_.jpg" , "200" , "Ellingham Academy is a famous private school in Vermont for the brightest thinkers, inventors, and artists. Shortly after the school opened, the founder's wife and daughter were kidnapped. The post has just arrived and in it a very nice surprise, the discovery that Jacques Seguela, one-time adviser to President Mitterrand, now close confidant of President and Madame Sarkozy (indeed he intoduced them), and something of a legend in French political communications, has dedicated his latest book to little old moi.\n" +
//                "\n" +
//                "With apologies for the missing accents here and in the French bits of the long posting which follows – the dedication to ‘Le Pouvoir dans la Peau‘ (Power in the skin) reads ‘A Alastair Campbell, mon spin doctor prefere’ (three missing accents in one word – mes excuses sinceres).\n" +
//                "\n" +
//                "So what did I do for this honour, you are asking? Well, perhaps the fact that he asked me to read his book, and write a ‘postface’ assessment both of his writing and of the issues he covers, and the fact that I said yes, has something to do with it. He says some blushmakingly kind things in his ‘preface to the postface’, which I will have to leave to French readers of the whole thing (published by Plon). But for the largely Anglophone visitors of this blog, I thought some of you might like to read the said ‘postface’ in English (apart from the bits where I quote direct from his book). I hope all those students who write asking for help with dissertations will find something quotable in it.\n" +
//                "\n" +
//                "Meanwhile I am off to Norway for a conference and a meeting with the Norwegian Labour Party. I’m looking forward to being in the country with the highest ‘human development index’ in the world, and which showed such a mature response to the recent massacre of Oslo and Utoya." ) ;

        Intent bookIntent = getIntent() ;
        if (bookIntent != null){
            int bookId = bookIntent.getIntExtra("BookId" , -1 ) ;
            if (bookId != -1){
                book = BooksAdapterClass.getBooksById(bookId) ;
                if (book != null)
                    setData(book) ;
                handleFavBooks(book) ;
                handleCurrentlyReadingBooks(book) ;
                handleAlreadyReadBooks(book) ;
            }
        }


    }

    private void handleFavBooks(final books book) {
        if (Utils.getSingletonInstance(this).FavBooksExist(book)){
            addFavroite.setEnabled(false);
        }
        else{
            addFavroite.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BookClickActvity.this, "Book Added To Favorite", Toast.LENGTH_SHORT).show();
                    ArrayList<books> favs = Utils.getSingletonInstance(BookClickActvity.this).getFavBooks() ;
                    favs.add(book) ;
                    Utils.getSingletonInstance(BookClickActvity.this).setFavBooks(favs);
                    addFavroite.setEnabled(false);


                }
            });
        }

    }

    private void handleCurrentlyReadingBooks(final books book) {
        if (Utils.getSingletonInstance(this).CurrentlyReadBooksExist(book)){
            currentBook.setEnabled(false);
        }
        else{
            currentBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BookClickActvity.this, "Book Added To Currently Reading", Toast.LENGTH_SHORT).show();
                    ArrayList<books> favs = Utils.getSingletonInstance(BookClickActvity.this).getCurrentlyReading() ;
                    favs.add(book) ;
                    Utils.getSingletonInstance(BookClickActvity.this).setCurrentlyReading(favs);
                    currentBook.setEnabled(false);
                }
            });
        }

    }

    private void handleAlreadyReadBooks(final books book) {
        if (Utils.getSingletonInstance(this).AlreadyReadBooksExist(book)){
            alreadyRead.setEnabled(false);
        }
        else{
            alreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(BookClickActvity.this, "Book Added To Already Read", Toast.LENGTH_SHORT).show();
                    ArrayList<books> favs = Utils.getSingletonInstance(BookClickActvity.this).getAlreadyRead() ;
                    favs.add(book) ;
                    Utils.getSingletonInstance(BookClickActvity.this).setAlreadyRead(favs);
                    alreadyRead.setEnabled(false);
                }
            });
        }

    }





    private void setData(books book){
        Glide.with(this).asBitmap().load(book.getImageURL()).into(bookImage) ;
        authorName.setText("Author : " + book.getAuthor());
        bookName.setText(book.getBookName());
        pages.setText("Pages : " + book.getPages());
        discription.setText("Description - \n" + book.getDescription());

    }

    private void initItems(){
        bookImage = findViewById(R.id.BookImage) ;
        alreadyRead = findViewById(R.id.alRead) ;
        addFavroite = findViewById(R.id.AddingFavroite) ;
        currentBook = findViewById(R.id.CurrRead) ;
        authorName = findViewById(R.id.authName) ;
        bookName = findViewById(R.id.bookName) ;
        pages = findViewById(R.id.pages) ;
        discription = findViewById(R.id.DisText) ;

    }
}
