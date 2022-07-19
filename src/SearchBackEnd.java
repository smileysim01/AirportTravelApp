// --== CS400 File Header Information ==--
// Name: Ojas Sethi
// Email: osethi@wisc.edu
// Team: DQ
// TA: Yuye
// Lecturer: Florian Heimerl
// Notes to Grader: None

import java.util.List;

/**
 * This class serves as a backend engine for the airport application. Note that this engine uses the
 * 3 character airport codes given by IATA (consisting of only letters). Find more information at www.iata.org.
 *
 * @author Ojas Sethi
 */
public class SearchBackEnd implements SearchBackEndInterface {
    private CS400Graph<String> airportGraph;

    /**
     * This constructor initializes the airport graph object
     */
    public SearchBackEnd() {
        airportGraph = new CS400Graph<String>(); // Create and instantiate a new CS400Graph object to store the airport graph
    }

    /**
     * This method inserts a vertex of the airport into the airportGraph object
     * @param airport - 3 letter string code for the airport
     * @return true if vertex added successfully; false otherwise
     */
    @Override
    public boolean insertAirport(String airport) {
        if (checkCodeFormat(airport)) {
            // If the format of the airport code is valid, then move ahead
            return airportGraph.insertVertex(airport.toUpperCase());
        } else {
            return false;
        }
    }

    /**
     * This method adds a connection from one airport to the other in the airport graph.
     * @param firstAirport - 3 letter string code for the first airport
     * @param secondAirport - 3 letter string code for the second airport
     * @param distance - The positive integer for the distance between the two airports
     * @return true if the edge (connection) is added successfully; false otherwise
     */
    @Override
    public boolean addConnection(String firstAirport, String secondAirport, int distance) {
        if (checkCodeFormat(firstAirport) && checkCodeFormat(secondAirport) && distance > 0) {
            // If the format of the airport code is valid, then move ahead
            if (firstAirport.equalsIgnoreCase(secondAirport)) {
                return false;
            }
            // Try to add an edge from the first airport to the second
            return airportGraph.insertEdge(firstAirport, secondAirport, distance);
        }
        return false;
    }

    /**
     * This method gets the shortest route from the first airport to the second airport.
     * @param firstAirport - 3 letter string code for the first airport
     * @param secondAirport - 3 letter string code for the second airport
     * @return List object containing the shortest route from the first airport to the second airport
     */
    @Override
    public List<String> getShortestRoute(String firstAirport, String secondAirport) {
        if (checkCodeFormat(firstAirport) && checkCodeFormat(secondAirport)) {
            // If the format of the airport code is valid, then move ahead
            return airportGraph.shortestPath(firstAirport, secondAirport);
        }
        throw new IllegalArgumentException("Error: Incorrect airport codes.");
    }

    /**
     * This method gets the total distance of the shortest route from the first airport to the second airport.
     * @param firstAirport - 3 letter string code for the first airport
     * @param secondAirport - 3 letter string code for the second airport
     * @return int containing the total distance of the shortest route between the two airports
     */
    @Override
    public int getShortestRouteDistance(String firstAirport, String secondAirport) {
        if (checkCodeFormat(firstAirport) && checkCodeFormat(secondAirport)) {
            // If the format of the airport code is valid, then move ahead
            return airportGraph.getPathCost(firstAirport, secondAirport);
        }
        // Throw exception because the airport codes are wrong
        throw new IllegalArgumentException("Error: Incorrect airport codes.");
    }

    /**
     * This method gets the total number of airports in the airport graph object.
     */
    @Override
    public int getTotalAirportCount() {
        if (airportGraph.isEmpty()) {
            return 0; // Return 0 is graph is empty
        }
        return airportGraph.getVertexCount(); // Else get the total number of vertices in the graph
    }

    /**
     * This method removes the specified airport from the graph and also removes all the
     * connected edges to and from this airport.
     * @param name - 3 letter code for the airport to remove
     * @return true if the airport was deleted successfully; false otherwise
     */
    @Override
    public boolean removeAirport(String name) {
        if (checkCodeFormat(name)) {
            // If the format of the airport code is valid, then move ahead
            return airportGraph.removeVertex(name);
        } else {
            // Return false if the code format is incorrect
            return false;
        }
    }

    /**
     * This private helper method checks the formatting of the given airport code
     * @param name - String representation of the airport code
     * @return true if the format is correct; false otherwise
     */
    private boolean checkCodeFormat(String name) {
        if (name == "") { // Check if name is an empty string
            System.out.println("Error: Airport code is empty.");
            return false;
        }
        if (name.length() != 3) { // Check if the length of name is 3
            System.out.println("Error: Invalid length for airport code.");
            return false;
        }

        if (!name.matches("[a-zA-Z]+")) { // Check if name contains only letters
            System.out.println("Error: Invalid characters for airport code.");
            return false;
        }

        return true; // If all conditions pass, then the formatting is correct for the airport code
    }

}