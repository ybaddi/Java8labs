import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.*;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello");
        int exercice=0;

        // https://github.com/ybaddi/Java8labs
        System.out.println("================= Exercice " + ++exercice);
//        Exercice 1
//        E´ crire une expression lambda capitalize
//        de type Function,
//                prenant comme param` etre une chaˆıne de caract `ere,
//                retournant la mˆeme chaˆıne en remplac¸ant le premier caract `ere
//        par sa majuscule.

        Function<String,String>  capitalize = str -> str.substring(0,1).toUpperCase()+str.substring(1);
        // solution possible avec StringUtils

        System.out.println(capitalize.apply("bonjour"));

        System.out.println("================= Exercice " + ++exercice);
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
                new Personne("bono", "yassine", 113),
                new Personne("boufal", "soufiane", 19),
                new Personne("mrabet", "soufiane", 115),
                new Personne("ziyach", "hakim", 116),
                new Personne("hakimi", "achraf", 17)
        ));

        for(String str :majeurs.apply(personnes)){
            System.out.println(str);
        }


        System.out.println("================= Exercice " + ++exercice);
//        Exercice 3
//        E´ crire une expression lambda listToString
//        de type Function,
//                prenant comme param` etre une liste de String,
//                retournant la concat´enation de toutes les chaˆınes de la liste
//        Premi`ere lettre de chaque ´ el ´ement en majuscule
//        E´ le´ments concate´ne´s se´pare´s par le caracte` re espace

        Function<List<String>, String> listToString = liste ->{
            String relt="";
            for(String str: liste){
                relt += str +" ";
            }
            return relt.trim();
        };

        System.out.println(listToString.apply(majeurs.apply(personnes)));

        System.out.println("================= Exercice " + ++exercice);
//        Exercice 4
//        E´ crire une expression lambda personnesToString
//        de type Function,
//                prenant comme param` etre une liste de Personne,
//                retournant une chaˆıne contenant les noms de personnes majeures
//        s´epar´es par le caract `ere espace : premi`ere lettre de chaque nom en
//        majuscule.

        Function<List<Personne>, String> personnesToStringAndThen= majeurs.andThen(listToString);

        System.out.println(personnesToStringAndThen.apply(personnes));

        Function<List<Personne>, String> personnesToStringCompose= listToString.compose(majeurs);

        System.out.println(personnesToStringCompose.apply(personnes));


        System.out.println("================= Exercice " + ++exercice);
//        Exercice 1
//        E´ crire une expression lambda nombreOccurrences
//        de type BiFunction,
//                prenant comme premier param` etre un caract `ere
//        prenant comme deuxi`eme param` etre une chaˆıne de caract `eres
//        retournant le nombre d’apparition du premier param` etre dans le deuxi`eme.

        BiFunction<Character,String,Integer> nombreOccurrences = (c,str) -> {
            int rslt=0;
            for(int i=0; i< str.length(); i++){
                if (str.charAt(i)==c) rslt++;
            }
            return rslt;
        };

        System.out.println(nombreOccurrences.apply('a', "batmane"));

        System.out.println("================= Exercice " + ++exercice);
//        Exercice 2
//        E´ crire une expression lambda somme
//        de type BiFunction,
//                prenant deux param` etres de type Integer
//        retournant la somme des deux param` etres.

        BiFunction<Integer,Integer,Integer> sommeBifunction = (a,b) -> a+b;
        System.out.println(sommeBifunction.apply(2,5));

        BinaryOperator<Integer> sommeBinaryOperator = (a, b) -> a+b;
        System.out.println(sommeBinaryOperator.apply(2,5));

        System.out.println("================= Exercice " + ++exercice);
