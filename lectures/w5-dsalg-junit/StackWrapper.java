import java.util.Stack;

public class StackWrapper<E> extends Stack<E> {
    public boolean empty() {
        return super.empty();
    }

    public E push(E item) {
        return super.push(item);
    }

    public E peek() {
        return super.peek();
    }

    public E pop() {
        return super.pop();
    }

    public int search(Object o) {
        return super.search(o);
    }
}
