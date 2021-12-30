package fr.epsi.b3.recensement.ClasseDeService;
import fr.epsi.b3.recensement.Menuservice;
import fr.epsi.b3.recensement.recensement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AfficherLes10DepartementsLesPlusPeuples extends Menuservice{


    @Override
    public void traiter(recensement recensement, Scanner scanner) {

        Hash tri = new Hash();
        HashMap<String, Integer> mapHabitantDepartement = new HashMap<String, Integer>();
        String departement = recensement.getVilles().get(1).getCodeDepartement();
        for (int i = 1; i < recensement.getVilles().size(); i++) {
            departement = recensement.getVilles().get(i).getCodeDepartement();
            Integer nombreHabitantDepartement = mapHabitantDepartement.get(departement);
            if (nombreHabitantDepartement == null) {
                nombreHabitantDepartement = recensement.getVilles().get(i).getPopulationTotale();
            } else {
                nombreHabitantDepartement += recensement.getVilles().get(i).getPopulationTotale();
            }
            mapHabitantDepartement.put(departement, nombreHabitantDepartement);
        }
        HashMap<Integer, String> map = tri.sortValues(mapHabitantDepartement);
        int compteur = 0;
        System.out.println("\n Les 10 départements les plus peuplés sont :");
        Set set = map.entrySet();
        Iterator<HashMap> iterateur = set.iterator();

        while (iterateur.hasNext()) {
            Map.Entry entry = (Map.Entry) iterateur.next();
            if (compteur >= mapHabitantDepartement.size() - 10) {
                System.out.println("Le " +entry.getKey()+ " habitants : " + entry.getValue());
            }
            compteur++;

        }
        System.out.println();
    }

}
