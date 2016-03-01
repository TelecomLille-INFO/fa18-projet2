package fr.telecom.durifgame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import fr.telecom.durifgame.player.Player;

public class DurifGame extends ApplicationAdapter {
	
	private Map map ;
    private Camera cam;
    private KeyListener kListener;
    private Player player;
    private Music music;
    
	//----------------------------------------------//
    //-create										//
    //-Constructeur									//
    //----------------------------------------------//
	@Override
	public void create () {
		cam = new Camera();
        map = new Map("exemple.tmx");
        player = new Player("soldier.png",cam);
        music = new Music("lost-in-the-meadows.ogg");
        kListener = new KeyListener(cam, map, player,music);
        
	}

	//-----------------------------------------------//
    //-render										 //
    //-----------------------------------------------//
	@Override
	public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        kListener.keyPressed();
        cam.update();
        map.setView(cam);
        map.render();
        player.displayPlayer();
	}
	
	//-----------------------------------------------//
    //-dispose										 //
    //-----------------------------------------------//
    @Override
    public void dispose() {
    	if(map != null)
    		map.dispose();
    	if(music != null)
    		music.dispose();
    	
    }
    
	public Music getMusic() {
		return music;
	}

}
