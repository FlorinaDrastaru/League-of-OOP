Drastaru Florina Cristina 325CA

League of OOP is a java project that implements a minimalist version of 

Implementation

The project is organised in several packages and classes:

- package main : Class Main, Class GameInput, GameInputLoader

- package heros : Class Hero, Class HeroFactory, Interface Visitable, 
                Class Knight, Class Pyromancer, Class Rogue, Class Wizard

- package abilities : Class Backstab, Class Deflect, Class Drain, Class Execute, 
                      Class FIreblast, Class Ignite, Class Paralysis, Class Slam, 
                      Interface Visitor.

- package game : Class Game

- package constants : Class Constants


In Classes GameInput and GameInputLoader I realize the read of the data from file and in
Class Main I implement the logic of the program.

Package heros contains classes for every type of hero and package abilities contains classes
for every type of ability. 
Taking into account the interaction between heros and abilities, this is where I chose to use
the concept of Double Dispatch. 