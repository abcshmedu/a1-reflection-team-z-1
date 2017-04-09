package Test;

import Renderer.RenderMe;

import java.util.*;
//import Renderer.RenderMe;

/**
 * Class that is used to test the new reflection mechanism.
 */
public class SomeClass {
    @RenderMe private int foo;
    @RenderMe(with = "Renderer.ArrayRenderer") private int[] array = {1, 2, 3};
    @RenderMe
    private Date date = new Date(123456789);

    /**
     * Main Method of Test.SomeClass.
     *
     * @param foo the Integer Input of the function.
     */
    public SomeClass(int foo) {
        this.foo = foo;
    }

    /**
     * default-ctor
     */
    public SomeClass() {
        this.foo = 4;
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