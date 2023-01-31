import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.*;

public class Lambda {
    public static void main(String args[]) {
        // Thread thread = new Thread( new Runnable() {
        //     public void run() {
        //         System.out.println("In another thread");
        //     }
        // });
        // thread.start();

        // System.out.println("In main thread");
        // streams();
        
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2,3));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(4,5,6));
        concatenateList(a,b);
    }

    public static void streams() {
        //supplier functional interface provides/generates values without taking any input 
        Supplier<LocalDate> dSupplier = () -> LocalDate.now();
        LocalDate d1 = dSupplier.get();

        System.out.println(d1);

        Supplier<ArrayList<String>> s3 = ArrayList<String>::new;
        ArrayList<String> s4 = s3.get();

        System.out.println(s3);


        //consumers are used when you want to do something with an argument and return nothing
        Consumer<String> consumer = x -> System.out.println(x);
        consumer.accept("Nthabi");

        //Predicates are used when performing some test or matching
        // Predicate<String> p = x -> x.isEmpty();


        System.out.println("Initial array...");
        List<Integer> values = Arrays.asList(8,2,10,4,5,6,7,1,9,3);

        System.out.println(values);


        List<Integer> squared = values.stream().map(x->x*x).collect(Collectors.toList());

        System.out.println("Transformed array...");
        System.out.println(squared);

        //the collect(Collectors.toList()) is what actually converts the output from a stream to a list
        List<Integer> sorted = values.stream().sorted().collect(Collectors.toList());

        System.out.println("Sorted array...");
        System.out.println(sorted);


    }

    public static void concatenateList(ArrayList<Integer> a, ArrayList<Integer> b) {
        copyGeneric(a, b);
        System.out.println(a);
        System.out.println(b);
    }

    //Generic method
    public static <T> void copyGeneric(ArrayList<T> from, ArrayList<T> to) {
        for( T a: from) {
            to.add(a);
        }
    }

    //Non generic method
    public static <Integer> void copy(ArrayList<Integer> from, ArrayList<Integer> to) {
        for( Integer a: from) {
            to.add(a);
        }
    }


    
}