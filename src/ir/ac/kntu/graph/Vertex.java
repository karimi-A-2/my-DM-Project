package ir.ac.kntu.graph;

import java.util.ArrayList;

public class Vertex {
    private int index;
    private ArrayList<Vertex> adjacentVertices;
    private int tag = 3;
    
    public Vertex( int index ) {
        setIndex(index);
        setAdjacentVertices(new ArrayList<>());
    }
    
    public void addVertexToAdjacency( Vertex vertex ) {
        adjacentVertices.add(vertex);
    }
    
    public void setTag( int tag ) {
        if (tag <= 2 && tag >= 0) {
            this.tag = tag;
        } else {
            throw new IllegalArgumentException("situation " + tag + "out of bound");
        }
    }
    
    public int getTag() {
        return tag;
    }
    
    public int getIndex() {
        return index;
    }
    
    public void setIndex( int index ) {
        this.index = index;
    }
    
    public ArrayList<Vertex> getAdjacentVertices() {
        return adjacentVertices;
    }
    
    public void setAdjacentVertices( ArrayList<Vertex> adjacentVertices ) {
        this.adjacentVertices = adjacentVertices;
    }
    
    public String adjacentVerticesToString() {
        return adjacentVertices.toString();
    }
    
    @Override
    public String toString() {
        return String.format("<(%d):%d>", index, tag);
    }
    
}
