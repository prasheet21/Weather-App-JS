package com.myapp.stdlibrary;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class BooksAdapterClass extends RecyclerView.Adapter<BooksAdapterClass.ViewHolder> {

    public final String ALL_BOOK_TITLE = "AllBooks" ;
    public final String CURRENTLY_READING_TITLE = "CurrentlyReading" ;
    public final String ALREADY_READ_TITLE = "AlreadyRead" ;
    public final String FAV_BOOK_TITLE = "FavroiteBook" ;

    static ArrayList<books> allBooks ;
    Context context ;
    String context_title ;

    public BooksAdapterClass(Context context , String context_title) {
        this.context = context;
        this.context_title = context_title ;
    }

    @NonNull
    @Override

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item_layout , parent , false) ;
        ViewHolder holder = new ViewHolder(view) ;
        return holder ;
    }

    @SuppressLint("CheckResult")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.bookName.setText(allBooks.get(position).getBookName());
        holder.authorName.setText(allBooks.get(position).getAuthor());
        holder.price.setText("Price - " + allBooks.get(position).getBookPrice());
        Glide.with(context).asBitmap().load(allBooks.get(position).getImageURL()).into(holder.bookImage) ;
        holder.bookImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , BookClickActvity.class) ;
                intent.putExtra("BookId" , allBooks.get(position).getBookId()) ;
                context.startActivity(intent);
            }
        });

        holder.buyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Buy Now Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        if (allBooks.get(position).isExpanded()){
//            androidx.transition.TransitionManager.beginDelayedTransition(holder.bookCardView);
            holder.OpenRelLayout.setVisibility(View.VISIBLE);
            holder.arrowDown.setVisibility(View.GONE);
        }else{

//            androidx.transition.TransitionManager.beginDelayedTransition(holder.bookCardView);
            holder.OpenRelLayout.setVisibility(View.GONE);
            holder.arrowDown.setVisibility(View.VISIBLE);
        }

        if (context_title.equals(ALL_BOOK_TITLE)){
            holder.deleteBtn.setVisibility(View.GONE);
        }else if(context_title.equals(CURRENTLY_READING_TITLE)){
            holder.deleteBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context) ;
                    builder.setMessage("Surely want to delete the book ... !!!") ;
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ArrayList<books> currentlyReadingDeletion = Utils.getSingletonInstance(context).getCurrentlyReading() ;
                            currentlyReadingDeletion.remove(currentlyReadingDeletion.get(position)) ;
                            Utils.getSingletonInstance(context).setCurrentlyReading(currentlyReadingDeletion);
                            notifyDataSetChanged() ;
                        }
                    }) ;
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }) ;
                builder.create().show();
                }
            });
        }else if (context_title.equals(ALREADY_READ_TITLE)){
            holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context) ;
                    builder.setMessage("Surely want to delete the book ... !!!") ;
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            ArrayList<books> AlreadyReadDeletion = Utils.getSingletonInstance(context).getAlreadyRead() ;
                            AlreadyReadDeletion.remove(AlreadyReadDeletion.get(position)) ;
                            Utils.getSingletonInstance(context).setAlreadyRead(AlreadyReadDeletion);
                            notifyDataSetChanged();
                        }
                    }) ;
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }) ;
                    builder.create().show();
                }
            });

        }else{
            holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context) ;
                    builder.setMessage("Surely want to delete the book ... !!!") ;
                    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            ArrayList<books> FavBooksDeletion = Utils.getSingletonInstance(context).getFavBooks() ;
                            FavBooksDeletion.remove(FavBooksDeletion.get(position)) ;
                            Utils.getSingletonInstance(context).setFavBooks(FavBooksDeletion);
                            notifyDataSetChanged();
                        }
                    }) ;
                    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    }) ;
                    builder.create().show();
                }
            });
        }



    }

    public static books getBooksById(int id){
        for (books b:allBooks) {
            if (b.getBookId() == id){
                return b ;
            }

        }
        return null ;
    }

    public void setAllBooks(ArrayList<books> allBooks) {
        this.allBooks = allBooks;
    }

    @Override
    public int getItemCount() {
        return allBooks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView bookImage , arrowUp , arrowDown ;
        RelativeLayout CollapsedRelLayout , OpenRelLayout ;
        TextView bookName , authorName , price  , deleteBtn;
        Button buyNow ;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            buyNow = itemView.findViewById(R.id.ButNow) ;
            bookImage = itemView.findViewById(R.id.bookImageView) ;
            bookName = itemView.findViewById(R.id.bookNameView) ;
            authorName = itemView.findViewById(R.id.authorNameView) ;
            price = itemView.findViewById(R.id.priceView) ;
            arrowDown = itemView.findViewById(R.id.arrowDown) ;
            arrowUp = itemView.findViewById(R.id.arrowUp) ;
            CollapsedRelLayout = itemView.findViewById(R.id.CollapsedViewBookDetils) ;
            OpenRelLayout = itemView.findViewById(R.id.OpenBookDetails) ;
            deleteBtn = itemView.findViewById(R.id.deleteItemBook) ;




            onEvent();

        }
        private void onEvent(){
            arrowDown.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    books buk = allBooks.get(getAdapterPosition()) ;
                    buk.setExpanded(!buk.isExpanded());
                    notifyItemChanged(getAdapterPosition());
                }
            });
            arrowUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    books buk = allBooks.get(getAdapterPosition()) ;
                    buk.setExpanded(!buk.isExpanded());

                    notifyItemChanged(getAdapterPosition());
                }
            });

        }



    }
}
