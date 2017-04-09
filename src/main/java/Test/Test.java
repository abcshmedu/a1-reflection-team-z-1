package Test;
import Renderer.*;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Maximilian on 09.04.2017.
 */
public class Test {

    /**
     *  Tests if the Renderer works correctly with the default values of SomeClass.
     */
    public void testDefaultSomeClass() {
        SomeClass someClass = new SomeClass();
        Renderer testedRenderer = new Renderer(someClass);
        assertEquals("", testedRenderer.render());

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

        assertNotEquals("Instance of: TestClassWrong\ntestArray (int[]) Value:[ 1, 2, ]", rendererForWrong.render());
        assertEquals("Instance of: TestClassCorrect\ntestArray (int[]) Value:[ 1, 2, ]", rendererForCorrect.render());

    }
}
