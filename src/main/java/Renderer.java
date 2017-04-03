
import java.lang.reflect.*;

/**
 * Created by Maximilian on 03.04.2017.
 */
public class Renderer {

    private Object toBeRendered;

    /**
     * Creates a new Renderer for the given target.
     * @param target the Object to be rendered
     */
    public Renderer(Object target){
        toBeRendered = target;
    }

    /**
     * returns a String reperesenting all variables of the Objekt annotated with RenderMe.
     * @return a String representation.
     * @throws Exception an exception.
     */
    public String render() {
        String result= "";
        Field[] fields = toBeRendered.getClass().getDeclaredFields();
        for (Field field : fields){
            if (field.isAnnotationPresent(RenderMe.class)){
                result += field.getName() + " (" + field.getType().getSimpleName() + ") Value:";

            }
        }
        return result;
    }
}

