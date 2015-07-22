# PaintLib
A simple and advanced paint library for OSBot.

# Setup
Add this in your main class:
<pre>
Paint p = new Paint(this);
</pre>

Add this to your onStart:
<pre>
getBot().getCanvas().addMouseListener(p);
getBot().getCanvas().addMouseMotionListener(p);
</pre>

In your onPaint:
<pre>
p.update();
p.draw(Graphics2D object);
</pre>

# Adding components
Button:
<pre>
p.add(new Button(x, y, "This is my button!"));
</pre>

Label:
<pre>
p.add(new Label(x, y, "This is my label!"));
</pre>

DynamicLabel:
<pre>
p.add(new DynamicLabel(x, y, "I don't need to set this") {
	
	@Override
	public void onUpdate(Paint parent) {
		setText("This is my cool label!");
	}

});
</pre>

Picture:
<pre>
p.add(new Picture(x, y, BufferedImage object));
</pre>

Orb:
<pre>
p.add(new Orb(x, y, width, height, "My cool orb!", BufferedImage object));
</pre>

DynamicOrb:
<pre>
DynamicLabel dl = new DynamicLabel(-1, -1, "I don't need to set this") {
	
	@Override
	public void onUpdate(Paint parent) {
		setText("This is my cool label!");
	}
	
};
p.add(new DynamicOrb(x, y, dl, new Picture(x, y, BufferedImage object)));
</pre>

<b>Enjoy!</b>