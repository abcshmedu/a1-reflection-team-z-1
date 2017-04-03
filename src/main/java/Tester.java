import java.lang.reflect.Method;
//import java.lang.reflect.InvocationTargetException;

/**
 *  Class used for Testing.
 */
class Tester {
    /**
     * parse function that checks if the reflection works as intended.
     * @param clazz the Class to be used in the reflection
     * @throws Exception
     */
    public void parse(Class< ? > clazz) throws Exception {
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(RenderMe.class)) {
                RenderMe test = method.getAnnotation(RenderMe.class);
                int number = test.number();
                if (number == 2) {
                    System.out.println("number is correct");
                    // try to invoke the method with param
                    method.invoke(
                            clazz.newInstance(),
                            number
                    );
                }
            }
        }
    }
}