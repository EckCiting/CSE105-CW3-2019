public class Data {
    private String countryName;
    private int animalNumber;

    public String getCountryName() {
        return this.countryName;
    }

    public int getAnimalNumber() {
        return this.animalNumber;
    }

    public Data(String countryName, int animalNumber) {
        this.countryName = countryName;
        this.animalNumber = animalNumber;
    }

    /*@Override
    public String toString() {
        return this.CountryName + " " + this.AnimalNumber;
    }*/
}