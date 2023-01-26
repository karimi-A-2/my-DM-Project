package ir.ac.kntu.graph;

import java.util.ArrayList;

public class GraphInfo {
    private int noVertices;
    private int noEdges;
    private ArrayList<TwoNumber> edgesList;
    
    public GraphInfo( int noVertices, int noEdges ) {
        checkValidation(noVertices, noEdges);
        setNoVertices(noVertices);
        setNoEdges(noEdges);
        setEdgesList(new ArrayList<>(noEdges));
    }
    
    private void checkValidation( int numberOfVertices, int numberOfEdges ) {
        if (numberOfEdges > ((numberOfVertices * (numberOfVertices - 1)) / 2)) {
            throw new IllegalArgumentException(String.format("number of edges(%d) should be <= Max Number Of Edges(%d)", numberOfEdges, (numberOfVertices * (numberOfVertices - 1)) / 2));
        }
    }
    
    public void addEdge( TwoNumber twoNumber ) {
        getEdgesList().add(twoNumber);
    }
    
    public int getNoVertices() {
        return noVertices;
    }
    
    public void setNoVertices( int noVertices ) {
        this.noVertices = noVertices;
    }
    
    public int getNoEdges() {
        return noEdges;
    }
    
    public void setNoEdges( int noEdges ) {
        this.noEdges = noEdges;
    }
    
    public ArrayList<TwoNumber> getEdgesList() {
        return edgesList;
    }
    
    public void setEdgesList( ArrayList<TwoNumber> edgesList ) {
        this.edgesList = edgesList;
    }
}
