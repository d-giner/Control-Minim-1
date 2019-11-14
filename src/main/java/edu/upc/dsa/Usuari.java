package edu.upc.dsa;

import java.util.*;

public class Usuari {

    public String nom;
    public String id;
    public String surname;
    private List<Objecte> objectes;


    public Usuari(String id, String name, String surname){
        this.id = id;
        this.nom=name;
        this.surname = surname;
        this.objectes = new LinkedList<Objecte>();
    }

    public Usuari(String n, int i){ /** Constructor d'dsa.Usuari: nom, identificador i nombre total de comandes. */
        this.nom = n;
        this.id = ""+i;
    }

    /** Mètodes per actualitzar i llegir els atributs */
    public String getNom(){
        return this.nom;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getId(){
        return this.id;
    }

    public void setNom(String n){
        this.nom = n;
    }

    public void setSurname(String sur){
        this.surname = sur;
    }

    public void addObjecte(Objecte objecte) {
        this.objectes.add(objecte);
    }

    public List<Objecte> getObjectesUsuari(){
        return this.objectes;
    }

    public int getNumObjects() {
        return this.objectes.size();
    }
}
