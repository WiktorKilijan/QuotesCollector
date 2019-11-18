package com.example.quotescollector.SQLDatabase.Handler;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.quotescollector.Model.QuoteFull;
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

    @Query("SELECT sourceTitle, sourceTypeName, s.sourceID " +
            "FROM source s JOIN SourceType st ON s.sourceTypeID = st.sourceTypeID " +
            "WHERE s.sourceID = :id")
    public List<SourceFull> getSourceFull(int id);

    @Query("SELECT sourceTitle, st.sourceTypeName, s.sourceID " +
            "FROM source s JOIN SourceType st ON s.sourceTypeID = st.sourceTypeID ")
    public List<SourceFull> getAllSourceFull();

    @Query("SELECT * FROM SourceType")
    public List<SourceType> getAllSourceTypes();

    @Query("SELECT * FROM Author")
    public List<Author> getAllAuthors();

    @Query("SELECT * FROM Source")
    public List<Source> getAllSources();

    @Query("SELECT quoteID, quote, description, authorName, s.sourceID " +
            "FROM quote q JOIN author a ON a.authorID = q.authorID " +
            "JOIN source s ON q.sourceID = s.sourceID")
    public List<QuoteFull> getAllQuotesFull();

    @Query("SELECT sourceTitle, st.sourceTypeName, s.sourceID " +
            "FROM source s JOIN SourceType st ON s.sourceTypeID = st.sourceTypeID " +
            "WHERE s.sourceID = :id")
    public SourceFull getSourceFullOne(int id);

    @Query("SELECT quoteID, quote, description, authorName, s.sourceID " +
            "FROM quote q JOIN author a ON a.authorID = q.authorID " +
            "JOIN source s ON q.sourceID = s.sourceID " +
            "WHERE q.quoteID = :id")
    public QuoteFull getQuoteFull(int id);


    // ===================== DELETE =====================
    @Query("DELETE FROM Quote;")
    public void deleteAllQuotes();

    @Query("DELETE FROM Quote WHERE quoteID = :id")
    public void deleteQuote(int id);


    // ===================== UPDATE =====================
    @Query("UPDATE Quote " +
            "SET quote = :quote, description = :description, authorID = :authorID, sourceID = :sourceID " +
            "WHERE quoteID = :id")
    public void updateQuote(int id, String quote, String description, int authorID, int sourceID);
}
