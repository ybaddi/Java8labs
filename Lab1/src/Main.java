import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");

//        Exercice 1
//        E´ crire une expression lambda capitalize
//        de type Function,
//                prenant comme param` etre une chaˆıne de caract `ere,
//                retournant la mˆeme chaˆıne en remplac¸ant le premier caract `ere
//        par sa majuscule.

        Function<String,String>  capitalize = str -> str.substring(0,1).toUpperCase()+str.substring(1);
        // solution possible avec StringUtils

        System.out.println(capitalize.apply("bonjour"));

    }
}
