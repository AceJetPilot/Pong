package com.sshsgd.pong;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;

public class MyCamera extends OrthographicCamera {

	public MyCamera() {
		super();
	}

	public MyCamera(float viewportWidth, float viewportHeight) {
		super(viewportWidth, viewportHeight);
		// TODO Auto-generated constructor stub
	}
	
	public MyCamera(Vector2 viewport){
		super(viewport.x, viewport.y);
	}
	
	public boolean inView(float x, float y){
		float leftX, rightX, bottom, top;
		leftX = this.position.x - (this.viewportWidth * .5f);
		rightX = this.position.x + (this.viewportWidth * .5f);
		top = this.position.y + (this.viewportHeight * .5f);
		bottom = this.position.y - (this.viewportHeight * .5f);
		return (((x >leftX) && (x < rightX)) && ((y < top) && (y > bottom)));
	}
	
	public boolean inVeiw(Vector2 point){
		return inView(point.x, point.y);
	}
	
	public void resize(Vector2 size, boolean center){
		this.viewportWidth = size.x;
		this.viewportHeight = size.y;
		if(center) this.position.set(size.x * .5f, size.y * .5f, 0);
		this.update();
	}
	

}
