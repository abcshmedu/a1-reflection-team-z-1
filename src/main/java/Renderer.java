
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
     * default construdtor.
     */
    public Renderer(){}

    /**
     * returns a String reperesenting all variables of the Objekt annotated with RenderMe.
     * @return a String representation.
     */
    public String render() {
        String result= "Instance of: ";
        result += toBeRendered.getClass().getSimpleName() + "\n";
        Field[] fields = toBeRendered.getClass().getDeclaredFields();
        for (Field field : fields){
            field.setAccessible(true);
            if (field.isAnnotationPresent(RenderMe.class)){
                System.out.println(field.getType().getSimpleName());
                if (!field.getAnnotation(RenderMe.class).with().equals("")){

                 try {
                     Renderer specialRenderer = (Renderer) Class.forName(field.getAnnotation(RenderMe.class).with()).getConstructor().newInstance();
                 result += field.getName() + " (" + field.getType().getSimpleName() + ") Value:" + specialRenderer.render(field, toBeRendered) +  "\n";
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
                try {
                    result += field.getName() + " (" + field.getType().getSimpleName() + ") Value:" + field.get(toBeRendered).toString() +  "\n";
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }}
        }
        return result;
    }

    /**
     * method to be overriden for special Renderers.
     * @param field
     * @param obj
     * @return
     */
    public String render(Field field, Object obj){
        return "";
    }
}

