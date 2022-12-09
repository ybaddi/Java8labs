import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");

        // https://github.com/ybaddi/Java8labs
//        Exercice 1
//        E´ crire une expression lambda capitalize
//        de type Function,
//                prenant comme param` etre une chaˆıne de caract `ere,
//                retournant la mˆeme chaˆıne en remplac¸ant le premier caract `ere
//        par sa majuscule.

        Function<String,String>  capitalize = str -> str.substring(0,1).toUpperCase()+str.substring(1);
        // solution possible avec StringUtils

        System.out.println(capitalize.apply("bonjour"));

//        Exercice 2
//        E´ crire une expression lambda majeurs
//        de type Function,
//                prenant comme param` etre une liste de Personne,
//                retournant une liste contenant les noms de personnes majeures.

        Function<List<Personne>, List<String>> majeurs = liste ->{
            List<String> noms = new ArrayList<>();
            for(Personne p : liste){
                if (p.getAge() >= 18) noms.add(p.getNom());
            }
            return noms;
        };

        List<Personne> personnes = new ArrayList<>(Arrays.asList(
                new Personne("bono", "yassine", 23),
                new Personne("boufal", "soufiane", 17),
                new Personne("mrabet", "soufiane", 25),
                new Personne("ziyach", "hakim", 16),
                new Personne("hakimi", "achraf", 17)
        ));

        for(String str :majeurs.apply(personnes)){
            System.out.println(str);
        }
    }
}
