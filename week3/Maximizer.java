package be.ugent.objprog.max;

public class Maximizer<T extends Comparable<T>> {

    private T max;

    public Maximizer (T value) {
        this.max = value;
    }

    public void add (T value) {
        if (max.compareTo(value) < 0) {
            max = value;
        }
    }

    public T max() {
        return max;
    }


    // Om te testen
    public static void main(String[] args) {
        // met kommagetallen
        Maximizer<Double> maximizer = new Maximizer<> (1.5); // eerste element
        maximizer.add (1.0);
        maximizer.add (3.0);
        maximizer.add (-0.2);
        System.out.println (maximizer.max()); // print 3.0

        // met Strings
        Maximizer<String> max2 = new Maximizer<> ("appel"); // eerste element
        max2.add ("peer");
        max2.add ("banaan");
        max2.add ("olifant");
        System.out.println (max2.max()); // print peer
    }

}
