


void warmup(int x) {
    if (x < 0) {
        System.out.println("finally");
        return;
    }
    if (x % 2 == 0) {
        System.out.println("even");
    } else {
        System.out.println("odd");
    }
    warmup(x - 3);
}



void someFunction(double d) {
    if (d < 2) {
        System.out.println("whew");
        return;
    }
    System.out.println(d);
    someFunction(d - 0.5);
}

class Roadrunner {
    private int speed;

    public RoadRunner(int speed) {
        this.speed = speed;
    }

    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }

    public int getSpeed() {
        return speed;
    }
}

void f(Roadrunner r) {
    r = new Roadrunner(50);
    r.setSpeed(20);
}
