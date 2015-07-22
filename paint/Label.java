package paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Label extends PaintComponent {

	private String text;
	private Color color = Color.WHITE;
	private Font font = null;
	
	public Label(int xPos, int yPos, String Text) {
		super(xPos, yPos, 1, 1);
		text = Text;
	}
	
	public Label(int xPos, int yPos, String Text, Color c) {
		super(xPos, yPos, 1, 1);
		text = Text;
		color = c;
	}
	
	public Label(int xPos, int yPos, String Text, Color c, Font f) {
		super(xPos, yPos, 1, 1);
		text = Text;
		color = c;
		font = f;
	}
	@Override
	public void onDraw(Graphics2D g) {
		if (w == 1 || h == 1) {
			Rectangle rect = getStringBounds(g, text, x, y, font);
			w = rect.width;
			h = rect.height;
		}
		g.setFont(font);
		g.setColor(color);
		g.drawString(text, x, y);
		g.setColor(Color.WHITE);
		
	}

	@Override
	public void onUpdate(Paint parent) {
		if (font == null) {
			font = parent.getButtonFont();
		}
	}
	
	public void setText(String t) {
		text = t;
		w = h = 1;
	}

}
