package be.ugent.objprog.max;

import java.util.List;

public class MaximizerMethod {

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list.isEmpty()) {
            return null;
        } else {
            T max = list.get(0);
            for (T value : list) {
                if (max.compareTo(value) < 0) {
                    max = value;
                }
            }
            return max;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                max (List.of ("1.0", "-2.0", "3.4", "-5.0"))
        );
        System.out.println(
                max (List.of ("appel", "peer", "banaan", "olifant"))
        );
    }
}
