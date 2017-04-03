import java.lang.reflect.Field;

/**
 * Created by Maximilian on 03.04.2017.
 */
public class ArrayRenderer extends Renderer{

    /**
     * renders an Array into areadable String.
     * @param array
     * @return
     */
    @Override
    public String render(Field field, Object obj){
        field.setAccessible(true);
        int [] intArray = new int[0];
        try {
            intArray = (int[]) field.get(obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String result = "[ ";
        for (int i : intArray){
            result += i + ", ";
        }
        result += "]";
        return result;
    }
}
