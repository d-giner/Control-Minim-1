package edu.upc.dsa;

import java.util.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class GameManagerImpl implements GameManager{
    /** Singleton */
    private static GameManagerImpl instance;

    public static GameManagerImpl getInstance(){
        if (instance == null) instance = new GameManagerImpl();
        return instance;
    }
    /** Singleton end line */

    public Logger log = LogManager.getLogger(GameManagerImpl.class);

    private List<Objecte> lObjectes = null; /** Llistat d'objectes */
    private List<Usuari> lUAux = null; /** LLista estàndard d'usuaris per a consultes alternatives */
    private HashMap<String, Usuari> lUsuaris = null;  /** HashMap d'usuaris */


    private GameManagerImpl() {
        lObjectes = new ArrayList<Objecte>();
        lUsuaris = new HashMap<String, Usuari>();
        lUAux = new LinkedList<>();
    }

    public void clear() {
        lObjectes.clear();
        lUsuaris.clear();
        lUAux.clear();
    }

    public List<Usuari> obtenirLlistaUsuaris(){ /** Per a Api rest */
        return this.lUAux;
    }

    public void afegirUsuari(String id, String name, String surname) { /** Afegir un nou usuari */
        this.lUsuaris.put(id, new Usuari(id, name, surname));
        this.lUAux.add(new Usuari(id, name, surname));
        log.info("Usuari afegit correctament.");
    }

    public Usuari consultarInfoUsuari(String id){ /** Obtenir informació d'un usuari */
        Usuari u = lUsuaris.get(id);
        if(u != null){
            log.info("Usuari: " + u.getId() + ", Nom: " + u.getNom() + " i surname: " + u.getSurname());
        }
        else{
            log.error("L'usuari amb aquest id no existeix.");
        }
        return u;
    }

    public Usuari getUsuari(String id){ /** Obtenir un usuari */
        Usuari u = lUsuaris.get(id);
        if(u == null){
            log.error("L'usuari amb aquest id no existeix.");
        }
            return u;
    }


    public Usuari modificarUsuari(String id, String name, String surname) { /** Modificar les dades dels usuaris */
        Usuari u = lUsuaris.get(id);
        if(u != null){
            u.setNom(name);
            u.setSurname(surname);
            log.info("L'usuari: " + u.getId() + " ha estat modificat correctament.");
        }
        else{
            log.error("L'usuari amb aquest id no existeix.");
        }
        return u;
    }

    public void afegirObjecteUsuari(Usuari u, Objecte obj) { /** Afegir objectes als usuaris*/
        if(u != null) {
            u.addObjecte(obj);
            log.info("L'objecte: " + obj.getId() + " ha estat afegit a l'inventari de l'usuari: " + u.getNom());
        }
        else{
            log.error("L'usuari amb aquest id no existeix.");
        }
    }

    public int consultarNombreUsuaris(){ /** Consultar el nombre d'usuaris que hi ha registrats. */
        if (lUsuaris.size() >0 ){
            log.info("Nombre d'usuaris: " + lUsuaris.size());
        }
        else
            log.error("No hi cap usuari a la llista.");
        return lUsuaris.size();
    }

    public List<Objecte> veureObjectesUsuari(Usuari u) { /** Rebem la llista d'objectes d'un usuari*/
        log.info(u.getObjectesUsuari());
        return u.getObjectesUsuari();
    }

    public int consultarNombreObjectesUsuari(Usuari u) { /** Rebem el nombre d'objectes que té un usuari */
        if(u.getNumObjects() > 0){
            log.info("L'usuari: " + u.getNom() + " té " + u.getNumObjects() + " objectes al seu inventari.");
        }
        else{
            log.error("Aquest usuari no té cap objecte.");
        }
    return u.getNumObjects();
    }

    public List<Usuari> ordenarUsuarisAlfabeticament(){ /** Ordenem el nom dels usuaris alfabéticament */
        List<Usuari> lAux = new ArrayList<Usuari>();
        lAux.addAll(lUAux);

        if (lAux.size() > 0) {
            Collections.sort(lAux, new Comparator<Usuari>() {
                @Override
                public int compare(final Usuari object1, final Usuari object2) {
                    return object1.getNom().compareTo(object2.getNom());
                }
            });
        }
        log.info("Noms ordenats alfabétiacament: " + lAux);
        log.info("Noms desxifrats: ");
        for (Usuari u : lAux){
            log.info("Nom: " + u.getNom());
        }
        return lAux;
    }
}
