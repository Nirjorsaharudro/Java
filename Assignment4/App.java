public class App {
    public static void main(String[] args) {
        Housing apartment1 = new Apartment();
        Housing apartment2 = new Apartment();

        Housing house1 = new House();
        Housing house2 = new House();

        Building building1 = new Building();
        building1.addUnit(apartment1);
        building1.addUnit(house1);

        Building building2 = new Building();
        building2.addUnit(apartment2);
        building2.addUnit(house2);

        Building complex = new Building();
        complex.addUnit(building1);
        complex.addUnit(building2);

        complex.build();
    }
}
