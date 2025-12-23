package school.sorokin.javacore.CollectionFramework.Iterators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 20; i++){
            list.add(i);
        }

        System.out.println(list);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()){
            Integer num = iterator.next();
            if(num % 2 != 0){
                iterator.remove();
            }
        }

        System.out.println("\nПосле удаления всех нечетных чисел: ");
        for (Integer num : list){
            System.out.print(num + " ");
        }
    }
}
