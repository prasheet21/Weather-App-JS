package com.myapp.stdlibrary;
import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {

    private final String ALL_BOOKS_OPT = "All_Books" ;
    private final String FAV_BOOKS_OPT = "Fav_Books" ;
    private final String ALREADY_READ_BOOKS = "Already_Read_Books" ;
    private final String CURRENTLY_READING_BOOKS = "Already_Reading_Books" ;


    private SharedPreferences sharedPreference ;
//    private static ArrayList<books> favBooks ;
//    private static ArrayList<books> currentlyReading ;
//    private static ArrayList<books> alreadyRead ;
    private static Utils singletonInstance ;

    public static Utils getSingletonInstance(Context context) {
        if (singletonInstance != null){
            return singletonInstance ;
        }
        else{
            singletonInstance = new Utils(context) ;
            return singletonInstance ;
        }

    }

    private Utils(Context context) {

        sharedPreference = context.getSharedPreferences("Alternate_db" , Context.MODE_PRIVATE) ;

        Gson gson = new Gson() ;
        SharedPreferences.Editor editor = sharedPreference.edit() ;
        if (getAllbooks() == null)
            initData() ;
        if (getFavBooks() == null){
            editor.putString(FAV_BOOKS_OPT , gson.toJson(new ArrayList<books>())) ;
            editor.commit() ;
        }

        if (getAlreadyRead() == null) {
            editor.putString(ALREADY_READ_BOOKS, gson.toJson(new ArrayList<books>()));
            editor.commit() ;
        }
        if (getCurrentlyReading() == null){
            editor.putString(CURRENTLY_READING_BOOKS , gson.toJson(new ArrayList<books>())) ;
            editor.commit() ;
        }
    }

    private void initData() {

        ArrayList<books> buk  = new ArrayList<>();
        buk.add(new books(1 ,"Truly Devious" , "Rs. 319" , "Maureen Johnson" , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1498501619i/29589074._UY1024_SS1024_.jpg" , "200" , "Ellingham Academy is a famous private school in Vermont for the brightest thinkers, inventors, and artists. Shortly after the school opened, the founder's wife and daughter were kidnapped." )) ;
        buk.add(new books(2,"The Guest List" , "Rs. 400" , "Lucy Foley" , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1568574375l/52656911._SX0_SY0_.jpg" , "189" , "In a world obsessed with finding the next cutting-edge thing, sometimes the smartest way to stand out is to get back to basics. British author Lucy Foley has made a name for herself with two suspense novels that do exactly that, the newest of which will release in the US this summer. THE GUEST LIST is a delectable blend of Agatha Christie inspiration and modern-day psychological suspense. This is a “locked room mystery” built for the readers of 2020: a story concerned with secrets—among spouses, partners, and siblings—and their deadly collision. Set on a remote island off the coast of Ireland, THE GUEST LIST gives readers an exclusive invitation to one of the most buzzed-about parties of the year: the wedding of a powerhouse digital magazine editor and a TV golden boy. The wedding has been planned to perfection; the only wild card here is the wedding’s guest list. Will this reunion of old friends, classmates, and family go as smoothly as our bride and groom hope? Or will old secrets and resentments rear their ugly heads? When a storm traps the wedding party on the island, tensions ratchet up until someone winds up dead. With as much of an eye for high fashion and high-stakes secrets as it has for traditional crime novel structure and inspiration, THE GUEST LIST is a perfect reminder of why the classics never go out of style. " )) ;
        buk.add(new books(1,"Truly Devious" , "Rs. 319" , "Maureen Johnson" , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1498501619i/29589074._UY1024_SS1024_.jpg" , "200" , "Ellingham Academy is a famous private school in Vermont for the brightest thinkers, inventors, and artists. Shortly after the school opened, the founder's wife and daughter were kidnapped." )) ;
        buk.add(new books(1,"Truly Devious" , "Rs. 319" , "Maureen Johnson" , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1498501619i/29589074._UY1024_SS1024_.jpg" , "200" , "Ellingham Academy is a famous private school in Vermont for the brightest thinkers, inventors, and artists. Shortly after the school opened, the founder's wife and daughter were kidnapped." )) ;
        buk.add(new books(1,"Truly Devious" , "Rs. 319" , "Maureen Johnson" , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1498501619i/29589074._UY1024_SS1024_.jpg" , "200" , "Ellingham Academy is a famous private school in Vermont for the brightest thinkers, inventors, and artists. Shortly after the school opened, the founder's wife and daughter were kidnapped." )) ;
        buk.add(new books(1,"Truly Devious" , "Rs. 319" , "Maureen Johnson" , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1498501619i/29589074._UY1024_SS1024_.jpg" , "200" , "Ellingham Academy is a famous private school in Vermont for the brightest thinkers, inventors, and artists. Shortly after the school opened, the founder's wife and daughter were kidnapped." )) ;
        buk.add(new books(1,"Truly Devious" , "Rs. 319" , "Maureen Johnson" , "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1498501619i/29589074._UY1024_SS1024_.jpg" , "200" , "Ellingham Academy is a famous private school in Vermont for the brightest thinkers, inventors, and artists. Shortly after the school opened, the founder's wife and daughter were kidnapped." )) ;

        SharedPreferences.Editor editor = sharedPreference.edit() ;

        Gson gson = new Gson();
        String serialize_book_obj = gson.toJson(buk) ;
        editor.putString(ALL_BOOKS_OPT , serialize_book_obj) ;
        editor.commit() ;

    }


    public ArrayList<books> getAllbooks() {

        Gson gson = new Gson() ;
        Type type = new TypeToken<ArrayList<books>>(){}.getType() ;
        ArrayList<books> AllBooks = gson.fromJson(sharedPreference.getString(ALL_BOOKS_OPT , null ) , type) ;
        return AllBooks;

    }



    public ArrayList<books> getFavBooks() {
        Gson gson = new Gson() ;
        Type type = new TypeToken<ArrayList<books>>(){}.getType() ;
        ArrayList<books> FavBooks = gson.fromJson(sharedPreference.getString(FAV_BOOKS_OPT , null ) , type) ;
        return FavBooks;
    }

    public void setFavBooks(ArrayList<books> favBooks) {
        Gson gson = new Gson() ;
        SharedPreferences.Editor editor = sharedPreference.edit() ;
        editor.putString(FAV_BOOKS_OPT , gson.toJson(favBooks)) ;
        editor.commit() ;
    }

    public ArrayList<books> getCurrentlyReading() {
        Gson gson = new Gson() ;
        Type type = new TypeToken<ArrayList<books>>(){}.getType() ;
        ArrayList<books> CurrBooks = gson.fromJson(sharedPreference.getString(CURRENTLY_READING_BOOKS , null ) , type) ;
        return CurrBooks;
    }

    public void setCurrentlyReading(ArrayList<books> currentlyReading) {
        Gson gson = new Gson() ;
        SharedPreferences.Editor editor = sharedPreference.edit() ;
        editor.putString(CURRENTLY_READING_BOOKS , gson.toJson(currentlyReading )) ;
        editor.commit() ;
    }

    public ArrayList<books> getAlreadyRead() {
        Gson gson = new Gson() ;
        Type type = new TypeToken<ArrayList<books>>(){}.getType() ;
        ArrayList<books> alreadyRead = gson.fromJson(sharedPreference.getString(ALREADY_READ_BOOKS , null ) , type) ;
        return alreadyRead ;
    }

    public void setAlreadyRead(ArrayList<books> alreadyRead) {
        Gson gson = new Gson() ;
        SharedPreferences.Editor editor = sharedPreference.edit() ;
        editor.putString(ALREADY_READ_BOOKS , gson.toJson(alreadyRead)) ;
        editor.commit() ;
    }

    public boolean FavBooksExist(books book){
        Gson gson = new Gson() ;
        Type type = new TypeToken<ArrayList<books>>(){}.getType() ;
        boolean favAlreadyExist = false ;
        ArrayList<books> FavBooks = gson.fromJson(sharedPreference.getString(FAV_BOOKS_OPT , null) , type) ;
        for (books b: FavBooks) {
            if (b.getBookId() == book.getBookId()){
                favAlreadyExist = true ;
                break;
            }
        }
        return  favAlreadyExist ;
    }

    public boolean AlreadyReadBooksExist(books book){
        Gson gson = new Gson() ;
        Type type = new TypeToken<ArrayList<books>>(){}.getType() ;
        boolean AlreadyReadAlreadyExist = false ;
        ArrayList<books> alreadyRead = gson.fromJson(sharedPreference.getString(ALREADY_READ_BOOKS , null) , type ) ;
        for (books b: alreadyRead) {
            if (b.getBookId() == book.getBookId()){
                AlreadyReadAlreadyExist = true ;
                return AlreadyReadAlreadyExist ;
            }
        }
        return  AlreadyReadAlreadyExist ;
    }

    public boolean CurrentlyReadBooksExist(books book){
        Gson gson = new Gson() ;
        Type type = new TypeToken<ArrayList<books>>(){}.getType() ;
        boolean curerentlyReadingBooksAlreadyExist = false ;
        ArrayList<books> currentlyReading = gson.fromJson(sharedPreference.getString(CURRENTLY_READING_BOOKS , null) , type) ;
        if (currentlyReading != null){
            for (books b: currentlyReading) {
                if (b.getBookId() == book.getBookId()){
                    curerentlyReadingBooksAlreadyExist = true ;
                    return curerentlyReadingBooksAlreadyExist ;
                }
            }
        }
        return  curerentlyReadingBooksAlreadyExist ;
    }

    public boolean anyBooksExist(ArrayList<books> buk){
        if(buk.isEmpty()){
            return true ;
        }
        else{
            return false ;
        }
    }
}
