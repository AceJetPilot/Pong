package com.sshsgd.pong.managers;

import java.util.HashMap;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Content {
	
	private HashMap<String, Music> music;
	private HashMap<String, Sound> sound;
	private HashMap<String, BitmapFont> font;
	
	public Content(){
		music = new HashMap<String, Music>();
		sound = new HashMap<String, Sound>();
		font = new HashMap<String, BitmapFont>();
	}
	
	public void loadMusic(String folder, String path, String key, boolean looping){
		Music m = Gdx.audio.newMusic(Gdx.files.internal(folder + "/" + path));
		m.setLooping(looping);
		music.put(key,  m);
	}
	
	public Music getMusic(String key){
		return music.get(key);
	}
	
	public void setVolumeAll(float vol){
		for(Object o : music.values()){
			Music music = (Music) o;
			music.setVolume(vol);
		}
	}
	
	public void loadSound(String folder, String path, String key){
		Sound s = Gdx.audio.newSound(Gdx.files.internal(folder + "/" + path));
	}
	
	public Sound getSound(String key){
		return sound.get(key);
	}
	
	public void loadBitmapFont(String folder, String path, String key, int size, Color color){
		FreeTypeFontGenerator gen = new FreeTypeFontGenerator(Gdx.files.internal(folder + "/" + path));
		@SuppressWarnings("deprecation")
		BitmapFont bmf = gen.generateFont(size);
		font.put(key,  bmf);
	}
	
	public BitmapFont getFont(String key){
		return font.get(key);
	}
	
	public void removeAll(){
		for(Object o: music.values()){
			Music m = (Music) o;
			m.dispose();
		}
		for(Object o: sound.values()){
			Music m = (Music) o;
			m.dispose();
		}
		for(Object o: font.values()){
			BitmapFont bmf = (BitmapFont) o;
			bmf.dispose();
		}
	}
	

}
