package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Button{
	private int x;
	private int y;
	private int w;
	private int h;
	private Color fontColor;
	public Color color1;
	private int sizeFont;

	public String s;
	
	public Button(int x, int y, int w, int h, String s){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.s = s;
		color1 = new Color(221,238,229);
		fontColor = new Color(154, 154, 210);
	}

	public int getX() { return x; }
	public int getY() { return y; }
	public int getW() { return w; }
	public int getH() { return h; }
	
	public void setW(int w) { this.w = w; }
	public void setH(int h) { this.h = h; }
	
	public void setFontColor(Color fontColor) { this.fontColor = fontColor; }
	
	public void draw(Graphics2D g) {
		g.drawRect(x, y, w, h);
		g.setColor(color1);
		g.fillRect(x, y, w, h);
		
		Font font = new Font("Arial", Font.ITALIC, sizeFont);
		g.setFont(font);
		g.setColor(fontColor);
		g.drawString(s, x+sizeFont, y+sizeFont);
	}

	public int getSizeF() {
		return sizeFont;
	}

	public void setSizeF(int sizeFont) {
		this.sizeFont = sizeFont;
	}
}
