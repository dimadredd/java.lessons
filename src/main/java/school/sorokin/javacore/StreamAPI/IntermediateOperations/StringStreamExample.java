package school.sorokin.javacore.StreamAPI.IntermediateOperations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringStreamExample {
    public static void main(String[] args) {
        //1. Создаёт список строк, где каждая строка представляет предложение
        List<String> stringList = List.of(
                "Java is fun",
                "Stream API simplifies data processing"
        );

        /*2.С помощью flatMap разбивает каждое предложение на отдельные слова.
          3. Применяет filter, чтобы оставить только слова длиной более 3 символов.
          4. Применяет distinct для удаления дубликатов.
          5.Сортирует полученные слова в алфавитном порядке.
          6. Выводит итоговый список слов через forEach.
         */

        List<String> wordList = stringList.stream()
                .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                .filter(word -> word.length() > 3)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        wordList.forEach(word -> System.out.print(word + " "));
    }
}
