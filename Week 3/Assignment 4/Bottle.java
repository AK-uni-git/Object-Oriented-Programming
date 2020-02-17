public class Bottle {

    private String name;
    private String manufacturer;
    private double total_energy;
    private double volume;
    private double price;

    public Bottle(){
        this.name = "Pepsi Max";
        this.manufacturer = "Pepsi";
        this.total_energy =  0.3;
        this.volume =  0.5;
        this.price =  1.80;
    }

    public Bottle(String name, String manuf, float totE){

    }

    public String getName() {
        return this.name;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public double getEnergy() {
        return this.total_energy;
    }

    public double getVolume() {
        return this.volume;
    }

    public double getPrice() {
        return this.price;
    }
}