package fr.epsi.b3.recensement;
import fr.epsi.b3.recensement.ClasseDeService.*;
import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {
        // write your code here
        Path CheminFichier=Paths.get("C:\\Users\\mm682\\Downloads\\recensement_2016.csv");
        /*  Test pour voir si le fichier existe
        if (CheminFichier!=null){
            System.out.println("fichier trouvé");
        }else {
            System.out.println("fichier non trouvé");
        }
         */
        List<String> lignes= Files.readAllLines(CheminFichier, StandardCharsets.UTF_8);
        lignes.remove(0);
        recensement recensements= new recensement();
        // On commence par découper la ligne en morceaux sur la base du caractère
        //séparateur « ; » . De plus on ne récupère que les morceaux qui nous
        //intéressent. En l’occurrence on ignore les morceaux 3 et 4 dont on a pas
        //besoin dans le TP
        for (String ligne : lignes) {
            String[] DonneVille = ligne.split(";");
            String codeRegion = DonneVille[0];
            String nomRegion = DonneVille[1];
            String codeDepartement = DonneVille[2];
            String codeCommune = DonneVille[5];
            String nomCommune = DonneVille[6];
            int populationTotale = Integer.parseInt(DonneVille[9].replace(" ", ""));
            Ville ville = new Ville(codeRegion, nomRegion, codeDepartement, codeCommune, nomCommune, populationTotale);
            recensements.getVilles().add(ville);
        }

        Scanner scanner = new Scanner(System.in);
        int choix=-1;
        while ( choix!=9){
            System.out.println("|_______________________________________________________________________________________|");
            System.out.println(" |MENU APPLICATION RECENSEMENT 2016 | Choisissez l'action à effectuer");
            System.out.println("|_______________________________________________________________________________________|");
            Menuservice.afficheLeMenu();
            choix=Integer.parseInt(scanner.nextLine());
            switch (choix){
                case 1:
                    RecherchePopulationVille recherche = new RecherchePopulationVille();
                    recherche.traiter(recensements,scanner);
                    break;
                case 2:
                    RecherchePopulationDepartement recherche1= new RecherchePopulationDepartement();
                    recherche1.traiter(recensements,scanner);
                    break;
                case 3:
                    RecherchePopulationRegion recherche2= new RecherchePopulationRegion();
                    recherche2.traiter(recensements,scanner);
                    break;
                case 4:
                    AfficherLes10RegionLesPlusPeuplees recherche4=new AfficherLes10RegionLesPlusPeuplees();
                    recherche4.traiter(recensements,scanner);
                    break;
                case 5:
                    AfficherLes10DepartementsLesPlusPeuples recherche5 = new AfficherLes10DepartementsLesPlusPeuples();
                    recherche5.traiter(recensements,scanner);
                    break;
                case 6:
                    AfficherLes10VillesLesPlusPeupleesDunDepartement recherche6 = new AfficherLes10VillesLesPlusPeupleesDunDepartement();
                    recherche6.traiter(recensements,scanner);
                    break;
                case 7:
                    AfficherLes10VillesLesPlusPeupleesDuneRegion recherche7 = new AfficherLes10VillesLesPlusPeupleesDuneRegion();
                    recherche7.traiter(recensements,scanner);
                    break;
                case 8:
                    AfficherLes10VillesLesPlusPeupleesDeFrance recherche8 = new AfficherLes10VillesLesPlusPeupleesDeFrance();
                    recherche8.traiter(recensements,scanner);
                    break;
                default:
                    System.out.println("Vous avez choisi de Fermer de l'application");
                    System.err.println("Fermeture de l'application......");
            }
        }
    }
}
