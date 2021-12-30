package fr.epsi.b3.recensement.ClasseDeService;
import fr.epsi.b3.recensement.Menuservice;
import fr.epsi.b3.recensement.Ville;
import fr.epsi.b3.recensement.recensement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AfficherLes10VillesLesPlusPeupleesDeFrance extends Menuservice {

    @Override
    public void traiter(recensement recensement, Scanner scanner) {

        List<Ville> ville = recensement.getVilles();

        Collections.sort(ville, new ComparaisonPopulation());
        System.out.println("Les villes les plus peuplées de France sont: \n");
        for(int i=0; i<10; i++) {
            System.out.println("n° "+i+":"+ville.get(i).getNomDelaCommune()+": "+ville.get(i).getPopulationTotale()+" Habitants ");
        }

    }

}
