package info.dddeurope.lab.Repositories;

import org.jgrapht.*;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;

public class SocialGraph {

    Graph<String, DefaultEdge> graph; 

    public SocialGraph() {
        this.graph = new DefaultDirectedGraph<>(DefaultEdge.class);
    }
    
    public void addPerson(String id) {
        this.graph.addVertex(id);
    }

    public void createFriendship(String personIdA, String personIdB) {
        this.graph.addEdge(personIdA, personIdB);
        this.graph.addEdge(personIdB, personIdA);
    }

    public void breakFriendship(String personIdA, String personIdB) {
        this.graph.removeEdge(personIdA, personIdB);
        this.graph.removeEdge(personIdB, personIdA);
    }

    public GraphPath<String,DefaultEdge> getConnections(String userA, String userB) {
        DijkstraShortestPath<String, DefaultEdge> dijkstraAlg =
            new DijkstraShortestPath<>(this.graph);
        SingleSourcePaths<String, DefaultEdge> iPaths = dijkstraAlg.getPaths(userA);
        return iPaths.getPath(userB);
    }

}