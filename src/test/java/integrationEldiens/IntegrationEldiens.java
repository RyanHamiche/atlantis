package integrationEldiens;

import org.junit.Assert;

import Armee.Mahr;
import Armee.Regiment;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import shiganshina.Eldien;

public class IntegrationEldiens {
	private Eldien e1 = new Eldien("Guerric","Guair");
	private Mahr m1 = new Mahr();
	private Regiment r1 = new Regiment("Unite Un");
	private Regiment r2 = new Regiment("Unite Deux");
	@Given("Un eldien se prépare à la guerre")
	public void un_eldien_se_prépare_à_la_guerre() {
		Assert.assertTrue(e1 != null);
	}

	@When("Lorsqu il rejoint un régiment")
	public void lorsqu_il_rejoint_un_régiment() {
		Assert.assertTrue(r1 != null);
		Assert.assertTrue(e1.getRegiment() == null);
	    e1.rejoindre(r1);
	    Assert.assertTrue(m1 != null);
	    m1.rejoindre(r1);
	}

	@Then("Il peut partir sur le champ de bataille aux cotes de Mahrs")
	public void il_peut_partir_sur_le_champ_de_bataille_aux_cotes_de_Mahrs() {
	    Assert.assertTrue(r1.getTroupe().contains(e1));
	    Assert.assertTrue(r1.getTroupe().contains(m1));
	}

	@Given("un eldien veut changer de Regiment")
	public void un_eldien_veut_changer_de_Regiment() {
		r1.ajouter(e1);
		Assert.assertTrue(e1.getRegiment() != null);
	}

	@When("son Regiment n existe plus ou si il se fait transférer")
	public void son_Regiment_n_existe_plus_ou_si_il_se_fait_transférer() {
		Assert.assertTrue(r1 != null);
		r2.ajouter(e1);
	}

	@Then("un autre Regiment lui est assigné")
	public void un_autre_Regiment_lui_est_assigné() {
	    Assert.assertNotEquals(e1.getRegiment(),r1);
	    Assert.assertEquals(e1.getRegiment(),r2);
	}
}
