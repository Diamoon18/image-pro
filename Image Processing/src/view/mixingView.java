package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import controller.Application;
import model.Board;
import model.Button;
import model.linearModel;

public class mixingView {
	
	public static boolean click_m = false;
	
	public Button [] mixingButtons = {new Button(20, 140, 150, 25,"Additive"), new Button(20, 175, 150, 25,"Subtractive"), new Button(20, 210, 150, 25,"Difference"),
			new Button(20, 245, 150, 25,"Multiply"), new Button(20, 280, 150, 25,"Screen"), 
			new Button(20, 315, 150, 25,"Negation"), new Button(20, 350, 150, 25,"Darken"), 
			new Button(20, 385, 150, 25,"Lighten"),
			new Button(200, 140, 150, 25,"Exclusion"), new Button(200, 175, 150, 25,"Overlay"), new Button(200, 210, 150, 25,"Hard light"),
			new Button(200, 245, 150, 25,"Soft light"), new Button(200, 280, 150, 25,"Color dodge"), 
			new Button(200, 315, 150, 25,"Color burn"), new Button(200, 350, 150, 25,"Reflect"), 
			new Button(200, 385, 150, 25,"Opacity")};
	public Button [] mainButtons = {new Button(0, 50, 255, 25,""), new Button(100, 90, 255, 25,""), new Button(260, 420, 200, 20, "")};
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setColor(new Color(154, 154, 210));
        g2d.fillRect(0, 0, Application.WIDTH, Application.HEIGHT);
        
        Font f = new Font("Didot",Font.ITALIC, 20);
		g2d.setFont(f);
		g2d.setColor(new Color(221,238,229));
		g2d.drawString("Choose two images", 120, 45);
		g2d.drawString("MENU", 180, 438);
		g2d.drawString("Choose mode", 20, 135);
		
		for (Button i :mainButtons) {
			i.draw(g2d);
		}
		
		if (!Board.getPath1().isEmpty() && !Board.getPath2().isEmpty()) {
			for (Button i :mixingButtons) {
				i.setSizeF(17);
				i.draw(g2d);
			}
		}
		
		
        g2d.drawImage(imagesLoad.img3, 40, 10, null);
        g2d.drawImage(imagesLoad.img3, 240, 50, null);
        
        g2d.setColor(new Color(221,238,229));
		g2d.fillRect(0, 430, 400, 1);
		
        g2d.drawImage(imagesLoad.home, 300, 400, null);
        
    }
}
