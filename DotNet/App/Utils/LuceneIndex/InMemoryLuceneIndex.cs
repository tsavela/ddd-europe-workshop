using System;
using System.Collections.Generic;
using Lucene.Net.Analysis;
using Lucene.Net.Documents;
using Lucene.Net.Index;
using Lucene.Net.QueryParsers.Classic;
using Lucene.Net.Search;
using Lucene.Net.Store;
using Lucene.Net.Util;

namespace App.Utils.LuceneIndex
{
    public class InMemoryLuceneIndex
    {
        private readonly Directory _memoryIndex;
        private readonly Analyzer _analyzer;

        public InMemoryLuceneIndex(Directory memoryIndex, Analyzer analyzer)
        {
            _memoryIndex = memoryIndex;
            _analyzer = analyzer;
        }

        public void IndexDocument(string title, string body)
        {
            var indexWriterConfig = new IndexWriterConfig(LuceneVersion.LUCENE_48, _analyzer);
            try
            {
                using var writer = new IndexWriter(_memoryIndex, indexWriterConfig);
                var document = new Document
                {
                    new TextField("title", title, Field.Store.YES),
                    new TextField("body", body, Field.Store.YES),
                    new SortedDocValuesField("title", new BytesRef(title))
                };

                writer.AddDocument(document);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
        }

        public void IndexDocument(Document document)
        {
            var indexWriterConfig = new IndexWriterConfig(LuceneVersion.LUCENE_48, _analyzer);
            try
            {
                using var writer = new IndexWriter(_memoryIndex, indexWriterConfig);
                writer.AddDocument(document);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
        }

        public List<Document> SearchIndex(string inField, string queryString)
        {
            try
            {
                var query = new QueryParser(LuceneVersion.LUCENE_48, inField, _analyzer).Parse(queryString);

                var indexReader = DirectoryReader.Open(_memoryIndex);
                var searcher = new IndexSearcher(indexReader);
                var topDocs = searcher.Search(query, 10);
                var documents = new List<Document>();

                foreach (var scoreDoc in topDocs.ScoreDocs)
                {
                    documents.Add(searcher.Doc(scoreDoc.Doc));
                }

                return documents;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }

            return null;
        }

        public void DeleteDocument(Term term)
        {
            try
            {
                var indexWriterConfig = new IndexWriterConfig(LuceneVersion.LUCENE_48, _analyzer);
                using var writer = new IndexWriter(_memoryIndex, indexWriterConfig);
                writer.DeleteDocuments(term);
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }
        }

        public List<Document> SearchIndex(Query query)
        {
            try
            {
                var indexReader = DirectoryReader.Open(_memoryIndex);
                var searcher = new IndexSearcher(indexReader);
                var topDocs = searcher.Search(query, 10);
                var documents = new List<Document>();

                foreach (var scoreDoc in topDocs.ScoreDocs)
                {
                    documents.Add(searcher.Doc(scoreDoc.Doc));
                }

                return documents;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }

            return null;
        }

        public List<Document> SearchIndex(Query query, Sort sort)
        {
            try
            {
                var indexReader = DirectoryReader.Open(_memoryIndex);
                var searcher = new IndexSearcher(indexReader);
                var topDocs = searcher.Search(query, 10, sort);
                var documents = new List<Document>();

                foreach (var scoreDoc in topDocs.ScoreDocs)
                {
                    documents.Add(searcher.Doc(scoreDoc.Doc));
                }

                return documents;
            }
            catch (Exception e)
            {
                Console.WriteLine(e.StackTrace);
            }

            return null;
        }
    }
}