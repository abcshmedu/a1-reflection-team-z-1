import java.io.*;
import java.util.*;
//import RenderMe;
public class SomeClass {
    @RenderMe private int foo;
    @RenderMe() int[] array = {1, 2, 3, };
    @RenderMe private Date date = new Date(123456789);

    public SomeClass(int foo) {
        this.foo = foo;
    }
}