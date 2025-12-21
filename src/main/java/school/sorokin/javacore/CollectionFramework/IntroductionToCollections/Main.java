package school.sorokin.javacore.CollectionFramework.IntroductionToCollections;

public class Main {
    public static void main(String[] args) {

        //Integer Boxes

        GenericBox<Integer> iB1 = new GenericBox<>(10);
        GenericBox<Integer> iB2 = new GenericBox<>(20);

        //String Boxes

        GenericBox<String> sB1 = new GenericBox<>("Hello");
        GenericBox<String> sB2 = new GenericBox<>("Hello");

        System.out.println("Integer boxes: ");
        System.out.println(iB1.getContent());
        System.out.println(iB2.getContent());
        System.out.println("Равны ли коробки: " + iB1.isEqual(iB2));
        System.out.println();
        System.out.println("String boxes:");
        System.out.println(sB1.getContent());
        System.out.println(sB2.getContent());
        System.out.println("Равны ли коробки: " + sB1.isEqual(sB2));

        iB1.swap(iB2);
        sB1.swap(sB2);

        System.out.println("\nПосле swap: \n");
        System.out.println("Integer boxes: ");
        System.out.println(iB1.getContent());
        System.out.println(iB2.getContent());
        System.out.println();
        System.out.println("String boxes:");
        System.out.println(sB1.getContent());
        System.out.println(sB2.getContent());

        sB2.setContent("World!\n");
        System.out.print("После setContent: ");
        System.out.print(sB1.getContent() + " ");
        System.out.print(sB2.getContent());



    }
}
