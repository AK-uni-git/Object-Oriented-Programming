import java.util.ArrayList;

public class Car {

    private ArrayList<CarPart> parts = new ArrayList<CarPart>();

    public Car() {
        parts.add(new Body() );
        parts.add(new Chassis() );
        parts.add(new Engine() );
        for (int i = 0; i < 4; i++) {
            parts.add(new Wheel() );
        }
    }

    public void print() {
        ArrayList<String> countedParts = new ArrayList<String>();
        System.out.println("Car parts:");
        CarPart prev = null;
        int count = 1;
        for (CarPart part : parts) {
            if (prev == null) {
                prev = part;
                continue;
            }
            if (part.getClass().equals(prev.getClass() ) ) {
                count++;
            } else if (count > 1) {
                countedParts.add("\t" + count + " " + prev.getName());
                count = 1;
            } else {
                countedParts.add("\t" + prev.getName() );
            }
            prev = part;
        }
        if (count > 1) {
            countedParts.add("\t" + count + " " + prev.getName());
            count = 1;
        } else {
            countedParts.add("\t" + prev.getName() );
        }
        for (String part : countedParts) {
            System.out.println(part);
        }
    }


    abstract class CarPart {
        protected String name = "Car part";

        protected String getName() {
            return this.name;
        }
    }

    public class Body extends CarPart {
        public Body() {
            System.out.println("Manufacturing: Body");
            name = "Body";
        }
    }

    public class Chassis extends CarPart {
        public Chassis() {
            System.out.println("Manufacturing: Chassis");
            name = "Chassis";
        }
    }

    public class Engine extends CarPart {
        public Engine() {
            System.out.println("Manufacturing: Engine");
            name = "Engine";
        }
    }
    
    public class Wheel extends CarPart {
        public Wheel() {
            System.out.println("Manufacturing: Wheel");
            name = "Wheel";
        }
    }
}


