import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.stack.Stack;

/**
 * JUnit test fixture for {@code Stack<String>}'s constructor and kernel
 * methods.
 *
 * @author Put your name here
 *
 */
public abstract class StackTest {

    /**
     * Invokes the appropriate {@code Stack} constructor for the implementation
     * under test and returns the result.
     *
     * @return the new stack
     * @ensures constructorTest = <>
     */
    protected abstract Stack<String> constructorTest();

    /**
     * Invokes the appropriate {@code Stack} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new stack
     * @ensures constructorRef = <>
     */
    protected abstract Stack<String> constructorRef();

    /**
     *
     * Creates and returns a {@code Stack<String>} of the implementation under
     * test type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsTest = [entries in args]
     */
    private Stack<String> createFromArgsTest(String... args) {
        Stack<String> stack = this.constructorTest();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    /**
     *
     * Creates and returns a {@code Stack<String>} of the reference
     * implementation type with the given entries.
     *
     * @param args
     *            the entries for the stack
     * @return the constructed stack
     * @ensures createFromArgsRef = [entries in args]
     */
    private Stack<String> createFromArgsRef(String... args) {
        Stack<String> stack = this.constructorRef();
        for (String s : args) {
            stack.push(s);
        }
        stack.flip();
        return stack;
    }

    /**
     * Test No Argument Constructor.
     */
    @Test
    public final void testNoArgumentConstructor() {
        /*
         * Set up variables and call method under test
         */
        Stack<String> s = this.createFromArgsTest();
        Stack<String> sExpected = this.createFromArgsRef();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test push with an empty stack.
     */
    @Test
    public final void testPushEmpty() {
        /*
         * Set up variables and call method under test
         */
        Stack<String> s = this.createFromArgsTest();
        Stack<String> sExpected = this.createFromArgsRef("Hello");
        s.push("Hello");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test push with a non-empty stack.
     */
    @Test
    public final void testPushNonEmpty() {
        /*
         * Set up variables and call method under test
         */
        Stack<String> s = this.createFromArgsTest("World");
        Stack<String> sExpected = this.createFromArgsRef("Hello", "World");
        s.push("Hello");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
    }

    /**
     * Test pop with a non-empty stack.
     */
    @Test
    public final void testPopStandard1() {
        /*
         * Set up variables and call method under test
         */
        Stack<String> s = this.createFromArgsTest("Hello");
        Stack<String> sExpected = this.createFromArgsRef();
        String result = s.pop();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("Hello", result);

    }

    /**
     * Test pop with a non-empty stack.
     */
    @Test
    public final void testPopStandard2() {
        /*
         * Set up variables and call method under test
         */
        Stack<String> s = this.createFromArgsTest("Hello", "World");
        Stack<String> sExpected = this.createFromArgsRef("World");
        String result = s.pop();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("Hello", result);

    }

    /**
     * Test top with a non-empty stack.
     */
    @Test
    public final void testTopStandard1() {
        /*
         * Set up variables and call method under test
         */
        Stack<String> s = this.createFromArgsTest("Hello");
        Stack<String> sExpected = this.createFromArgsRef("Hello");
        String result = s.top();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("Hello", result);

    }

    /**
     * Test top with a non-empty stack.
     */
    @Test
    public final void testTopStandard2() {
        /*
         * Set up variables and call method under test
         */
        Stack<String> s = this.createFromArgsTest("Buckeye", "Hello", "Brutus");
        Stack<String> sExpected = this.createFromArgsRef("Buckeye", "Hello", "Brutus");
        String result = s.top();

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("Buckeye", result);

    }

    /**
     * Test top with a non-empty stack.
     */
    @Test
    public final void testReplaceTopStandard1() {
        /*
         * Set up variables and call method under test
         */
        Stack<String> s = this.createFromArgsTest("Buckeye", "Hello", "Brutus");
        Stack<String> sExpected = this.createFromArgsRef("Anthony", "Hello", "Brutus");
        String result = s.replaceTop("Anthony");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("Buckeye", result);

    }

    /**
     * Test top with a non-empty stack.
     */
    @Test
    public final void testReplaceTopStandard2() {
        /*
         * Set up variables and call method under test
         */
        Stack<String> s = this.createFromArgsTest("Buckeye");
        Stack<String> sExpected = this.createFromArgsRef("Anthony");
        String result = s.replaceTop("Anthony");

        /*
         * Assert that values of variables match expectations
         */
        assertEquals(sExpected, s);
        assertEquals("Buckeye", result);

    }

}
