import org.junit.jupiter.api.Test;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.platform.console.ConsoleLauncher;
import java.lang.invoke.MethodHandles;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class AirportTravelTests{

    //Data Wrangler Tests methods

    //Back End Developer Tests

        private SearchBackEnd engine;

        /**
         * This method initializes the backend engine before each test.
         */
        @BeforeEach
        public void createGraph() {
            engine = new SearchBackEnd();
        }
        /**
         * This test method checks the correctness of the checkAirportCode method
         */
        @Test
        public void testCheckAirportCode() {
            assertTrue(!engine.insertAirport("NewYork"));
            assertTrue(!engine.addConnection("ATL", "Chicago", 10));
            assertTrue(engine.insertAirport("ATL"));
    }

        /**
         * This test method checks the correctness of the insertAirport method
         */
        @Test
        public void testInsertAirport() {
        assertTrue(engine.insertAirport("ORD"));
        assertTrue(!engine.insertAirport("ORD"));
        assertTrue(engine.insertAirport("msn"));
    }

        /**
         * This test method checks the correctness of the addConnection method
         */
        @Test
        public void testAddConnection() {
        engine.insertAirport("ORD");
        engine.insertAirport("MSN");
        engine.insertAirport("JFK");
        assertTrue(engine.addConnection("ORD", "JFK", 1000));
        try{
            engine.addConnection("ORD", "SFO", 500);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

        /**
         * This test method checks the correctness of the getShortestRoute method
         */
        @Test
        public void testGetShortestRoute() {
        engine.insertAirport("ORD");
        engine.insertAirport("MSN");
        engine.insertAirport("JFK");
        engine.addConnection("ORD", "MSN", 200);
        engine.addConnection("MSN", "JFK", 1000);
        List<String> expectedRoute = new ArrayList<String>();
        expectedRoute.add("ORD");
        expectedRoute.add("MSN");
        expectedRoute.add("JFK");
        assertTrue(engine.getShortestRoute("ORD", "JFK").equals(expectedRoute));

    }

        /**
         * This test method checks the correctness of the getShortestRouteDistance method
         */
        @Test
        public void testGetShortestRouteDistance() {
        engine.insertAirport("ORD");
        engine.insertAirport("MSN");
        engine.insertAirport("JFK");
        engine.addConnection("ORD", "MSN", 200);
        engine.addConnection("MSN", "JFK", 1000);
        assertTrue(engine.getShortestRouteDistance("ORD", "JFK") == 1200);
    }

        /**
         * This test method checks the correctness of the getTotalAirportCount method
         */
        @Test
        public void testGetTotalAiportCount() {
        engine.insertAirport("ORD");
        engine.insertAirport("MSN");
        engine.insertAirport("JFK");
        assertTrue(engine.getTotalAirportCount() == 3);
    }

        /**
         * This test method checks the correctness of the removeAirport method
         */
        @Test
        public void testRemoveAirport() {
        engine.insertAirport("ORD");
        engine.insertAirport("MSN");
        engine.insertAirport("JFK");
        assertTrue(engine.removeAirport("ORD"));
        assertTrue(engine.getTotalAirportCount() == 2);
    }

    // Front End Developer Tests

    // Integration Manager Tests
    /**
     * role integration manager
     *
     * @author Simran
     *
     */
    //Test1 for role integration manager
    //Test to check if exception works properly for Data Wrangler
    @Test
    public void integrationmanager_testDataWrangler(){

        int flag =1;
        dataload load = new dataload();
        try{
            List<data> airportlist = load.loadFile("./data/not_a_dataset.csv");
        }
        catch(FileNotFoundException e)
        {
            flag = 0;
        }
        assertEquals(0,flag);

    }

    /**
     * role integration manager
     *
     * @author Simran
     *
     */
    //Test2 for role integration manager
    //To check the insertAirport
    @Test
    public void integrationmanager_testBackEnd() {
        assertTrue(engine.insertAirport("LAX"));
        assertTrue(engine.insertAirport("ATL"));
        assertTrue(!engine.insertAirport("LAX"));
    }

    /**
     * role integration manager
     *
     * @author Simran
     *
     */
    //Test3 for role integration manager
    //to check the front end developer's file
    @Test
    public void integrationmanager_testFrontEnd(){
        SearchFrontEnd frontEngine = new SearchFrontEnd();
        SearchBackEnd backEngine = new SearchBackEnd();
        try {
            frontEngine.run(backEngine);
            assertTrue(true); // Passes if the run method works
        } catch (Exception e) {
            assertTrue(false); // Fails otherwise if any exception is caught
        }
    }

    public static void main(String[] args) {
        String className = MethodHandles.lookup().lookupClass().getName();
        String classPath = System.getProperty("java.class.path").replace(" ", "\\ ");
        String[] arguments = new String[] {
                "-cp",
                classPath,
                "--include-classname=.*",
                "--select-class=" + className };
        ConsoleLauncher.main(arguments);
    }
}
