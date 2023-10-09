import java.util.ArrayList;
import java.util.List;

public class Building implements Housing{
     private List<Housing> units;

    public Building() {
        this.units = new ArrayList<>();
    }

    public void addUnit(Housing unit) {
        this.units.add(unit);
    }

    public void removeUnit(Housing unit) {
        this.units.remove(unit);
    }

    @Override
    public void build() {
        System.out.println("Building a building.");
        for (Housing unit : units) {
            unit.build();
        }
    }
}
