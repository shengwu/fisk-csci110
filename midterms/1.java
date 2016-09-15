

// question 2

int i = 12;
while (i < 35) {
    i++;
    System.out.println("foo");
}

// question 3

int accumulator = 0;
System.out.println("Let's get started!");
int n = 0;
while (n < 6) {
    n += 2;
    accumulator += Integer.toString(n) + ",";
}
System.out.println(accumulator);



// question 4

String makeEmail(String first, String last, String domain) {
    result = first + "." + last + "@" + domain + ".com";
    return result;
}
System.out.println("Email list:");
System.out.println(makeEmail("jay", "leno", "cars"));
System.out.println(makeEmail("leslie", "knope", "parks"));
System.out.println(makeEmail("sandor", "clegane", "pacifism"));


// question 5

float h = 6.0f;
boolean j = false;
String k = "bar";
int l = 900;
while (l != 6080) {
    k += "baz";
    h -= 2.0f;
    j = !j;
    l += 1;
}


// question 6, 7

String mystery(String a, float b, boolean c) {
    String result = "";
    while (c) {
        while (result.length() < 12) {
            result += a;
            result += Boolean.toString(c);
        }
        return result;
    }
    if (b > 10) {
        float y = b;
        while (y < 4 * b) {
            result += "foobar";
            y += a.length();
        }
    }
    return result;
}


