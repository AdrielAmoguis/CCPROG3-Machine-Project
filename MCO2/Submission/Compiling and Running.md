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