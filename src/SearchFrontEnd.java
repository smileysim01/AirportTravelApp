import java.util.Scanner;
// --== CS400 File Header Information ==--
// Name: Ningyuan Sun
// Email: nsun28@wisc.edu
// Team: DQ
// TA: Yuye
// Lecturer: Florian Heimerl
// Notes to Grader: None
interface FrontendInterface{
    public void run(SearchBackEnd engine);
}

public class SearchFrontEnd implements FrontendInterface{

    @Override
    public void run(SearchBackEnd engine){
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        while(exit == false){
            System.out.println("Greetings, Welcome to AirportQuickestPath. "
                    + "(Please use airport initials): ");
            System.out.println("1. Get shoetest route between 2 airports");
            System.out.println("2. List of all airport paths.");
            System.out.println("3. Add an airport path \n 4. Exit");
            String input = scanner.nextLine().toLowerCase();
            switch(input){
                case "1":
                    sroute(engine, scanner);
                    break;
                case "2":
                    list(engine);
                    break;
                case "3":
                    add(engine, scanner);
                    break;
                case "4":
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid input.");

            }
        }
    }
    public void sroute(SearchBackEnd engine, Scanner scanner){
        System.out.println("Please input your Starting Airport:");
        String init = scanner.nextLine();
        System.out.println("Please input your Destination Airport:");
        String dst = scanner.nextLine();
        System.out.println("Cost: "+engine.getShortestRoute(init, dst));
    }
    public void list(SearchBackEnd engine){
        int c = engine.getTotalAirportCount();
        System.out.println("The list of all Airports: "+ c);
    }
    public void add(SearchBackEnd engine, Scanner scanner){
        System.out.println("Please enter Airport:");
        String n = scanner.nextLine();
        engine.insertAirport(n);
    }

}
