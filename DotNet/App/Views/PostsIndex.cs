using System.Collections.Generic;
using App.Utils.LuceneIndex;
using Lucene.Net.Analysis.Standard;
using Lucene.Net.Documents;
using Lucene.Net.Index;
using Lucene.Net.Search;
using Lucene.Net.Store;
using Lucene.Net.Util;

namespace App.Views
{
    public class PostsIndex
    {
        readonly InMemoryLuceneIndex _inMemoryLuceneIndex;

        public PostsIndex()
        {
            _inMemoryLuceneIndex = new InMemoryLuceneIndex(new RAMDirectory(), new StandardAnalyzer(LuceneVersion.LUCENE_48));
        }

        public void IndexPost(string postId, string title, string body, string publisherId)
        {
            var document = new Document
            {
                new TextField("id", postId, Field.Store.YES),
                new TextField("title", title, Field.Store.YES),
                new TextField("publisherId", publisherId, Field.Store.YES),
                new TextField("body", body, Field.Store.YES),
                new SortedDocValuesField("title", new BytesRef(title))
            };
            _inMemoryLuceneIndex.IndexDocument(document);
        }

        public List<Document> SearchTerm(string term)
        {
            Query query = new TermQuery(new Term("body", term));
            return _inMemoryLuceneIndex.SearchIndex(query);
        }
    }
}