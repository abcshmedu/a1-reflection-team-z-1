/**
 * Created by Maximilian on 27.03.2017.

**/

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //on class level

public @interface RenderMe {

    int number() default 0;
    String[] stringArray() default "";

    String createdBy() default "";

    String lastModified() default "01/01/19901";
}
