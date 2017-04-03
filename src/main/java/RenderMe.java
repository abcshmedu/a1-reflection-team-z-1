/**
 * Created by Maximilian on 27.03.2017.

**/

//import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
//import java.lang.annotation.Target;

/**
 * Anotation that sets the Retention of RenderMe to Runtime.
 */
@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.TYPE) //on class level
/**
 *  Custom Annotation used to implement a reflection mechanism.
 */
public @interface RenderMe {
    /**
     * returns the annotated Integer value, or 0 as default.
     * @return the Annotated int
     */
    int number() default 0;

    /**
     * returns an annotated String array or the default value of "".
     * @return the annotated String[]
     */
    String[] stringArray() default "";

    /**
     *returns the annotated Integer array or the default Value of {1, 2, 3}.
     * @return the annotated int[]
     */
    int[] intArray() default {1, 2, 3};

    /**
     *
     * @return the createdBy String
     */
    String createdBy() default "";

    /**
     *
     * @return the lastModified String
     */
    String lastModified() default "01/01/19901";

    /**
     *
     * @return
     */
    String with() default "";
}
