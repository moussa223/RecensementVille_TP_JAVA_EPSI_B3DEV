package fr.epsi.b3.recensement.ClasseDeService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Hash {

    @SuppressWarnings("unchecked") // Je voyais plus rien du coup on enléve ca pour le moment
    public static HashMap sortValues(HashMap map) // on donne une hashMap
    {
        List<String> list = new ArrayList<String>(map.entrySet()); // on crée une nouvelle liste avec pour entrée une
        // hashMap
        // avec ces valeurs (entrySet);
        // On va comparer 2 valeurs dans notre hashMap
        Collections.sort(list, new Comparator<Object>() {
            public int compare(Object o1, Object o2) { // On prend 2 objet , pour le coup il s'agit de nos entrée
                // key/value o1 = premiére valeur de notre hashmap et o2 é la
                // seconde
                // On donne le resultat de la comparaison de la premiére valeur
                // (Comparable(Map.Entry) (o1)).getValue()) )
                // é la 2eme ".compareTo(((Map.Entry) (o2)).getValue()" la map entry prend du
                // coup la 2eme valeur de notre hashmap et en récupére la value
                return ((Comparable<Object>) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());

            }
        });

        // On copie la hashMap dans une autre afin de préservé l'ordre
        // Map entry demande une pair , c'est é dire une clé + valeur, pour avoir cette
        // info il faut l'itérator comme ca on peut avoir le getKey() et le getValue
        HashMap<Object, Object> sortedHashMap = new LinkedHashMap<Object, Object>(); // nos MapEntry sont des objets du
        // coup on attends pour clé un
        // objet et en valeur également
        Iterator i = list.iterator();
        while (i.hasNext()) {
            Map.Entry entry = (Map.Entry) i.next();
            sortedHashMap.put(entry.getKey(), entry.getValue()); // on entre nos nouvelles valeurs dans le tableau
        }
        return sortedHashMap;
    }
}
