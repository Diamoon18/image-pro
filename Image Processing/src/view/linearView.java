package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import controller.Application;
import model.Button;
import model.linearModel;

public class linearView{
	
	public static boolean click_l = false;
	
    
	public Button [] linearButtons = {new Button(0, 50, 255, 25,""), new Button(140, 130, 200, 50, "Negative"), new Button(140, 190, 200, 50, "Light"),
			new Button(140, 250, 200, 50, "Dark"), new Button(260, 410, 200, 20, "")};
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
        g2d.setColor(new Color(154, 154, 210));
        g2d.fillRect(0, 0, Application.WIDTH, Application.HEIGHT);
        
        Font f = new Font("Didot",Font.ITALIC, 20);
		g2d.setFont(f);
		g2d.setColor(new Color(221,238,229));
		g2d.drawString("Choose image", 120, 45);
		g2d.drawString("MENU", 180, 428);
		g2d.drawString("Choose mode", 215, 120);
        
		g2d.drawImage(imagesLoad.img2, 5, 230, null);
		
        for (Button i :linearButtons) {
        	i.setSizeF(35);
			i.draw(g2d);
		}
        
        g2d.drawImage(imagesLoad.img3, 40, 10, null);
        
        if (!linearModel.getPicturePath().isEmpty()) {
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
