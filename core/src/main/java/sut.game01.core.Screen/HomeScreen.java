package sut.game01.core.Screen;


import playn.core.ImageLayer;
import playn.core.Image;
import playn.core.PlayN;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;
import static playn.core.PlayN.graphics;

public class HomeScreen extends UIScreen {

    private final ScreenStack ss;
    public HomeScreen(ScreenStack ss){
        this.ss = ss;
    }

    @Override
    public void wasShown(){
        super.wasShown();
        Image bgImage = PlayN.assets().getImage("images/bg.png");
        ImageLayer bgLayer = graphics().createImageLayer(bgImage);
        graphics().rootLayer().add(bgLayer);

        Image playImage = PlayN.assets().getImage("images/play.png");
        ImageLayer playLayer = graphics().createImageLayer(playImage);
        graphics().rootLayer().add(playLayer);
        playLayer.setTranslation(235,300);
    }
}