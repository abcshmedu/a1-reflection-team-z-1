package Test;
import Renderer.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Maximilian on 09.04.2017.
 */
public class Test {

    /**
     *
     * @param args
     */
    public static void main(String... args) {
        Test test = new Test();
        test.testDefaultSomeClass();
        test.testForArray();
    }

    /**
     *  Tests if the Renderer works correctly with the default values of SomeClass.
     */
    public void testDefaultSomeClass() {
        SomeClass someClass = new SomeClass();
        Renderer testedRenderer = new Renderer(someClass);
        assertEquals("Instance of: SomeClass\nfoo (int) Value:4\nARR (int[]) Value:[ 1, 2, 3, ]\nDATE (Date) Value:Fri Jan 02 11:17:36 CET 1970\n" +
                "testing (String) Returns:success", testedRenderer.render());

    }

    /**
     * tests if an Array is not rendered correctly without a specified Renderer.
     */
    public void testForArray() {
        /**
         * a local TestClass with an incorrect array.
         */
        class TestClassWrong {
            @RenderMe
            private int[] testArray = {1, 2};

            /**
             * default c-tor
             */
            TestClassWrong() { }
        }
        /**
         * TestClass with a correctly annotated Array.
         */
        class TestClassCorrect {

            @RenderMe(with = "Renderer.ArrayRenderer")
            private int[] testArray = {1, 2};

            /**
             * default c-tor
             */
            TestClassCorrect() { }
        }

        TestClassWrong wrong = new TestClassWrong();
        TestClassCorrect correct = new TestClassCorrect();
        Renderer rendererForWrong = new Renderer(wrong);
        Renderer rendererForCorrect = new Renderer(correct);

        assertNotEquals("Instance of: TestClassWrong\ntestArray (int[]) Value:[ 1, 2, ]\n", rendererForWrong.render());
        assertEquals("Instance of: TestClassCorrect\ntestArray (int[]) Value:[ 1, 2, ]\n", rendererForCorrect.render());

    }
}
