using System.Collections.Generic;
using App.Queries;
using App.Views;
using Lucene.Net.Documents;

namespace App.QueryHandlers
{
    public class SearchPostByTextQueryHandler
    {
        readonly PostsIndex _index;

        public SearchPostByTextQueryHandler(PostsIndex index)
        {
            _index = index;
        }

        public List<Document> Handle(SearchPostByTextQuery query)
        {
            return _index.SearchTerm(query.SearchTerm);
        }
    }
}