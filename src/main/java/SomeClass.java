import java.io.*;
import java.util.*;
//import RenderMe;

/**
 * Class that is used to test the new reflection mechanism.
 */
public class SomeClass {
    @RenderMe private int foo;
    @RenderMe() private int[] array = {1, 2, 3};
    @RenderMe private Date date = new Date(123456789);

    /**
     * Main Method of SomeClass.
     *
     * @param foo the Integer Input of the function.
     */
    public SomeClass(int foo) {
        this.foo = foo;
    }
}