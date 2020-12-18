package info.dddeurope.lab.app.views;

import java.util.List;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.Term;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.TermQuery;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.document.Field;

import info.dddeurope.lab.utils.LuceneIndex.InMemoryLuceneIndex;
import info.dddeurope.lab.app.dtos.Post;

public class PostsIndex {

    InMemoryLuceneIndex inMemoryLuceneIndex;

    public PostsIndex() {
        this.inMemoryLuceneIndex = new InMemoryLuceneIndex(new RAMDirectory(), new StandardAnalyzer());
    }

    public void indexPost(Post post) {
        Document document = new Document();
        document.add(new TextField("id", post.getId(), Field.Store.YES));
        document.add(new TextField("title", post.getTitle(), Field.Store.YES));
        document.add(new TextField("publisherId", post.getPublisherId(), Field.Store.YES));
        document.add(new TextField("body", post.getBody(), Field.Store.YES));
        document.add(new SortedDocValuesField("title", new BytesRef(post.getTitle())));
        this.inMemoryLuceneIndex.indexDocument(document);
    }

    public List<Document> searchTerm(String term) {
        Query query = new TermQuery(new Term("body", term));
        return inMemoryLuceneIndex.searchIndex(query);
    }
    
}
