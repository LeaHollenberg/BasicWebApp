package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Lea";
        } else if (query.contains("which of the following numbers is the largest:"){ // TODO extend the programm here
            String[] tmp = query.split(": ");
            String[] numbers = query.split(", ");

            int[] arr2 = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr2[i] = Integer.parseInt(numbers[i]);
            }

            IntStream intStream = Arrays.stream(arr2);
            OptionalInt optionalInt = intStream.max();
            int maxAsInt = optionalInt.getAsInt();
            return  maxAsInt;
        }
    }
}
