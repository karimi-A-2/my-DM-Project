package ir.ac.kntu.graph;

import ir.ac.kntu.exceptions.NotBeautifulGraphException;

import java.util.ArrayList;

public class Graph {
    private GraphInfo graphInfo;
    private ArrayList<Vertex> vertices;
    private ArrayList<Edge> edges;
    private ArrayList<Component> components;
    
    public Graph( GraphInfo graphInfo ) {
        setVertices(new ArrayList<>());
        setEdges(new ArrayList<>());
        setComponents(new ArrayList<>());
        setGraphInfo(graphInfo);
        creatVertices();
        creatEdgesAndAddAdjacencyVertices();
        createComponents();
    }
    
    public long computeNumberOfBeautifulGraphNumbering() {
        long mulResult = 1;
        try {
            for (Component component : getComponents()) {
                setTagToVertexAndToComponentRecursively((component.getVertices().get(0)), 0);
            }
            for (Component component : getComponents()) {
                mulResult *= component.computeCoefficient();
                mulResult %= 998244353;
            }
        } catch (NotBeautifulGraphException e) {
            mulResult = 0;
        }
        return mulResult;
    }
    
    public void setTagToVertexAndToComponentRecursively( Vertex vertex, int assigningTag ) throws NotBeautifulGraphException {
        int oppositeTag = (assigningTag == 0 ? 1 : 0);
        int neutralTag = 2;
        
        if (vertex.getTag() == oppositeTag) {
            throw new NotBeautifulGraphException();
        }
        if (vertex.getTag() == assigningTag) {
            return;
        }
        if (vertex.getTag() == neutralTag) {
            vertex.setTag(assigningTag);
            for (Vertex adjacentVertex : vertex.getAdjacentVertices()) {
                setTagToVertexAndToComponentRecursively(adjacentVertex, oppositeTag);
            }
            return;
        }
        throw new RuntimeException("should not reach this statement");
    }
    
    private void createComponents() {
        for (Vertex vertex : getVertices()) {
            if (vertex.getTag() == 3) {
                ArrayList<Vertex> componentVertices = new ArrayList<>();
                recognizeVerticesInComponent(componentVertices, vertex);
                Component component = new Component(componentVertices);
                getComponents().add(component);
            }
        }
    }
    
    private void creatEdgesAndAddAdjacencyVertices() {
        for (TwoNumber twoNumber : getGraphInfo().getEdgesList()) {
            Vertex vertex1 = getVertices().get(twoNumber.getFirst() - 1);
            Vertex vertex2 = getVertices().get(twoNumber.getSecond() - 1);
            Edge edge = new Edge(vertex1, vertex2);
            getEdges().add(edge);
            vertex1.addVertexToAdjacency(vertex2);
            vertex2.addVertexToAdjacency(vertex1);
        }
    }
    
    private void creatVertices() {
        for (int i = 1; i <= getGraphInfo().getNoVertices(); i++) {
            getVertices().add(new Vertex(i));
        }
    }
    
    public void recognizeVerticesInComponent( ArrayList<Vertex> vertices, Vertex vertex ) {
        if (vertex.getTag() != 3) {
            return;
        }
        vertices.add(vertex);
        vertex.setTag(2);
        ArrayList<Vertex> adjacentVertices = vertex.getAdjacentVertices();
        for (Vertex adjacentVertex : adjacentVertices) {
            recognizeVerticesInComponent(vertices, adjacentVertex);
        }
    }
    
    public ArrayList<Vertex> getVertices() {
        return vertices;
    }
    
    public void setVertices( ArrayList<Vertex> vertices ) {
        this.vertices = vertices;
    }
    
    public ArrayList<Edge> getEdges() {
        return edges;
    }
    
    public void setEdges( ArrayList<Edge> edges ) {
        this.edges = edges;
    }
    
    public ArrayList<Component> getComponents() {
        return components;
    }
    
    public void setComponents( ArrayList<Component> components ) {
        this.components = components;
    }
    
    public GraphInfo getGraphInfo() {
        return graphInfo;
    }
    
    public void setGraphInfo( GraphInfo graphInfo ) {
        this.graphInfo = graphInfo;
    }
}
