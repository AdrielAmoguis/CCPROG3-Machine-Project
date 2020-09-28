# CCPROG3 Machine Project
That's Life! - A Mirror of the Boardgame, "The Game of Life"

#### Authored by Adriel Isaiah V. Amoguis
- for the CCPROG3 course
#### Professor: Shirley B. Chu

## MCO2 Tracker
- [COMPLETE] Update UML Class Diagram (corrects & extra features)
- [COMPLETE] Develop Extra Features
- [COMPLETE] Have the MVC Architecture for GUI Implementation
    - [COMPLETE] Develop the View
        - [COMPLETE] Main Menu
        - [COMPLETE] Game Menu
        - [COMPLETE] Main Playing Window
        - [COMPLETE] Game Elements
    - [COMPLETE] Develop/Debug the Model
        - [COMPLETE] Verify all Classes and Specs are Correct
    - [COMPLETE] Develop the Controllers
        - [COMPLETE] Button Controllers
    - [COMPLETE] Integrate the View and Controllers to the Model
- [INCOMPLETE] Exhaustive Testing
- [INCOMPLETE] Javadoc Documentation

### Compiling the GUI Game


### Starting Up the Game (CLI)
- The Main driver class takes some arguments when starting the game.
- According to the Javadoc, here are the arguments:

>   This method drives the game to run, using a Command-Line Interface (CLI).
>   This driver method needs startup arguments to run. Refer to those below:
>   REQUIRED ARGS (must be the first argument):
>   - Number of players (int): Example execution: "java Main 2" = 2 players
>   OPTIONAL ARGS:
>    - "showactioncards" = Shows the action cards upon generation
>    - "showcareercards" = Shows the career cards upon generation
>    - "showsalarycards" = Shows the salary cards upon generation
>    - "nomap" = inhibits map display per turn
>    - "norng" = Runs the game without the use of RNG. The user inputs a value every time.
>    Multiple arguments may be used at the same time.
>    Parameters:
>    args - - String[]