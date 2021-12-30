package fr.epsi.b3.recensement.ClasseDeService;
import java.util.Scanner;
import fr.epsi.b3.recensement.recensement;
import fr.epsi.b3.recensement.Menuservice;

public class RecherchePopulationRegion extends Menuservice {

    @Override
    public void traiter(recensement recensement, Scanner scanner) {

        System.out.println("\n Veuillez entrez le nom d'une région");
        String NomRegion = scanner.nextLine();
        boolean verification = false;

        int nombrehabitant = 0;

        for (int i = 0; i < recensement.getVilles().size(); i++) {
            if (recensement.getVilles().get(i).getNomDelaRegion().equalsIgnoreCase(NomRegion)) {
                nombrehabitant += recensement.getVilles().get(i).getPopulationTotale();
                verification = true;
            }
        }

        if (verification == false) {
            System.err.println("Cette région n'existe pas , veuillez choisir une région valide\n");
        }

        System.out.println("La population dans la région " + NomRegion + " est de " + nombrehabitant + " habitants\n");

    }
}
