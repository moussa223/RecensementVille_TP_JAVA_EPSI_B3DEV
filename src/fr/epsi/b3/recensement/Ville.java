package fr.epsi.b3.recensement;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ville {

    private String CodeRegion;
    private String NomDelaRegion;
    private String CodeDepartement;
    private String CodeDelaCommune;
    private String NomDelaCommune;
    private int PopulationTotale;

    public Ville(String codeRegion, String nomDelaRegion, String codeDepartement, String codeDelaCommune, String nomDelaCommune, int populationTotale) {
        super();
        CodeRegion = codeRegion;
        NomDelaRegion = nomDelaRegion;
        CodeDepartement = codeDepartement;
        CodeDelaCommune = codeDelaCommune;
        NomDelaCommune = nomDelaCommune;
        PopulationTotale = populationTotale;
    }

    public String getCodeRegion() {
        return CodeRegion;
    }

    public void setCodeRegion(String codeRegion) {
        CodeRegion = codeRegion;
    }

    public String getNomDelaRegion() {
        return NomDelaRegion;
    }

    public void setNomDelaRegion(String nomDelaRegion) {
        NomDelaRegion = nomDelaRegion;
    }

    public String getCodeDepartement() {
        return CodeDepartement;
    }

    public void setCodeDepartement(String codeDepartement) {
        CodeDepartement = codeDepartement;
    }

    public String getCodeDelaCommune() {
        return CodeDelaCommune;
    }

    public void setCodeDelaCommune(String codeDelaCommune) {
        CodeDelaCommune = codeDelaCommune;
    }

    public String getNomDelaCommune() {
        return NomDelaCommune;
    }

    public void setNomDelaCommune(String nomDelaCommune) {
        NomDelaCommune = nomDelaCommune;
    }

    public Integer getPopulationTotale() {
        return PopulationTotale;
    }

    public void setPopulationTotale(Integer populationTotale) {
        PopulationTotale = populationTotale;
    }



}
