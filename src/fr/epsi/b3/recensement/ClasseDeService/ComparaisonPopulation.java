package fr.epsi.b3.recensement.ClasseDeService;
import fr.epsi.b3.recensement.Ville;
import java.util.Comparator;

public class ComparaisonPopulation implements Comparator<Ville>{

    @Override
    public int compare(Ville o1, Ville o2) {
        if(o1.getPopulationTotale() < o2.getPopulationTotale()) {
            return 1;
        }
        else if (o1.getPopulationTotale() > o2.getPopulationTotale()) {
            return -1;
        }
        return 0;
    }
}
