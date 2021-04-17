package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;


import controller.Application;
import model.Button;

public class menuView {
	
	public static boolean click = false;
	
	public Button [] menuButtons = {new Button(0, 215, 250, 45,"Linear"), new Button(0, 270, 250, 45, "Pow"), new Button(0, 325, 250, 45, "Blend"), 
			new Button(0, 380, 250, 45, "Exit")};
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setColor(new Color(154, 154, 210));
        g2d.fillRect(0, 0, Application.WIDTH, Application.HEIGHT);
        
        g2d.drawImage(imagesLoad.img, 10, 10, null);
        g2d.drawImage(imagesLoad.img1, 150, 20, null);
        
        Font font = new Font("Didot",Font.BOLD, 40);
		g2d.setFont(font);
		g2d.setColor(new Color(221,238,229));
		g2d.drawString("IMAGE", 60, 150);
		g2d.drawString("PROCESSING", 60, 200);
		
		for (Button i :menuButtons) {
			i.setSizeF(35);
			i.draw(g2d);
		}
		
		g2d.setColor(new Color(221,238,229));
		g2d.fillRect(0, 440, 400, 1);	
		
	}
}
