Drastaru Florina Cristina 325CA

League of OOP is a java project that implements a game that happens on a 2D map.

Implementation
The project is organised in several packages and classes:

- package main : Class Main, Class GameInput, GameInputLoader;

- package heros : Class Hero, Class HeroFactory, Interface Visitable, 
                Class Knight, Class Pyromancer, Class Rogue, Class Wizard;

- package abilities : Class Backstab, Class Deflect, Class Drain, Class Execute, 
                      Class Fireblast, Class Ignite, Class Paralysis, Class Slam, 
                      Interface Visitor;

- package game : Class Game;

- package constants : Class Constants.


In Classes GameInput and GameInputLoader I the data from file and I store the
fields specific to the game input(map, terrain, heros, moves, etc.).
In Class Main I implement the logic of the program. At every round, the heros
move on map. There is a fight between heros with the same positions, which 
modifies their features. At the end of the game, I print the Leaderboard.

Package heros contains the class Hero and also, classes for every type of hero, that
extends class Hero. Class HeroFactory has the role to return a new hero. 
Package abilities contains classes for every type of ability. In this classes 
I implement methods that can be applied to every type of hero.

Taking into account the interaction between heros and abilities, this is where 
I choose to use the concept of Double Dispatch. Considering that an ability is 
applied to a hero, every class that represents an ability implements Interface Visitor
and overwrites the 'visit' method and Class Hero implements interface Visitable and the
classes that extend it overwrite the 'accept' method. That means that every 
ability is applied to every hero(is visited) and every hero accepts the changes 
that the attack with that ability brings(the damage modifies the hp).

In Class Game I implement methods relevant to the game: increasing the number of
rounds, the fight, the changes applied on a hero's feature.

In Class Constants I declare constants that I use  in the project: 
heros' modifiers, bonuses, or other useful values.