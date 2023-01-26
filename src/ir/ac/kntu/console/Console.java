package ir.ac.kntu.console;

import ir.ac.kntu.graph.Component;
import ir.ac.kntu.graph.Edge;
import ir.ac.kntu.graph.TwoNumber;
import ir.ac.kntu.graph.Vertex;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    private static final Scanner SCANNER = new Scanner(System.in);
    
    public Console() {
    }
    
    public void printNumberOfBeautifulGraphNumbering( long numberOfBeautifulGraphNumbering ) {
        System.out.println(numberOfBeautifulGraphNumbering);
    }
    
    public void closeScanner() {
        SCANNER.close();
    }
    
    public void printEnd() {
        System.out.println("End");
    }
    
    public int getNumberOfTest() {
        return SCANNER.nextInt();
    }
    
    public TwoNumber getTwoNumber( int noVertices ) {
        return new TwoNumber(SCANNER.nextInt(), SCANNER.nextInt(), noVertices);
    }
    
    public int getNumberOfVertices() {
        return SCANNER.nextInt();
    }
    
    public int getNumberOfEdges() {
        return SCANNER.nextInt();
    }
    
    public static Scanner getScanner() {
        return SCANNER;
    }
    
    public void printInvalidInput() {
        System.out.println("invalid input");
    }
    
    public int nextInt() {
        return SCANNER.nextInt();
    }
    
    public void printMulResult( long mulResult ) {
        System.out.println("mulResult = " + mulResult);
    }
    
    public void printInvalidInput( String message ) {
        System.out.println(message);
    }
    
    private void printComponents( ArrayList<Component> components ) {
        for (Component component : components) {
            System.out.println(component);
        }
    }
    
    private void printAdjacencyVertices( ArrayList<Vertex> vertices ) {
        for (Vertex vertex : vertices) {
            System.out.println(vertex + ": " + vertex.adjacentVerticesToString());
        }
    }
    
    private void printEdges( ArrayList<Edge> edges ) {
        System.out.println("numberOfEdges = " + edges.size());
        System.out.println("-----edges : ");
        for (Edge edge : edges) {
            System.out.println(edge);
        }
    }
    
    private void printVertices( ArrayList<Vertex> vertices ) {
        System.out.println("numberOfVertices = " + vertices.size());
        System.out.println("-----vertices : ");
        for (Vertex vertex : vertices) {
            System.out.println(vertex);
        }
    }
}
