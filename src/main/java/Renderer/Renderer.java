package Renderer;

import java.lang.reflect.*;

/**
 * Created by Maximilian on 03.04.2017.
 */
public class Renderer {

    private Object toBeRendered;

    /**
     * Creates a new Renderer.Renderer for the given target.
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
     * returns a String reperesenting all variables of the Objekt annotated with Renderer.RenderMe.
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
        result += renderMethods();
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

    /**
     * a Method that retunns a String detailing the parameterless methods of toBeRendered.
     * @return the String render of the Methods
     */
    private String renderMethods() {
        String result = "";
        Method[] methods = toBeRendered.getClass().getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            if (method.isAnnotationPresent(RenderMe.class)) {
                if (method.getGenericParameterTypes().length == 0) {
                    try {
                        result += method.getName().toString() + " (" + method.getReturnType().getSimpleName() + ") Returns:" + method.invoke(toBeRendered).toString();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }
}

