import java.util.*;
/*
* Instructions:
* 1. Complete the constructor
* 2. Implement the interface Comparable
* 3. Create getter methods for all instance variables.
* 4. Create setter methods for setPrevious and setDistance. 
* 5. You will also need an addEdge method that will add a 
*    given edge to the edgeList.
*/
public class Vertex implements Comparable<Vertex> {

    private int id;            // Vertex ID which is also it's key in your Map
    private String name;       // Friendly name to identify the location
    private double latitude;   
    private double longitude;
    private List<Edge> edgeList;
    private double distance;  // distance from the starting vertex (source)
    private Vertex previous;  // the previous vertex on the shortest path
    private Vertex end;
    private double distanceToEnd;

    public Vertex(int id, String name, double latitude, double longitude) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.edgeList = new ArrayList<>();
        this.distance = Double.MAX_VALUE;
    }

    public int compareTo(Vertex other) {
        setDistanceToEnd();
        other.setEnd(end);
        other.setDistanceToEnd();

        //return (int)((distance + distanceToEnd) - (other.getDistance() + other.getDistanceToEnd()));
        return Double.compare((distance + distanceToEnd), (other.getDistance() + other.getDistanceToEnd()));
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public void setPrevious(Vertex previous) {
        this.previous = previous;
    }

    public List<Edge> getEdgeList() {
        return edgeList;
    }

    public void addEdge(Edge edge) {
        this.edgeList.add(edge);
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDistanceToEnd() {
        return distanceToEnd;
    }

    public void setDistanceToEnd() {
        distanceToEnd = Main.calculateDistance(latitude, longitude, end.getLatitude(), end.getLongitude());
    }
    
    public void setEnd(Vertex end) {
        this.end = end;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Vertex other = (Vertex) obj;
        if (this.id != other.id || !
            this.name.equals(other.name) || 
            this.edgeList.size() != other.edgeList.size()) {
            return false;
        }
        for (int i = 0; i < edgeList.size(); i++) {
            if(!this.edgeList.get(i).equals(other.edgeList.get(i))) {
                return false;
            }
        }
        return true;
    }
    
    @Override
    public String toString() {
        return id + "(" + name + ")";
    }
}
