package edu.upc.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestGameManager {

    public GameManagerImpl gestor = null;

    /**
     * Singleton
     */

    private void afegirUsuaris() {
        gestor.afegirUsuari("38383773X", "Alberto", "");
        gestor.afegirUsuari("383837B", "Marc", "");
        gestor.afegirUsuari("3838373T", "Andreu", "");
    }

    private void afegirObjectes() {
        gestor.afegirObjecteUsuari(gestor.consultarInfoUsuari("38383773X"), new Objecte("Escut"));
        gestor.afegirObjecteUsuari(gestor.consultarInfoUsuari("38383773X"), new Objecte("Cofre"));
        gestor.afegirObjecteUsuari(gestor.consultarInfoUsuari("38383773X"), new Objecte("Espasa"));
        gestor.afegirObjecteUsuari(gestor.consultarInfoUsuari("383837B"), new Objecte("Cofre"));
        gestor.afegirObjecteUsuari(gestor.consultarInfoUsuari("383837B"), new Objecte("Espasa"));
    }

    @Before
    public void setUp() {
        gestor = GameManagerImpl.getInstance();
        afegirUsuaris();
        afegirObjectes();
    }

    @After
    public void tearDown() {
        gestor.clear();
    }

    @Test
    public void testInicialitzador() {
        Assert.assertEquals("Nombre d'usuaris a llista.", 3, this.gestor.consultarNombreUsuaris());
    }

    @Test
    public void testVeureObjectesUsuari() {
        gestor.veureObjectesUsuari(gestor.consultarInfoUsuari("38383773X"));
    }

    @Test
    public void testConsultarNombreObjectesUsuari() {
        gestor.consultarNombreObjectesUsuari(gestor.consultarInfoUsuari("38383773X"));

        Assert.assertEquals("Nombre d'usuaris a llista.", 3, this.gestor.consultarNombreObjectesUsuari(gestor.consultarInfoUsuari("38383773X")));
    }

    @Test
    public void testOrdenarUsuarisAlfabeticament() {
        gestor.ordenarUsuarisAlfabeticament();
    }

    @Test
    public void testConsultarInfoUsuari() {
        gestor.consultarInfoUsuari("3838373T");
    }
}
