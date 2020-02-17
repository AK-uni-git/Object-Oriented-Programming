

class Dog {
    private String name;

    public Dog(String name_in) {
        this.name = name_in;
        System.out.println("Hey, my name is " + this.name + "!");
    }

    public void speak(String line) {
        System.out.println(line);
    }
}