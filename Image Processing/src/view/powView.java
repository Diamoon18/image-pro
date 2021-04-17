package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import controller.Application;
import model.Button;
import model.linearModel;
import model.powModel;

public class powView {
	
	public static boolean click_p = false;
	
	public Button [] powButtons = {new Button(0, 50, 255, 25,""), new Button(140, 190, 200, 50,"Pow"), new Button(260, 410, 200, 20, "")};
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setColor(new Color(154, 154, 210));
        g2d.fillRect(0, 0, Application.WIDTH, Application.HEIGHT);
        
        Font f = new Font("Didot",Font.ITALIC, 20);
		g2d.setFont(f);
		g2d.setColor(new Color(221,238,229));
		g2d.drawString("Choose image", 120, 45);
		g2d.drawString("MENU", 180, 428);
		
		g2d.drawImage(imagesLoad.img, 80, 200, null);
		g2d.drawImage(imagesLoad.img1, 180, 20, null);
		
		g2d.setColor(Color.ORANGE);
		g2d.fillOval(30, 100, 50, 50);
		g2d.setColor(new Color(154, 154, 210));
		g2d.fillOval(35, 90, 50, 50);
		
		for (Button i :powButtons) {
			i.setSizeF(35);
			i.draw(g2d);
		}
		
        g2d.drawImage(imagesLoad.img3, 40, 10, null);
        
        if (!powModel.getPicturePath().isEmpty()) {
        	Font font = new Font("Didot",Font.BOLD, 20);
    		g2d.setFont(font);
    		g2d.setColor(new Color(221,238,229));
    		g2d.drawString("Okej", 270, 70);
		}
       
        g2d.setColor(new Color(221,238,229));
		g2d.fillRect(0, 420, 400, 1);
		
        g2d.drawImage(imagesLoad.home, 300, 390, null);
        
    }
}
