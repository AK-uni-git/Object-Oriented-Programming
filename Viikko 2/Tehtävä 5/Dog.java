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
        System.out.println("Hey, my name is " + this.name);
    }

    public void speak(Scanner reader) {
        System.out.print("What does a dog say: ");
        String line_in = reader.nextLine();
        Scanner input = new Scanner(line_in.trim());
		while (input.hasNext() && input.hasNextLine()) {
			if (input.hasNextBoolean()) {
				System.out.println("Such boolean: " + input.nextBoolean());
			} else if (input.hasNextInt()) {
				System.out.println("Such integer: " + input.nextInt());
			} else {
				System.out.println(input.next());
			}
		}
    
    }
}