//        Exercice
//        E´ crire une expression lambda max
//        de type BinaryOperator,
//                prenant deux param` etres de type int
//        retournant le max des deux.

        BinaryOperator<Integer> maxMath = (a, b) -> Math.max(a,b);
        System.out.println(maxMath.apply(2,5));

        BinaryOperator<Integer> maxOneLinecondition = (a, b) -> (a>b)?a:b;
        System.out.println(maxOneLinecondition.apply(2,5));

        BinaryOperator<Integer> maxCondition = (a, b) -> {
            if(a>b)return a;
            return b;
        };
        System.out.println(maxCondition.apply(2,5));

        System.out.println("================= Exercice " + ++exercice);
//        Exercice
//        E´ crire une expression lambda supprimerMineurs
//        de type Consumer,
//                prenant un param` etre de type liste de Personne
//        supprimant les mineurs de la liste.

        Consumer<List<Personne>> supprimerMineurs = liste ->{
            Iterator<Personne> it = liste.iterator();
            while(it.hasNext()){
            if(it.next().getAge() < 18)
                    it.remove();
            }
        };
//        supprimerMineurs.accept(personnes);
        for(Personne p : personnes){
            System.out.println(p);
        }


        System.out.println("================= Exercice " + ++exercice);
//        Exercice 1
//        E´ crire une premie` re expression lambda any
//        de type Predicate,
//                prenant comme param` etre une liste de Personne,
//                retournant true s’il existe une personne majeur dans la liste, false sinon.

        Predicate<List<Personne>> any = liste ->{
            for(Personne p: liste){
                if(p.getAge() > 18) return true;
            }
            return false;
        };

        System.out.println(any.test(personnes));


        System.out.println("================= Exercice " + ++exercice);
//        Exercice 2
//        E´ crire une deuxie`me expression lambda all
//        de type Predicate,
//                prenant comme param` etre une liste de Personne,
//                retournant true si toutes les personnes de la liste sont majeures, false sinon.

        Predicate<List<Personne>> all = liste ->{
            for(Personne p: liste){
                if(p.getAge() < 18) return false;
            }
            return true;
        };

        System.out.println(all.test(personnes));


        System.out.println("================= Exercice " + ++exercice);
//        Exercice 3
//        E´ crire une deuxie`me expression lambda estPremier
//        de type Predicate,
//                prenant comme param` etre un Integer,
//                retournant true si le param` etre est un nombre premier, false sinon.

        Predicate<Integer> estPremier = nmbr ->{
            boolean compt=false;
            for(int i=2; i <= nmbr/2 ; i++){
                if(nmbr % i ==0) {compt=true; break;}
            }

            return !compt;
        };

        System.out.println(estPremier.test(2));
        System.out.println(estPremier.test(12));

        System.out.println("================= Exercice " + ++exercice);
//        Exercice 1
//        E´ crire une expression lambda containsLength
//        de type BiPredicate,
//                prenant comme premier param` etre une liste de String,
//                prenant comme deuxi`eme param` etre un entier,
//                retournant true si la liste contient un ´ el ´ement dont la taille correspond au deuxi`eme
//        param` etre, false sinon.

        List<String> listOfStr = new ArrayList<>(Arrays.asList(
                "bono",
                "boufal",
                "mrabet",
                "ziyach",
                "hakimi"
        ));

        BiPredicate<List<String>, Integer> containsLength = (liste,a) -> {
            for(String str:liste){
                if(str.length()==a) return true;
            }
            return false;
        };

        System.out.println(containsLength.test(listOfStr,12));


        System.out.println("================= Exercice " + ++exercice);
//
//        Exercice 2
//        E´ crire une expression lambda exists
//        de type BiPredicate,
//                prenant comme premier param` etre une liste de Personne,
//                prenant comme deuxi`eme param` etre une Personne,
//                retournant true si la liste contient le deuxi`eme param` etre, false sinon.

        BiPredicate<List<Personne>, Personne> exists = (liste,p) -> {
            for(Personne per:liste){
                if(per.compareTo(p)==0) return true;
            }
            return false;
        };

        System.out.println(exists.test(personnes,
                new Personne("bono", "yassine", 113)));

    }
}
