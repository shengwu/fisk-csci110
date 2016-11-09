

boolean isBalanced(String s) {
    HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
    counts.put('(', 0);
    counts.put(')', 0);
    for (int i = 0; i < s.length(); i++) {
        char c = s.getChar(i);
        if (c == ')') {
            if (counts.get(c) <= 0) {
                // There weren't enough opening parentheses before
                // this closing one
                return false;
            }
            counts.put(c, counts.get(c) + 1);
        } else if (c == '(') {
            counts.put(c, counts.get(c) + 1);
        }
    }
    return counts.get('(') == counts.get(')');
}

boolean isBalanced(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
        char c = s.getChar(i);
        if (c == ')') {
            if (count <= 0) {
                // There weren't enough opening parentheses before
                // this closing one
                return false;
            }
            count--;
        } else if (c == '(') {
            count++;
        }
    }
    return count == 0;
}

boolean isBalanced(String s) {
    Stack<Character> parens = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
        char c = s.getChar(i);
        if (c == ')') {
            if (parens.empty()) {
                // There weren't enough opening parentheses before
                // this closing one
                return false;
            }
            parens.pop(c);
        } else if (c == '(') {
            parens.push(c);
        }
    }
    return parens.empty();
}
