package shiganshina;

import java.util.ArrayList;
import java.util.List;

import Armee.Humain;

/**
 * Décrivez votre classe Humain ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Eldien extends Humain
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private List<Titan> listeTitan;

    /**
     * Constructeur d'objets de classe Humain
     */
    public Eldien(String nom, String prenom)
    {
    	super(nom,prenom);
        this.listeTitan=new ArrayList<Titan>();
    }
    
    public Eldien()
    {
        super();
        this.listeTitan=new ArrayList<Titan>();
    }
    
    public void ajouterFuturTitan(Titan t)
    {
        this.listeTitan.add(t);
    }
    
    public List<Titan> getTitan()
    {
        return listeTitan;
    }
    
    public List<Double> getTailleFuturTitan()
    {
    	ArrayList<Double> idx = new ArrayList<Double>();
    	creerListeTailleTitan(idx);
        return idx;
    }

	private void creerListeTailleTitan(ArrayList<Double> idx) {
		for(int i=0; i<listeTitan.size(); i++) {
    		idx.add((double) listeTitan.get(i).getTaille());
    	}
	}
	
	public void transfererTitan(Titan t1, Eldien h1) {
		if(this.listeTitan.contains(t1)) {
			this.listeTitan.remove(t1);
			h1.ajouterFuturTitan(t1);
		}
	}
}
