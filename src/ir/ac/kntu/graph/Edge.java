package ir.ac.kntu.graph;

public class Edge {
    private Vertex v1;
    private Vertex v2;
    
    
    public Edge( Vertex v1, Vertex v2 ) {
        this.v1 = v1;
        this.v2 = v2;
    }
    
    public Vertex getV1() {
        return v1;
    }
    
    public void setV1( Vertex v1 ) {
        this.v1 = v1;
    }
    
    public Vertex getV2() {
        return v2;
    }
    
    public void setV2( Vertex v2 ) {
        v2 = v2;
    }
    
    
    @Override
    public String toString() {
        return String.format("(%s, %s)", v1, v2);
    }
}
