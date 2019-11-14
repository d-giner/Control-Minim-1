package edu.upc.dsa;

import java.util.*;

public interface GameManager {
        public void afegirUsuari(String id, String name, String surname);
        public Usuari modificarUsuari(String id, String name, String surname);
        public Usuari consultarInfoUsuari(String id);
        public void afegirObjecteUsuari(Usuari u, Objecte obj);
        public int consultarNombreUsuaris();
        public List<Objecte> veureObjectesUsuari(Usuari u);
        public int consultarNombreObjectesUsuari(Usuari u);
        public List<Usuari> ordenarUsuarisAlfabeticament();
        public void clear();
        public List<Usuari> obtenirLlistaUsuaris(); /** Per a Api rest */
        public Usuari getUsuari(String id); /** Per a Api rest */
    }
