package fr.epsi.b3.recensement.ClasseDeService;
import fr.epsi.b3.recensement.recensement;
import fr.epsi.b3.recensement.Menuservice;
import fr.epsi.b3.recensement.ClasseDeService.Hash;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AfficherLes10RegionLesPlusPeuplees extends Menuservice{

    @Override
    public void traiter(recensement recensement, Scanner scanner) {

        Hash tri = new Hash();
        HashMap<String, Integer> MapHabitantRegion = new HashMap<String, Integer>();
        String nomRegion = recensement.getVilles().get(1).getNomDelaRegion();
        List<Integer> RegionPeuplee = new ArrayList<Integer>();

        for (int i = 1; i < recensement.getVilles().size(); i++) {
            nomRegion = recensement.getVilles().get(i).getNomDelaRegion();
            Integer nbHabRegion = MapHabitantRegion.get(nomRegion);
            if (nbHabRegion == null) {
                nbHabRegion = recensement.getVilles().get(i).getPopulationTotale();
            } else {
                nbHabRegion += recensement.getVilles().get(i).getPopulationTotale();
            }
            MapHabitantRegion.put(nomRegion, nbHabRegion);
        }

        HashMap<Integer, String> map = tri.sortValues(MapHabitantRegion);
        int compteur = 0;
        System.out.println("\nLes 10 régions les plus peuplés sont :\n");
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            if (compteur >= MapHabitantRegion.size() - 10) {
                System.out.println(entry.getKey()+ " habitants : " + entry.getValue());
            }
            compteur++;

        }
        System.out.println();
    }


}
