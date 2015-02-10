package com.sshsgd.pong;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.sshsgd.pong.managers.MyInput;
import com.sshsgd.pong.managers.MyInputProcessor;

public class Game extends ApplicationAdapter {
	
	public static Vector2 SIZE, CENTER;
	
	public float time;
	public int frames, fps;
	
	@Override
	public void create () {
		
		int width, height;
		width = Gdx.graphics.getWidth();
		height = Gdx.graphics.getHeight();
		SIZE = new Vector2(width, height);
		CENTER = new Vector2(width * .5f, height * .5f);
		time = 0;
		
		Gdx.input.setInputProcessor(new MyInputProcessor());
	}

	@Override
	public void resize(int width, int height) {
		Game.SIZE.set(width, height);
		Game.CENTER.set(width * .5f, height * .5f);
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		float dt = Gdx.graphics.getDeltaTime();
		frames++;
		time += dt;
		if(time >= 1){
			fps = frames;
			frames = 0;
			time = 0;
		}
		
		if(MyInput.isPressed(MyInput.UP))System.out.println("Up is down");
		
		Gdx.graphics.setTitle("Pong | " + fps + " fps");
		
		MyInput.update();
	}
}
