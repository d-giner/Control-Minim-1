package edu.upc.dsa;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestGameManager {

    public GameManagerImpl gestor = null; /** Singleton */

    private void afegirUsuaris() {
        gestor.afegirUsuari("38383773X", "Alberto", "Machaca");
        gestor.afegirUsuari("383837B", "Marc", "Tender");
        gestor.afegirUsuari("3838373T", "David", "Adeu");
    }

    private void afegirObjectes() {
        gestor.afegirObjecteUsuari(gestor.getUsuari("38383773X"), new Objecte("Escut"));
        gestor.afegirObjecteUsuari(gestor.getUsuari("38383773X"), new Objecte("Cofre"));
        gestor.afegirObjecteUsuari(gestor.getUsuari("3838373T"), new Objecte("Espasa"));
        gestor.afegirObjecteUsuari(gestor.getUsuari("383837B"), new Objecte("Cofre"));
        gestor.afegirObjecteUsuari(gestor.getUsuari("383837B"), new Objecte("Espasa"));
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
    public void testConsultarNombreUsuaris() {
        Assert.assertEquals("Nombre d'usuaris a llista.", 3, this.gestor.consultarNombreUsuaris());
    }

    @Test
    public void testVeureObjectesUsuari() {
        Assert.assertEquals("Nombre d'usuaris a llista.", "Espasa", this.gestor.veureObjectesUsuari(gestor.getUsuari("3838373T")).get(0).getId());
    }

    @Test
    public void testConsultarNombreObjectesUsuari() {
        Assert.assertEquals("Nombre d'usuaris a llista.", 2, this.gestor.consultarNombreObjectesUsuari(gestor.consultarInfoUsuari("38383773X")));
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
