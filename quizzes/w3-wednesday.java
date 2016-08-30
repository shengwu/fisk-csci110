String zoe() {
    return "zoe";
}

String functionA() {
    String s = "starts";
    if (!s.equals("ends")) {
        s += "with";
        if (s.length() < 10) {
            s += "not";
        } else {
            s += "done";
        }
    } else {
        s += "phew";
    }
    return s;
}

boolean functionB(float f) {
    if (f > 2.0) {
        return false || true;
    } else if (f > 4.0) {
        return false && true;
    } else if (f > 6.0) {
        return true && true;
    }
    return false && false;
}

int functionC(boolean b) {
    int start = 2;
    int end = 5;
    int result = 1;
    while (start <= end) {
        if (b) {
            result += start;
        } else {
            result *= start;
        }
        start += 1;
    }
    return result;
}

boolean functionD(int a, int b) {
    boolean result1 = false;
    boolean result2 = true;
    if (a + b < 10) {
        result1 = false;
    }
    if (a * b > 60) {
        result2 = false;
    }
    if (a / b == 2) {
        result1 = true;
    }
    if (a % b == 1) {
        result2 = true;
    }
    if (a - b != 3) {
        result1 = false;
    }
    return result1 && result2;
}

String functionE(int end) {
    int a = 1;
    int b = 1;
    StringBuilder builder = new StringBuilder();
    while (a <= end) {
        while (b <= end) {
            builder.append((a + b) + "\t");
            b += 1;
        }
        builder.append("\n");
        a += 1;
        b = 1;
    }
    return builder.toString();
}

