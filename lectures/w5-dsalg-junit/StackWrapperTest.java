import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class StackWrapperTest {
    @Test
    public void testPeek() {
        StackWrapper<String> stack = new StackWrapper<String>();
        stack.push("foo");
        assertThat(stack.pop(), is("foo"));
    }

    @Test
    public void testTwoItemOrder() {
        StackWrapper<String> stack = new StackWrapper<String>();
        stack.push("foo");
        stack.push("baz");
        assertThat(stack.size(), is(2));

        List<String> actual = new ArrayList<String>();
        actual.add(stack.pop());
        actual.add(stack.pop());

        List<String> expected = Arrays.asList("bar", "foo");
        assertThat(actual, is(expected));
    }
}
