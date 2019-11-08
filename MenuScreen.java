import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;

// This class will manage the menu screen
public class MenuScreen extends BaseScreen
{
    // button variables
    private Button ExitButton;
    private Button SettingsButton;
    private Button PlayButton;
    private boolean ExitHover;
    private boolean PlayHover;
    private boolean SettingsHover;
    private boolean PlayToggle;
    private boolean ExitToggle;
    private boolean SettingsToggle;
    
    // Viewport variables
    private static int ViewportHeight;
    private static int ViewportWidth;
    
    // Background variables
    private BaseActor backgroundImage;
    private BaseActor gameTitle;
    private BaseActor swordTitle;
    
    public void initialize()
    {
        // Add background image
        backgroundImage = new BaseActor(0,0, mainStage);
        // Image found at https://wallpaperbro.com/purple-castle
        backgroundImage.loadTexture("Assets/Img/Menu/Background.jpg");
        backgroundImage.setSize(1600, 900);
        
        // Add game title
        gameTitle = new BaseActor(0,0, mainStage);
        gameTitle.loadTexture("Assets/Img/Menu/GameTitle-2.png");
        gameTitle.centerAtPosition(800, 450);
        gameTitle.moveBy(0, 300);
        
        // Add Sword into title
        swordTitle = new BaseActor(0, 0, mainStage);
        swordTitle.loadTexture("Assets/Img/Menu/Sword.png");  
        swordTitle.setSize(270, 270);
        swordTitle.centerAtPosition(960, 450);
        swordTitle.moveBy(0, 300);
        ;
            
        // Initialize button variables
        PlayHover = false;
        SettingsHover =  false;
        ExitHover =  false;
        PlayToggle =  false;
        SettingsToggle = false;
        ExitToggle = false;
        PlayButton = new Button(700,550,uiStage);
        PlayButton.loadTexture("Assets/Img/Buttons/Play_Unhighlighted.png");
        SettingsButton = new Button(700,400,uiStage);
        SettingsButton.loadTexture("Assets/Img/Buttons/Settings_Unhighlighted.png");
        ExitButton = new Button(700,250,uiStage);
        ExitButton.loadTexture("Assets/Img/Buttons/Exit_Unhighlighted.png");
        Pixmap pm = new Pixmap(Gdx.files.internal("Assets/Img/Cursors/CursorSword.png"));
        Gdx.graphics.setCursor(Gdx.graphics.newCursor(pm, 0, 0));
        pm.dispose();
        
        // Set screen to 1600 by 900
        ViewportHeight = 900;
        ViewportWidth = 1600;
    }
 
    public void update (float dt)
    {
           //Gdx.app.log("Mouse X location is ",Float.toString(Gdx.input.getX()));
           //Gdx.app.log("Mouse Y location is ",Float.toString(Gdx.input.getY()));
           ButtonManager();     
    }
    
    private void ButtonManager()
    {
        if (Gdx.input.getX() > 700 && Gdx.input.getX() < 900)
            {
                if (Gdx.input.getY() > 275.0f && Gdx.input.getY() < 350.0f)
                {
                    PlayHover = true;
                    if (PlayToggle == false)
                    {
                        PlayToggle = true;
                        //Gdx.app.log("Mouse X location is ",Float.toString(Gdx.input.getX()));
                        //Gdx.app.log("Mouse Y location is ",Float.toString(Gdx.input.getY()));
                        //Gdx.app.log("The Play Button is being hovered over",null);
                        PlayButton.remove();
                        PlayButton = new Button(700,550,uiStage);
                        PlayButton.loadTexture("Assets/Img/Buttons/Play_Highlighted.png");
                        
                   }
                   if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
                   {
                        //Gdx.app.log("Play Button Clicked",null);
                        /****************************************************************/
                        /********************This is where next scene is called**********/ 
                        
                        BaseGame.setActiveScreen(new GameScreen());
                        /***************************************************************/
                   }
                   
                }
                else
                {
                    PlayToggle =  false;
                    PlayHover = false;
                    PlayButton.remove();
                    PlayButton = new Button(700,550,uiStage);
                    PlayButton.loadTexture("Assets/Img/Buttons/Play_Unhighlighted.png");     
                }
                if (Gdx.input.getY() > 425.0f && Gdx.input.getY() < 500.0f)
                {
                    SettingsHover = true;
                    if (SettingsToggle == false)
                    {
                        SettingsToggle = true;
                        //Gdx.app.log("Mouse X location is ",Float.toString(Gdx.input.getX()));
                        //Gdx.app.log("Mouse Y location is ",Float.toString(Gdx.input.getY()));
                        //Gdx.app.log("The Play Button is being hovered over",null);
                        SettingsButton.remove();
                        SettingsButton = new Button(700,400,uiStage);
                        SettingsButton.loadTexture("Assets/Img/Buttons/Settings_Highlighted.png");
                    }
                     if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
                     {    
                         BaseGame.setActiveScreen( new SettingsScreen());
                         //Gdx.app.log("Settings Button Clicked",null);
                     }
                   
                }
                else
                {
                    SettingsToggle =  false;
                    SettingsHover = false;
                    SettingsButton.remove();
                    SettingsButton = new Button(700,400,uiStage);
                    SettingsButton.loadTexture("Assets/Img/Buttons/Settings_Unhighlighted.png");     
                }
                if (Gdx.input.getY() > 575.0f && Gdx.input.getY() < 650.0f)
                {
                    ExitHover = true;
                    if (ExitToggle == false)
                    {
                        ExitToggle = true;
                        //Gdx.app.log("Mouse X location is ",Float.toString(Gdx.input.getX()));
                        //Gdx.app.log("Mouse Y location is ",Float.toString(Gdx.input.getY()));
                        //Gdx.app.log("The Exit Button is being hovered over",null);
                        ExitButton.remove();
                        ExitButton = new Button(700,250,uiStage);
                        ExitButton.loadTexture("Assets/Img/Buttons/Exit_Highlighted.png");
                        
                        
                   }
                   if (Gdx.input.isButtonPressed(Input.Buttons.LEFT))
                   {
                        Gdx.app.log("Exit Button Clicked",null);
                        Gdx.app.exit();
                   }
                   
                }
                else
                {
                    ExitToggle =  false;
                    ExitHover = false;
                    ExitButton.remove();
                    ExitButton = new Button(700,250,uiStage);
                    ExitButton.loadTexture("Assets/Img/Buttons/Exit_Unhighlighted.png");     
                }
                //Gdx.app.log("The button  is being hovered over",null);
           }
           else
           {
               PlayToggle =  false;
               PlayHover = false;
               PlayButton.remove();
               PlayButton = new Button(700,550,uiStage);
               PlayButton.loadTexture("Assets/Img/Buttons/Play_Unhighlighted.png");
               SettingsToggle =  false;
               SettingsHover = false;
               SettingsButton.remove();
               SettingsButton = new Button(700,400,uiStage);
               SettingsButton.loadTexture("Assets/Img/Buttons/Settings_Unhighlighted.png"); 
               ExitToggle =  false;
               ExitHover = false;
               ExitButton.remove();
               ExitButton = new Button(700,250,uiStage);
               ExitButton.loadTexture("Assets/Img/Buttons/Exit_Unhighlighted.png");           
           }
            
    }
    
    
}