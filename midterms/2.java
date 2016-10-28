
// code ordering

void greet() {

____    System.out.println("ok");

}


public static void main(String[] args) {

____    System.out.println("goodbye");

             ____       ____   ____
        for (int i = 0; i < 1; i++) {
____        System.out.println(25);
        }

____    greet();

____    System.out.println("done");

}




// recusion function reading

void mystery(int n) {
    if (n <= 1) {
        System.out.println("newt");
    }
    System.out.println("tiger");
    mystery(n / 2);
    System.out.println(n);
}

mystery(5);



// object reading

class Tiger {
    private double hunger;

    public Tiger(double hunger) {
        this.hunger = hunger;
    }

    public double getHunger() {
        return hunger;
    }

    public boolean willEatAntelope() {
        return hunger > 50.0;
    }

    public void eatFood(double food) {
        hunger -= food;
    }
}



Tiger t1 = new Tiger(100.0);
System.out.println(t1.willEatAntelope());
t1.eatFood(50.0);
System.out.println(t1.willEatAntelope());
System.out.println(t1.getHunger());
t1.eatFood(50.0);
System.out.println(t1.getHunger());


// object references function reading 


void nature(Tiger t) {
    t.eatFood(20.0);
}

Tiger nurture(Tiger t) {
    t = new Tiger(10.0);
    return t;
}


Tiger t1 = new Tiger(60.0);
System.out.println(t1.willEatAntelope());
nature(t1);
System.out.println(t1.willEatAntelope());
t1 = nurture(t1);
System.out.println(t1.willEatAntelope());




// fill in class definition


class VCR {
    private double tapePosition;
    private String tapeName;

    /**
     * Constructs a new VCR with the given tapeName. Initializes
     * tapePosition to 0.
     */






    /**
     * Advances tapePosition by 10.
     */




    /**
     * Rewinds tapePosition to 0.
     */


    /**
     * Returns the name of the current tape.
     */





}

