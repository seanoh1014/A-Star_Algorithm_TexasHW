import java.util.*;

public class A_StarAlgorithm {

    /*
     * Used to count the number of vertices polled from the 
     * priority queue. Please increment pollCount whenever 
     * you poll the priority queue.
     */
    public static int pollCount = 0;


    /*
     * Complete the computePath method. Leverage your code from the
     * previous assignment.
     */
    public static void computePath(Vertex start, Vertex end) {
        PriorityQueue<Vertex> queue = new PriorityQueue<>();

        start.setDistance(0);
        queue.add(start);

        while(!queue.isEmpty()) {
            Vertex current = queue.poll();
            pollCount++;

            if (current == end) {
                break;
            }

            for (Edge edge : current.getEdgeList()) {
                Vertex target = edge.getTargetVertex();
                double distance = current.getDistance() + edge.getWeight();

                if (target.getDistance() > distance) {
                    target.setDistance(distance);
                    target.setPrevious(current);
                    target.setEnd(end);
                    // if (queue.contains(target)) {
                    //     queue.remove(target);
                    // }
                    queue.add(target);
                }
            }
        }
    }

    /**
     * Given a vertex, return a List of vertices that make up the shortest
     * path by getting each vertex's previous vertex. Make sure the list
     * returned is ordered from the starting vertex to the given vertex.
     */
    public static List<Vertex> getPath(Vertex current) {
       List<Vertex> list = new ArrayList<>();
        
        while (current != null) {
            list.add(current);

            current = current.getPrevious();
        }

        Collections.reverse(list);

        return list;
    }
}
