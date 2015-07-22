package paint;

import PaintTest.Main;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Paint implements MouseListener, MouseMotionListener {

	public Main script;
	private Point mousePos = new Point(-1, -1);
	private Point clickPos = new Point(-1, -1);
	private List<PaintComponent> list = new ArrayList<PaintComponent>();
	
	public Paint(Main m) {
		script = m;
	}
	
	public Point getMousePosition() {
		return mousePos;
	}
	
	public Font getButtonFont() {
		Font f = new Font("Open Sans", Font.PLAIN, 24);
		return f;
	}
	
	public Point getClickPosition() {
		return clickPos;
	}
	
	public void update() {
		for (PaintComponent pc : list) {
			pc.update(this);
			if (pc instanceof Button && ((Button) pc).isClicked()) {
				((Button) pc).onClick(this);
			}
		}
	}
	
	public void unToggleButtons() {
		for (PaintComponent pc : list) {
			if (pc instanceof Button) {
				Button b = (Button) pc;
				if (b.enabled && b.toggle && b.toggleState) b.toggleState = false;
			}
		}
	}
	
	public void draw(Graphics2D g) {
		for (PaintComponent pc : list) {
			pc.draw(g);
		}
	}
	
	public void add(PaintComponent p) {
		list.add(p);
	}
	
	public BufferedImage toBufferedImage(Image img)
	{
	    if (img instanceof BufferedImage)
	    {
	        return (BufferedImage) img;
	    }

	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();

	    // Return the buffered image
	    return bimage;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) { }

	@Override
	public void mouseExited(MouseEvent arg0) { }

	@Override
	public void mousePressed(MouseEvent e) {
		clickPos = e.getPoint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		clickPos = null;
		unToggleButtons();
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePos = e.getPoint();
	}
	
}
