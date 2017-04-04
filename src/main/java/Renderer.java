
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
    public Renderer(Object target) {
        toBeRendered = target;
    }

    /**
     * default construdtor.
     */
    public Renderer() { }

    /**
     * returns a String reperesenting all variables of the Objekt annotated with RenderMe.
     * @return a String representation.
     */
    public String render() {
        String result = "Instance of: ";
        result += toBeRendered.getClass().getSimpleName() + "\n";
        Field[] fields = toBeRendered.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(RenderMe.class)) {
                System.out.println(field.getType().getSimpleName());
                if (!field.getAnnotation(RenderMe.class).with().equals("")) {

                 try {
                     Renderer specialRenderer = (Renderer) Class.forName(field.getAnnotation(RenderMe.class).with()).getConstructor().newInstance();
                 result += specialRenderer.render(field, toBeRendered);
                } catch (IllegalAccessException e) {
                     e.printStackTrace();
                 } catch (ClassNotFoundException e) {
                     e.printStackTrace();
                 } catch (NoSuchMethodException e) {
                     e.printStackTrace();
                 } catch (InstantiationException e) {
                     e.printStackTrace();
                 } catch (InvocationTargetException e) {
                     e.printStackTrace();
                 }
                } else {
                    result += render(field, toBeRendered);

            } }
        }
        return result;
    }

    /**
     * method to render the Data contained in one field, to be overwriten for special renderers.
     * @param field the field which is to be writen out
     * @param obj the object which data is to be used
     * @return The appropriate String for the Field.
     */
    public String render(Field field, Object obj) {
        String result = "";
        try {
            result += field.getName() + " (" + field.getType().getSimpleName() + ") Value:" + field.get(obj).toString() +  "\n";
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}

