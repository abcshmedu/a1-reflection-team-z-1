package Renderer;


import java.lang.reflect.Field;

/**
 * Created by Maximilian on 03.04.2017.
 */
public class ArrayRenderer extends Renderer {

    /**
     * renders an Array into areadable String.
     * @param field the Field which will be Rendered
     * @param obj the object which values for field are displayed
     * @return a String representation of the rendered field
     */
    @Override
    public String render(Field field, Object obj) {
        field.setAccessible(true);
        int [] intArray = new int[0];
        try {
            intArray = (int[]) field.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String result = field.getName() + " (" + field.getType().getSimpleName() + ") Value:" + "[ ";
        for (int i : intArray) {
            result += i + ", ";
        }
        result += "]\n";
        return result;
    }
}
