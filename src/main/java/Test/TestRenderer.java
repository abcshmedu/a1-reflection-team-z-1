package Test;

import Renderer.Renderer;

/**
 * Created by Maximilian on 03.04.2017.
 */
public final class TestRenderer {

    /**
     *
     * @param args argumente der Methode
     */
    public static void main(String... args) {
        SomeClass tested = new SomeClass();
        Renderer tester = new Renderer(tested);
        System.out.println("starting Test");
        System.out.println(tester.render());
        System.out.println("testEnde");
    }

    /**
     * not needed Ctor.
     */
    private TestRenderer() {
        //not called
    }
}
