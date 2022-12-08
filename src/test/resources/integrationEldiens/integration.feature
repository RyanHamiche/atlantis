#Author: Firas BARBOUCH
#Author: Yanis LAGHMOURI
#Author: Ryan HAMICHE
#Author: Mohamed IRAZZI

Feature: US_003 Les eldiens peuvent faire partie des régiments

	En tant qu’eldien,
	Je veux pouvoir rejoindre un régiment au côté de mahr
	Afin de pouvoir partir à la guerre.
	
	Scenario: Un eldien rejoint un régiment
	Given Un eldien se prépare à la guerre 
	When 	Lorsqu il rejoint un régiment
	Then 	Il peut partir sur le champ de bataille aux cotes de Mahrs
	
	Scenario: Transfert d un eldien vers un autre régiment
  Given un eldien veut changer de Regiment
  When  son Regiment n existe plus ou si il se fait transférer
  Then  un autre Regiment lui est assigné
  