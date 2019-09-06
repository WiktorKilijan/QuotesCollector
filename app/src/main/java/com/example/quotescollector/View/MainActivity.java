package com.example.quotescollector.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.quotescollector.Model.SourceFull;
import com.example.quotescollector.R;
import com.example.quotescollector.SQLDatabase.DatabaseModel.Author;
import com.example.quotescollector.SQLDatabase.DatabaseModel.Quote;
import com.example.quotescollector.SQLDatabase.DatabaseModel.Source;
import com.example.quotescollector.SQLDatabase.DatabaseModel.SourceType;
import com.example.quotescollector.SQLDatabase.Handler.QuotesDao;
import com.example.quotescollector.SQLDatabase.Handler.QuotesDatabase;

public class MainActivity extends AppCompatActivity {

    QuotesDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = QuotesDatabase.getInstance(this);

        database.quotesDao().insertAuthor(new Author("Stephen King"));
        database.quotesDao().insertAuthor(new Author("Stephen Hawking"));
        database.quotesDao().insertAuthor(new Author("Richard Dawkins"));

        database.quotesDao().insertSourceType(new SourceType("book"));
        database.quotesDao().insertSourceType(new SourceType("movie"));
        database.quotesDao().insertSourceType(new SourceType("magazine"));
        database.quotesDao().insertSourceType(new SourceType("real life"));

        database.quotesDao().insertSource(new Source("Krotka historia czasu", 1));
        database.quotesDao().insertSource(new Source("Dluga historia czasu", 1));
        database.quotesDao().insertSource(new Source("Srednia historia czasu", 2));

        database.quotesDao().insertQuote(new Quote("Byl sobie wielki wybuch", "jakis opis",
                2, 1));
        database.quotesDao().insertQuote(new Quote("Byl sobie wielki wybuch", "jakis opis",
                2, 1));

        for(SourceFull s : database.quotesDao().getAllSourceFull()){
            Log.d("aaaa", s.toString());
        }
    }
}