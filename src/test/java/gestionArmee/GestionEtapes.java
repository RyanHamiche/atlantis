package gestionArmee;

import org.junit.Assert;

import Armee.Mahr;
import Armee.Monture;
import Armee.Regiment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GestionEtapes {
	private Mahr h1 = new Mahr();
	private Regiment r1 = new Regiment("Unite Un");
	private Regiment r2 = new Regiment("Unite Deux");
	private Monture m1 = new Monture("Cheval");
	
	
	@Given("un Humain veut partir à la guerre")
	public void un_Humain_veut_partir_à_la_guerre() {
		Assert.assertTrue(h1!=null);
	}

	@When("lorsqu il ne fait pas partie d un Regiment")
	public void lorsqu_il_ne_fait_pas_partie_d_un_Regiment() {
		Assert.assertTrue(r1!=null);
		Assert.assertTrue(h1.getRegiment()==null);
	}

	@Then("un Regiment lui est assigne")
	public void un_Regiment_lui_est_assigne() {
	    h1.rejoindre(r1);
	    Assert.assertTrue(r1.getTroupe().contains(h1));
	}

	@Given("un Humain veut changer de Regiment")
	public void un_Humain_veut_changer_de_Regiment() {
		r1.ajouter(h1);
		Assert.assertTrue(h1.getRegiment()!=null);
	}

	@When("son Regiment n existe plus ou si il se fait transférer")
	public void son_Regiment_n_existe_plus_ou_si_il_se_fait_transférer() {
		Assert.assertTrue(r1!=null);
	}

	@Then("un autre Regiment lui est assigné")
	public void un_autre_Regiment_lui_est_assigné() {
	    r2.ajouter(h1);
	    Assert.assertNotEquals(h1.getRegiment(),r1);
	    Assert.assertEquals(h1.getRegiment(),r2);
	}

	@Given("un Humain veut partir a la guerre")
	public void un_Humain_veut_partir_a_la_guerre() {
		Assert.assertTrue(h1!=null);
	}

	@When("il a besoin de mobilite")
	public void il_a_besoin_de_mobilite() {
		Assert.assertTrue(h1.getMonture()==null);
		Assert.assertTrue(m1!=null);
	}

	@Then("attribuer la Monture a l Humain")
	public void attribuer_la_Monture_a_l_Humain() {
	    m1.setProprietaire(h1);
	    Assert.assertTrue(h1.getMonture()!=null);
	}

	@Given("l armee appelle les Humains à devenir Soldat")
	public void l_armee_appelle_les_Humains_à_devenir_Soldat() {
		Assert.assertTrue(h1!=null);
	}

	@When("un Humain atteint un {int} lui procurant la majorité")
	public void un_Humain_atteint_un_lui_procurant_la_majorité(Integer int1) {
		h1.devenirSoldat(int1); 
		Assert.assertTrue(h1!=null);
	}
	
	@Then("il obtient la fonction Soldat de Soldat.")
	public void il_obtient_la_fonction_Soldat_de_Soldat() {
		Assert.assertEquals(h1.getFonction(),"Soldat");
	}

	@Then("il obtient la fonction Aucun de Soldat.")
	public void il_obtient_la_fonction_Aucun_de_Soldat() {
		Assert.assertEquals(h1.getFonction(),"Aucun");
	}
}
