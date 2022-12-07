package Essais;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Armee.Mahr;
import Armee.Monture;
import Armee.Regiment;

/**
 * Classe-test HumainTest.
 *
 * @author  (votre nom)
 * @version (un numéro de version ou une date)
 *
 * Les classes-test sont documentées ici :
 * http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 * et sont basées sur le document Š 2002 Robert A. Ballance intitulé
 * "JUnit: Unit Testing Framework".
 *
 * Les objets Test (et TestSuite) sont associés aux classes à tester
 * par la simple relation yyyTest (e.g. qu'un Test de la classe Name.java
 * se nommera NameTest.java); les deux se retrouvent dans le męme paquetage.
 * Les "engagements" (anglais : "fixture") forment un ensemble de conditions
 * qui sont vraies pour chaque méthode Test à exécuter.  Il peut y avoir
 * plus d'une méthode Test dans une classe Test; leur ensemble forme un
 * objet TestSuite.
 * BlueJ découvrira automatiquement (par introspection) les méthodes
 * Test de votre classe Test et générera la TestSuite conséquente.
 * Chaque appel d'une méthode Test sera précédé d'un appel de setUp(),
 * qui réalise les engagements, et suivi d'un appel à tearDown(), qui les
 * détruit.
 */
public class HumainTest
{
    // Définissez ici les variables d'instance nécessaires à vos engagements;
    // Vous pouvez également les saisir automatiquement du présentoir
    // à l'aide du menu contextuel "Présentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du présentoir (les objets sans constructeur, comme int, float, etc.).
	private Mahr guerrier = new Mahr();
	private Mahr chevalier = new Mahr();
	private Monture cheval = new Monture("Cheval");
	private Regiment unite1 = new Regiment("Unite Un");
	private Regiment unite2 = new Regiment("Unite Deux");
    /**
     * Constructeur de la classe-test HumainTest
     */
    public HumainTest()
    {
    }

    /**
     * Met en place les engagements.
     *
     * Méthode appelée avant chaque appel de méthode de test.
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        guerrier.devenirSoldat(18);
        chevalier.devenirSoldat(20);
        chevalier.setCompagnon(cheval);
        chevalier.rejoindre(unite1);
        unite2.ajouter(guerrier);
    }

    /**
     * Supprime les engagements
     *
     * Méthode appelée après chaque appel de méthode de test.
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
    
    @Test
    public void verifierSoldat()
    {
        assertEquals(guerrier.getFonction(),"Soldat");
    }
    
    @Test
    public void testerMonture()
    {
        
        assertEquals(chevalier.getMonture().getRace(),"Cheval");
        assertEquals(cheval.getProprietaire().getFonction(),"Soldat");
        
    }
    
    @Test
    public void testerRegiment()
    {        
        assertEquals(chevalier.getRegiment().getNom(),"Unite Un");
        assertTrue(unite2.getTroupe().contains(guerrier));
        
        guerrier.rejoindre(unite1);
        
        assertTrue(unite1.getTroupe().contains(guerrier));
        assertFalse(unite2.getTroupe().contains(guerrier));
        assertEquals(guerrier.getRegiment().getNom(),"Unite Un");
        
        unite2.expulser(chevalier);
        assertEquals(chevalier.getRegiment().getNom(),"Unite Un");
        unite1.expulser(chevalier);
        assertFalse(unite1.getTroupe().contains(chevalier));
        assertEquals(chevalier.getRegiment(),null);
        
        guerrier.quitterRegiment();
        assertFalse(unite1.getTroupe().contains(guerrier));
        assertEquals(guerrier.getRegiment(),null);
        
    }
}
