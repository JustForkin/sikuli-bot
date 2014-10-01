package org.sikuli.bot;

import java.awt.Point;
import java.util.Vector;

import org.sikuli.api.ScreenLocation;
import org.sikuli.api.robot.Mouse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AndroidMouse implements Mouse {
	
	Logger log = LoggerFactory.getLogger(AndroidMouse.class);
	
	private Makerbot makerbot;
	private GCodeGeneratorII generator;
	private Point prevPoint = null;
	
	public AndroidMouse(Makerbot bot){
		this.makerbot = bot;
		Point origin = new Point(60, 60);
		int screenWidthmm = 218;
		int screenHeightmm = 136;
		generator = new GCodeGeneratorII(origin, screenWidthmm, screenHeightmm, 3, ".");

	}

	@Override
	public void drag(ScreenLocation screenLoc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drop(ScreenLocation screenLoc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void click(ScreenLocation screenLoc) {		
		int x = 800 - (800 *screenLoc.getX() / 1280);
		int y = 600 * screenLoc.getY() / 800;
		
		log.info("execute click at ({},{})", x, y);
		
		Point clickPoint = new Point(x,y);		
		Vector<String> code = generator.createClickVector(clickPoint, prevPoint);
		prevPoint = clickPoint;
		try {
			if (makerbot != null)
				makerbot.execute(code);
		} catch (MakerbotException e) {
			log.error("click():" + e);
		}		
	}

	@Override
	public void rightClick(ScreenLocation screenLoc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void doubleClick(ScreenLocation screenLoc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void hover(ScreenLocation screenLoc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void move(ScreenLocation screenLoc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void press() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightPress() {
		// TODO Auto-generated method stub

	}

	@Override
	public void release() {
		// TODO Auto-generated method stub

	}

	@Override
	public void rightRelease() {
		// TODO Auto-generated method stub

	}

	@Override
	public void wheel(int direction, int steps) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDown(int buttons) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseUp() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseUp(int buttons) {
		// TODO Auto-generated method stub

	}

	@Override
	public ScreenLocation getLocation() {
		// TODO Auto-generated method stub
		return null;
	}

}