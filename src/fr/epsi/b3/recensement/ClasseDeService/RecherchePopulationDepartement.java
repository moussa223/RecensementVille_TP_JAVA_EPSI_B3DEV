package fr.epsi.b3.recensement.ClasseDeService;
import java.util.Scanner;
import fr.epsi.b3.recensement.recensement;
import fr.epsi.b3.recensement.Menuservice;

public class RecherchePopulationDepartement extends Menuservice {
    @Override
    public void traiter(recensement recensement, Scanner scanner) {

        System.out.println("\n Veuillez entrez le numéro d'un département");
        String numérodepartement = scanner.nextLine();
        boolean verification = false;

        int nombrehabitant = 0;

        for (int i = 0; i < recensement.getVilles().size(); i++) {
            if (recensement.getVilles().get(i).getCodeDepartement().equalsIgnoreCase(numérodepartement)) {
                nombrehabitant += recensement.getVilles().get(i).getPopulationTotale();
                verification = true;
            }
        }

        if (verification == false) {
            System.err.println("Ce département n'existe pas !!!\n Notez bien: Ecrivez 01 pour le premier departement 1, 02 pour 2 ainsi de suite ....");
        }

        System.out.println("La population dans le " + numérodepartement + " est de " + nombrehabitant + " habitants\n");
    }

}
