package fr.epsi.b3.recensement.ClasseDeService;
import fr.epsi.b3.recensement.recensement;
import fr.epsi.b3.recensement.Menuservice;
import java.util.Scanner;


public class RecherchePopulationVille extends Menuservice{

    @Override
    public void traiter(recensement recensement, Scanner scanner) {

        System.out.println("\n Veuillez entrez le nom d'une ville :");

        String nomVille = scanner.nextLine();
        boolean verification = false;
        int nombrehabitant = 0;

        for (int i = 0; i < recensement.getVilles().size(); i++) {
            if (recensement.getVilles().get(i).getNomDelaCommune().equalsIgnoreCase(nomVille)) {
                nombrehabitant = recensement.getVilles().get(i).getPopulationTotale();
                System.out.println("La population de " + nomVille + " compte " + nombrehabitant + " habitants");
                verification = true;

            }
        }
        System.out.println();
        if(verification == false) {
            System.err.println("Cette ville n'existe pas , veuillez choisir une ville valide\n");
        }

    }
}
