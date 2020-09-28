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
- [ONGOING] Exhaustive Testing
- [COMPLETE] Javadoc Documentation

### Compiling the GUI Game
- Use the GUI Version of the game, which is in MCO2.
#### Prerequisites
>   JavaFX 11 must be installed in your system!
#### Compiling
Your installation to JavaFX must be defined as a PATH variable.
If not, perform (WINDOWS CMD): (don't forget to replace the placeholder to the path to your JavaFX installation's lib folder)
>   set PATH_TO_FX="path\to\javafx-sdk-11\lib"

To compile the source, perform the following (in the program root directory /src):
>   javac --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml thatslife/\*.java controllers/\*.java

### Running the GUI Game
To run the game, perform the follwing:
>   java --module-path %PATH_TO_FX% --add-modules javafx.controls,javafx.fxml thatslife.GUIMain

### Starting Up the Game (CLI)
- Use the CLI Version of the game, which in MCO1.
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