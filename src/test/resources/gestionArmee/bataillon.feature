#Author: mohamed.irazzi@dauphine.eu
#Author: ryan.hamiche@dauphine.eu

Feature: US_001 Assignation à un régiment

  En tant que Humain
  Je veux pouvoir être assigné à un Regiment
  Afin de pouvoir partir à la guerre.
  
  Scenario: Assignation à un regiment
  Given un Humain veut partir à la guerre
  When  lorsqu il ne fait pas partie d un Regiment
  Then  un Regiment lui est assigne
  
  Scenario: Transfert vers un autre Regiment
  Given un Humain veut changer de Regiment
  When  son Regiment n existe plus ou si il se fait transférer
  Then  un autre Regiment lui est assigné
  
  