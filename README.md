# Operation-Stand-To-by-RushHourLLC
Java, battlefield game

Project Team
* Devin B. (owner)
* Zakee T. (collaborator)
* Jimmy V. (collaborator)



Welcome to the Stand To!

This is a game where you distribute your Soldiers across the battlefield to attack and defends bases.
The player will choose 5 numbers which will equal to the amount of allotted Soldiers to be placed across the field.
The enemy who is computer generated will randomly generate 5 numbers to place in opposing positions.
The player will assign Soldiers which doesn't exceed the allotted amount across the battlefield.
The player with the most amount of Soldiers in the respective lane will keep their Soldiers and will be placed 
into their pool for the next battle. The difference of the respective attacks will be depleted from the loser base health.
This cycle will continue until an opponent has no Soldiers or no base health.

After each war you will be able to add Soldiers, Air Support, or add extra Health to your base.
Roll dice to get value for given choice. 
    -You can get 10 Soldiers
    -Air Support which will take 10 away from the opponents base health
    -You can get 10 points added to your base health

You will then go on to the next war and fight a more difficult opponent.


Concerns to Address:
**Can you frontload, i.e put all units onto one lane?

Should the damage to the base health be mitigated. 

Do users have to use all of their units? Its mentioned that the game is over once
one player loses all health OR loses all their units?  Yes, you need to use all of them.

Are units reset after each round? No

Do lanes get destroyed?  late implementation if possible 
- how is that implemented?
- Maybe a T/F variable

How does the store work in relationship to the board / game?  The store will be shown after each war. 
- how is that implemented?

What if there is a tie? It will be considered a loss and will need to replay the round.

In which order is the game won i.e is it left to right or is it at the end. If
I put all soldiers at the beginning and i do 80 dmg but the enemy does 80 throughout the other
lanes, then who wins? Calculated at the end and will be considered a tie. 

// code implementation
Will there be a prompter before the user puts units into the board? Yes
- [P]lace - [S]tore - ([S]tart)
Can the user change there input before the game starts or is it final?
Should maybe the user inputs the units one lane at a time. i.e I can choose
Lane 1 and put 10 units, get prompted for which lane next**
Allow user to input Soldiers to the specific lane and see the total adjust. The user will be able to change the amounts 
before starting the battle. 

