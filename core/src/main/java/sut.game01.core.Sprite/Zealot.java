package sut.game01.core.Sprite;

import playn.core.Layer;
import playn.core.PlayN;
import playn.core.Pointer;
import playn.core.util.Callback;

/**
 * Created by all user on 28/1/2557.
 */
public class Zealot {

    private Sprite sprite;
    private int spriteIndex = 0;
    private boolean hassLoaded = false;

    public Layer layer() {
        return sprite.layer();
    }

    public enum State{
        IDLE, RUN, ATTK
    };

    private State state = State.IDLE;

    private int e = 0;
    private int offset = 0;

    public Zealot(final float x, final float y){
        this.sprite = SpriteLoader.getSprite("images/zealot.json");
        this.sprite.addCallback(new Callback<Sprite>() {
            @Override
            public void onSuccess(Sprite result) {
                sprite.setSprite(spriteIndex);
                sprite.layer().setOrigin(sprite.width()/2f,sprite.height()/2f);
                sprite.layer().setTranslation(x,y);
                hassLoaded = true;
            }

            @Override
            public void onFailure(Throwable cause) {
                PlayN.log().error("ERROR loading image!", cause);
            }
        });
        this.sprite.layer().addListener(new Pointer.Adapter(){
            @Override
            public void onPointerEnd(Pointer.Event event){
                state = State.ATTK;
                spriteIndex = -1;
                e = 0;
            }
        });
    }
}
