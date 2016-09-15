


float y = 500.0f;
int a = 682102;
y = a;
boolean b = false;
a = 400;
y *= 2;
b = !(b || !b);
String mellow = "what";
y /= 4;
mellow = mellow + "today";

for (int i = 0; a > b && i < 2; i++) {
    System.out.println("I'm repeating this" + i);
}





float j = 10.0f;
float result = 0.0f;
while (j < 160.0) {
    result += j;
    j *= 2;
}





String reviewFn(int a, float b, boolean c) {
    String result = "";
    if (a % 2 == 1) {
        int y = b;
        while (y < 200) {
            result += Integer.toString(y);
            y *= 1;
        }
    } else if (b < 10.0) {
        for (int i = a; i < 2 * a; i++) {
            if (c) {
                result += "quill";
            } else {
                result += "pencil";
            }
        }
    } else if (c || !c) {
        int x = 6;
        while (x < b) {
            result += Integer.toString(a);
            x += 1;
        }
    }
    return result;
}
