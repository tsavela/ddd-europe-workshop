package info.dddeurope.lab.app.queryHandlers;

//import info.dddeurope.lab.app.queries.SearchPostByTextQuery;
//import info.dddeurope.lab.app.views.PostsIndex;
//import lombok.AllArgsConstructor;
//import lombok.Data;
import org.apache.lucene.document.Document;
import java.util.List;

//@Data
//@AllArgsConstructor
public class SearchPostByTextQueryHandler {

    PostsIndex index;

    public List<Document> handle(SearchPostByTextQuery query) throws Exception {
        return this.index.searchTerm(query.getSearchTerm());
    }
}