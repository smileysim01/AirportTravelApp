public class data implements datainterface {
    private String weather;
    private String airports;
    private double time;
    private double weight;

    /**
     * This is the constructor that sets the variables
     *
     * @param time  - The flight time
     * @param airports - The name of destination or name of the airports
     * @param weather - The weather that may affect the time
     *@param weight- the weight of the flight
     */
    public data(String weather, String airports, double time)
    {
        this.weather = weather;
        this.airports = airports;
        this.time = time;
    }
    /**
     * @return - the weather
     */
    @Override
    public String getweather() {
        return weather;
    }
    /**
     * @return - the name of airports
     */
    @Override
    public String getairports() {
        return airports;
    }
    /**
     * @return - the flight time
     */
    @Override
    public double gettime() {
        return time;
    }
    /**
     * @return - the combined weight
     */
    @Override
    public double getWeight()
    {
//depends on weather, calculate weight
    }

}