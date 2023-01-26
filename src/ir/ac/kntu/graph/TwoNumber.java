package ir.ac.kntu.graph;

public class TwoNumber {
    private int first;
    private int second;
    
    public TwoNumber( int first, int second ) {
        setFirst(first);
        setSecond(second);
    }
    
    public TwoNumber( int first, int second, int noVertices ) {
        if (first <= 0) {
            throw new IllegalArgumentException(String.format("first number(%d) should be > 0", first));
        }
        if (first > noVertices) {
            throw new IllegalArgumentException(String.format("first number(%d) should be <= %d", first, noVertices));
        }
        if (second <= 0) {
            throw new IllegalArgumentException(String.format("second number(%d) should be > 0", second));
        }
        if (second > noVertices) {
            throw new IllegalArgumentException(String.format("second number(%d) should be <= %d", second, noVertices));
        }
        setFirst(first);
        setSecond(second);
    }
    
    public int getFirst() {
        return first;
    }
    
    public void setFirst( int first ) {
        this.first = first;
    }
    
    public int getSecond() {
        return second;
    }
    
    public void setSecond( int second ) {
        this.second = second;
    }
}
