package paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

public class Button extends PaintComponent {

	private Point mousePosition;
	private boolean hover, clicked;
	private boolean textOnly;
	
	private Color Basic = Color.WHITE;
	private Color Hover = Color.BLUE;
	private Font font;
	private String text;
	public boolean toggle = true;
	public boolean toggleState = false;
	
	public Button(int xPos, int yPos, int width, int height) {
		super(xPos, yPos, width, height);
		text = "";
	}
	
	public Button(int xPos, int yPos, String Text) {
		super(xPos, yPos, 1, 1);
		text = Text;
		textOnly = true;
	}
	
	

	@Override
	public void onDraw(Graphics2D g) {
		g.setFont(font);
		if (textOnly && (w == 1 || h == 1)) {
			Rectangle rect = getStringBounds(g, text, x, y, font);
			h = rect.height;
			w = rect.width;
			r = rect;
		}
		if (!textOnly || text.isEmpty()) { //draw only a button
			
		}
		else if (textOnly) {
			if (!hover && !clicked) {
					g.setColor(Basic);
					g.drawString(text, x, y);
					g.setColor(Color.WHITE);
			}
			else {
				if (clicked) {
					g.setColor(Color.BLACK);
					g.drawString(text, x + 1, y + 1);
					g.setColor(Color.WHITE);
				}
				if (hover) {
					g.setColor(Hover);
					g.drawString(text, x, y);
					g.setColor(Color.WHITE);
				}
			}
		}
		else { //draw text on top of button
			
		}
	}

	@Override
	public void onUpdate(Paint parent) {
		mousePosition = parent.getMousePosition();
		hover = contains(mousePosition);
		clicked = contains(parent.getClickPosition());
		font = parent.getButtonFont();
		//parent.script.log(mousePosition);
	}
	
	public void onClick(Paint parent) {
		if (toggle && !toggleState || !toggle) {
			parent.script.log("Clicked :D");
			if (toggle) toggleState = true;
		}
	}
	
	public boolean isClicked() {
		return clicked;
	}

}
