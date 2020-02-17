import java.util.Scanner;

class Dog {
    private String name;
    private String says;

    public Dog(Scanner reader) {
        
        System.out.print("Give a name to the dog: ");
        String name_in = reader.nextLine();
        

        if (name_in.trim().isEmpty()) {
            this.name = "Doge";
        } else {
            this.name = name_in;
        }
        this.says = "Much wow!";
        System.out.println("Hey, my name is " + this.name + "!");
    }

    public void speak(Scanner reader) {
        System.out.print("What does a dog say: ");
        String line_in = reader.nextLine();

        while ( (line_in.trim().isEmpty()) ) {
            System.out.println(this.name + ": " + this.says);
            System.out.print("What does a dog say: ");
            line_in = reader.nextLine();
        } 
        this.says = line_in;
        
        System.out.println(this.name + ": " + this.says);
    }
}