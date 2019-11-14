package edu.upc.dsa;

import java.util.*;

public interface GameManager {
        public void afegirUsuari(String id, String name, String surname);
        public void modificarUsuari(String id, String name, String surname);
        public Usuari consultarInfoUsuari(String id);
        public void afegirObjecteUsuari(Usuari u, Objecte obj);
        public int consultarNombreUsuaris();
        public List<Objecte> veureObjectesUsuari(Usuari u);
        public int consultarNombreObjectesUsuari(Usuari u);
        public List<Usuari> ordenarUsuarisAlfabeticament();


//        public void anotarComanda(Comanda p); /** Recollim les dades de la comanda i afegim a la cua de comandes*/
//        public void servirComanda(); /** Crearem nova comanda i actualitzarem la llista i la cua de comandes*/
//        public List<Comanda> consultarComandesUsuari(String id); /** Mostrar totes les comandes realitzades d'un usuari concret */
//        public List<Producte> ordenarUsuarisAlfabeticament(); /** Mostrar el llistat de productes ordenats per preu */
//        public List<Producte> ordenarProductesVendes(); /** Mostrar el lisstat de prodcutes ordenats per nombre de vendes */
//        public int numUsers();
//        public int numProducts();
//        public int numComandes();

        public void clear();
    }
