package Armee;

import java.util.ArrayList;

public class Regiment {

	private String nom;
	private ArrayList<Humain> troupe;
	
    public Regiment(String nom)
    {
        // initialisation des variables d'instance
        this.nom = nom;
        troupe = new ArrayList<Humain>();
    }

	public ArrayList<Humain> getTroupe() {
		return this.troupe;
	}
	
	public void expulser(Humain soldat) {
		if(troupe.contains(soldat)) soldat.quitterRegiment();
		else {
			System.out.println("Le " + soldat.getFonction() + " ne fait pas partie du régiment " + this.nom);
		}
	}
    
	public void ajouter(Humain recrue) {
		varNonNull(recrue);
		if(!troupe.contains(recrue)) {
			if (recrue.getRegiment()!=null)recrue.getRegiment().expulser(recrue);
			recrue.setRegiment(this);
			troupe.add(recrue);
		}
	}

	private void varNonNull(Object obj) {
		if(obj==null) {
			throw new NullPointerException();
		}
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
    
}
