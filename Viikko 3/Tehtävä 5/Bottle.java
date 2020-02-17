public class Bottle {

    private String name;
    private String manufacturer;
    private String total_energy;
    private String volume;
    private float price;

    public Bottle(){
        this.name = "Pepsi Max";
        this.manufacturer = "Pepsi";
        this.total_energy =  "0.3";
        this.volume =  "0.5";
        this.price =  1.80f;
    }

	Bottle(String name, String manufacturer, String total_energy, String volume, float prise) {
		this.name = name;
		this.manufacturer = manufacturer;
		this.total_energy = total_energy;
		this.volume = volume;
		this.price = prise;
	}

    public String getName() {
        return this.name;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public String getEnergy() {
        return this.total_energy;
    }

    public String getVolume() {
        return this.volume;
    }

    public float getPrice() {
        return this.price;
    }
}