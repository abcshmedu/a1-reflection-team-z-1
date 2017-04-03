/**
 * Created by Maximilian on 03.04.2017.
 */
public class TestRenderer {

    /**
     *
     * @param args argumente der Methode
     */
    public static void main(String... args){
        SomeClass tested = new SomeClass(23);
        Renderer tester = new Renderer(tested);
        System.out.println("starting Test");
        System.out.println(tester.render());
        System.out.println("testEnde");
    }
}
