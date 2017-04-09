package Test;

import Renderer.RenderMe;

import java.util.*;
//import Renderer.RenderMe;

/**
 * Class that is used to test the new reflection mechanism.
 */
public class SomeClass {
    @RenderMe private int foo;
    // yes this is also magic
    @RenderMe(with = "Renderer.ArrayRenderer") private static final int[] ARR = {1, 2, 3};
    @RenderMe
    private static final Date DATEE = new Date(123456789);
    // magic number for testing
    private static final int FOUR = 4;

    /**
     * Main Method of Test.SomeClass.
     *
     * @param foo the Integer Input of the function.
     */
    public SomeClass(int foo) {
        this.foo = foo;
    }

    /**
     * default-ctor.
     */
    public SomeClass() {
        this.foo = this.FOUR;
    }

    /**
     * A method to test method rendering.
     * @return teh String Succes
     */
    @RenderMe
    public String testing() {
        return "success";
    }
}