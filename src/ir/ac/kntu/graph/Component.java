package ir.ac.kntu.graph;

import java.util.ArrayList;

public class Component {
    private ArrayList<Vertex> vertices;
    
    public Component() {
        setVertices(new ArrayList<>());
    }
    
    public Component( ArrayList<Vertex> componentVertices ) {
        this.vertices = componentVertices;
    }
    
    public int computeCoefficient() {
        int noVertices = vertices.size();
        int noZeros = 0;
        for (Vertex vertex : vertices) {
            if (vertex.getTag() == 0) {
                noZeros++;
            }
        }
        return (int) (Math.pow(2, noZeros) + Math.pow(2, noVertices - noZeros));
    }
    
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
    
    public void setVertices( ArrayList<Vertex> vertices ) {
        this.vertices = vertices;
    }
    
    @Override
    public String toString() {
        return "vertices in component are : " + vertices.toString();
    }
}
