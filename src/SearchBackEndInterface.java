// --== CS400 File Header Information ==--
// Name: Ojas Sethi
// Email: osethi@wisc.edu
// Team: DQ
// TA: Yuye
// Lecturer: Florian Heimerl
// Notes to Grader: None
import java.util.List;
/**
 * This interface class contains methods for the SearchBackEnd engine for the airport application
 * @author Ojas Sethi
 */
public interface SearchBackEndInterface {

    public boolean insertAirport(String name);

    public boolean addConnection(String firstAirport, String secondAirport, int distance);

    public List<String> getShortestRoute(String firstAirport, String secondAirport);

    public int getShortestRouteDistance(String firstAirport, String secondAirport);

    public int getTotalAirportCount();

    public boolean removeAirport(String name);

}