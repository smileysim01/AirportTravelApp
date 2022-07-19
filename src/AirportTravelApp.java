public class AirportTravelApp {

    public static void main(String[] args) {
        System.out.println("Welcome to AirportTravel");
        dataload fileGen = new dataload();
        fileGen.loadFile();
        System.out.println("Generating files");
        SearchBackEnd engine = new SearchBackEnd();
        for(data airport : fileGen) engine.insertAirport(airport);
        SearchFrontEnd ui = new SearchFrontEnd();
        ui.run(engine);
    }

}
