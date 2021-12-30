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

    @SuppressWarnings("unchecked")
    public static HashMap sortValues(HashMap map)
    {
        List<String> list = new ArrayList<String>(map.entrySet());
        Collections.sort(list, new Comparator<Object>() {
            public int compare(Object o1, Object o2) {
                return ((Comparable<Object>) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());

            }
        });


        HashMap<Object, Object> sortedHashMap = new LinkedHashMap<Object, Object>();
        Iterator i = list.iterator();
        while (i.hasNext()) {
            Map.Entry entry = (Map.Entry) i.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
