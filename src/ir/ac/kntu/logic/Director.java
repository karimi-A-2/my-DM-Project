package ir.ac.kntu.logic;

import ir.ac.kntu.console.Console;
import ir.ac.kntu.graph.Graph;
import ir.ac.kntu.graph.GraphInfo;
import ir.ac.kntu.graph.TwoNumber;

import java.util.ArrayList;

public class Director {
    private Console console;
    private ArrayList<GraphInfo> graphInfos;
    private ArrayList<Graph> graphs;
    
    public Director() {
        console = new Console();
        setGraphInfos(new ArrayList<>());
        setGraphs(new ArrayList<>());
    }
    
    public void start() {
        int noTests = getInfos();
        checkEquality(graphInfos.size(), noTests, "graphInfos.size() != noTests");
        
        createGraphs();
        checkEquality(getGraphs().size(), noTests, "graphs.size() != noTests");
        
        computeAndPrintNumberOfBeautifulGraphNumbering();
        console.printEnd();
        console.closeScanner();
    }
    
    private void computeAndPrintNumberOfBeautifulGraphNumbering() {
        for (Graph graph : getGraphs()) {
            console.printNumberOfBeautifulGraphNumbering(graph.computeNumberOfBeautifulGraphNumbering());
        }
    }
    
    private void checkEquality( int first, int second, String exceptionMessage ) {
        if (first != second) {
            throw new RuntimeException(exceptionMessage);
        }
    }
    
    private void createGraphs() {
        for (GraphInfo graphInfo : graphInfos) {
            getGraphs().add(new Graph(graphInfo));
        }
    }
    
    private int getInfos() {
        int noTests = console.getNumberOfTest();
        for (int i = 0; i < noTests; i++) {
            GraphInfo graphInfo = getGraphInfo();
            addEdgesToGraphInfo(graphInfo);
            graphInfos.add(graphInfo);
        }
        return noTests;
    }
    
    private void addEdgesToGraphInfo( GraphInfo graphInfo ) {
        for (int j = 0; j < graphInfo.getNoEdges(); j++) {
            TwoNumber twoNumber = console.getTwoNumber(graphInfo.getNoVertices());
            graphInfo.addEdge(twoNumber);
        }
    }
    
    private GraphInfo getGraphInfo() {
        int numberOfVertices = console.getNumberOfVertices();
        int numberOfEdges = console.getNumberOfEdges();
        GraphInfo graphInfo = new GraphInfo(numberOfVertices, numberOfEdges);
        return graphInfo;
    }
    
    public ArrayList<GraphInfo> getGraphInfos() {
        return graphInfos;
    }
    
    public void setGraphInfos( ArrayList<GraphInfo> graphInfos ) {
        this.graphInfos = graphInfos;
    }
    
    public ArrayList<Graph> getGraphs() {
        return graphs;
    }
    
    public void setGraphs( ArrayList<Graph> graphs ) {
        this.graphs = graphs;
    }
}
