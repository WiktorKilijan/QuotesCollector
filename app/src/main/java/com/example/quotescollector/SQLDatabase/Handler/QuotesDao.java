package com.example.quotescollector.SQLDatabase.Handler;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.quotescollector.Model.SourceFull;
import com.example.quotescollector.SQLDatabase.DatabaseModel.Author;
import com.example.quotescollector.SQLDatabase.DatabaseModel.Category;
import com.example.quotescollector.SQLDatabase.DatabaseModel.Colour;
import com.example.quotescollector.SQLDatabase.DatabaseModel.Quote;
import com.example.quotescollector.SQLDatabase.DatabaseModel.QuoteInCategory;
import com.example.quotescollector.SQLDatabase.DatabaseModel.Source;
import com.example.quotescollector.SQLDatabase.DatabaseModel.SourceType;

import java.util.List;

@Dao
public interface QuotesDao {

    // ===================== INSERT =====================

    @Insert
    public long insertQuote(Quote quote);

    @Insert
    public long insertAuthor(Author author);

    @Insert
    public long insertSourceType(SourceType sourceType);

    @Insert
    public long insertSource(Source source);

    @Insert
    public long insertCategory(Category category);

    @Insert
    public long insertColour(Colour colour);

    @Insert
    public void insertQuoteInCategory(QuoteInCategory quoteInCategory);



    // ===================== SELECT =====================

    @Query("SELECT authorID FROM author WHERE authorName = :name")
    public int getAuthorID(String name);

    @Query("SELECT sourceTitle, sourceTypeName " +
            "FROM source s JOIN SourceType st ON s.sourceTypeID = st.sourceTypeID " +
            "WHERE s.sourceID = :id")
    public List<SourceFull> getSourceFull(int id);

    @Query("SELECT sourceTitle, st.sourceTypeName " +
            "FROM source s JOIN SourceType st ON s.sourceTypeID = st.sourceTypeID ")
    public List<SourceFull> getAllSourceFull();

    @Query("SELECT * FROM SourceType")
    public List<SourceType> getAllSourceTypes();

    @Query("SELECT * FROM Source")
    public List<Source> getAllSources();

    // ===================== DELETE =====================





//    static class SourceFull{
//
//        public String sourceTitle;
//        public String sourceTypeName;
//
//        @Override
//        public String toString(){
//            return sourceTitle + " " + sourceTypeName;
//        }
//    }

}