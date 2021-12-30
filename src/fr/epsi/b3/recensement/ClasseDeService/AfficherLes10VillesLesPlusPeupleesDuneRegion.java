package fr.epsi.b3.recensement.ClasseDeService;
import fr.epsi.b3.recensement.Menuservice;
import fr.epsi.b3.recensement.recensement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AfficherLes10VillesLesPlusPeupleesDuneRegion extends Menuservice{
    @Override
    public void traiter(recensement recensement, Scanner scanner) {
        Hash trie = new Hash();
        System.out.println("\n Veuillez entrez le nom d'une region voir les 10 villes les plus peuplées de cette region");
        String region = scanner.nextLine();

        HashMap<String, Integer> mapHabDep = new HashMap<String, Integer>();
        String nomVille = recensement.getVilles().get(1).getCodeDelaCommune();
        boolean verif = false;
        int nbHabs = 0;

        for (int i = 0; i < recensement.getVilles().size(); i++) {
            if (recensement.getVilles().get(i).getNomDelaRegion().equalsIgnoreCase(region)) {
                verif = true;

                nomVille = recensement.getVilles().get(i).getNomDelaCommune();
                Integer nbHabCommune = mapHabDep.get(nomVille);

                if (nbHabCommune == null) {
                    nbHabCommune = recensement.getVilles().get(i).getPopulationTotale();

                } else {
                    nbHabCommune += recensement.getVilles().get(i).getPopulationTotale();
                }
                mapHabDep.put(nomVille, nbHabCommune);
            }
        }

        if (verif == false) {
            System.err.println("Cette région n'existe pas veuillez choisir un département valide");
        }

        HashMap<Integer, String> map = trie.sortValues(mapHabDep);
        int compteur = 0;
        int affichage = 10;
        System.out.println("Les 10 villes les plus peuplées de la région " + region + " sont : \n");
        Set set = map.entrySet();
        Iterator iterator = set.iterator();

        if (verif == true) {
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                if (compteur >= mapHabDep.size() - 10) {
                    System.out.println(affichage+ ". " + entry.getKey() + " habitants : " + entry.getValue());
                    affichage--;
                }
                compteur++;
            }
            System.out.println();
        }
    }
}
