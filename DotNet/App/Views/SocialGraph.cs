using System.Collections.Generic;
using QuickGraph;
using QuickGraph.Algorithms;

namespace App.Views
{
    public class SocialGraph
    {
        readonly BidirectionalGraph<string, Edge<string>> _graph;

        public SocialGraph()
        {
            _graph = new BidirectionalGraph<string, Edge<string>>();
        }

        public void AddPerson(string id)
        {
            _graph.AddVertex(id);
        }

        public void CreateFriendship(string personIdA, string personIdB)
        {
            _graph.AddEdge(new Edge<string>(personIdA, personIdB));
            _graph.AddEdge(new Edge<string>(personIdB, personIdA));
        }

        public void BreakFriendship(string personIdA, string personIdB)
        {
            _graph.RemoveEdge(new Edge<string>(personIdA, personIdB));
            _graph.RemoveEdge(new Edge<string>(personIdB, personIdA));
        }

        public IEnumerable<Edge<string>> GetConnections(string userA, string userB)
        {
            var paths = _graph.ShortestPathsDijkstra(edge => 1, userA);
            paths(userB, out var result);
            return result;
        }
    }
}