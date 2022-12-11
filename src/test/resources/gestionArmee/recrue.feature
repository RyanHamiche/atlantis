#Author: mohamed.irazzi@dauphine.eu
#Author: ryan.hamiche@dauphine.eu

Feature: US_002 Recrutement des soldats

  En tant que Humain
  Je veux pouvoir me préparer au combat
  Afin de pouvoir partir à la guerre.
  
  Scenario: un Humain a besoin d une monture
  Given un Humain veut partir a la guerre
  When  il a besoin de mobilite
  Then  attribuer la Monture a l Humain
  
  Scenario Outline: Un humain atteint la majorité
  Given l armee appelle les Humains à devenir Soldat
  When  un Humain atteint un <age> lui procurant la majorité
  Then  il obtient une fonction <fct> correspondant à son âge
  
  Examples: 
  | age			| fct 	|
  | 18 			| "Soldat"    |
  | 15			| "Aucun"			|
  | 22			| "Chevalier"	|
  | 32			| "Officier"	|
  | 36			| "Vétéran"		|
  | 48			|	"Senior"		|