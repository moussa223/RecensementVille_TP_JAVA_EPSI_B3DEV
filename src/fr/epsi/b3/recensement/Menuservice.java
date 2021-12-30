package fr.epsi.b3.recensement;

import java.util.Scanner;

public abstract class Menuservice {
    public static void afficheLeMenu() {
        System.out.println("Action 1. Population d'une ville donnée");
        System.out.println("Action 2. Population d'un département donné");
        System.out.println("Action 3. Population d'une région donnée");
        System.out.println("Action 4. Afficher les 10 régions les plus peuplées");
        System.out.println("Action 5. Afficher les 10 départements les plus peuplés");
        System.out.println("Action 6. Afficher les 10 villes les plus peuplées d'un département");
        System.out.println("Action 7. Afficher les 10 villes les plus peuplées d'une région");
        System.out.println("Action 8. Afficher les 10 villes les plus peuplées de France");
        System.out.println("Action 9. Sortir");
    }
    public abstract void traiter(recensement recensement, Scanner scanner);

}
