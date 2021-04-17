package model;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

import controller.Application;
import controller.menuController;
import view.imagesLoad;
import view.linearView;
import view.menuView;
import view.mixingView;
import view.powView;


public class Board extends JPanel implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static BoardEnum state = BoardEnum.MENU;
	
	public static int mouseX;
	public static int mouseY;
	
	private static String path1 = "";
	private static String path2 = "";
	
	private BufferedImage image;
	private Graphics2D g;
	
	private Color color_butt = new Color(221,238,229);
	private Color color_change = new Color(77,10,119);
	
	Timer mainTimer = new Timer(30,this);
	menuView menu;
	linearView line;
	mixingView mix;
	powView pow;
	
	public Board() {
		initBoard();
	}
	
	private void initBoard() {
         setFocusable(true);
         requestFocus();
         mainTimer.start();
         
         image = new BufferedImage(Application.WIDTH, Application.HEIGHT, BufferedImage.TYPE_INT_RGB);
         g = (Graphics2D) image.getGraphics();
         menu = new menuView();
         line = new linearView();
         mix = new mixingView();
         pow = new powView();
         
         addMouseListener(new menuController());
         addMouseMotionListener(new menuController());
	}
	
	private void draw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image,0,0,null);
		g2.dispose();
	}

	private void pasteButton(Button e) {
		if (mouseX > e.getX() && mouseX < e.getX()+e.getW() &&
				mouseY > e.getY() && mouseY < e.getY()+e.getH()) {
			if(e.equals(menu.menuButtons[0])) {
				e.color1 = color_change;
				e.s = "Liniowa";
				if (menuView.click) {
					state = BoardEnum.LINEAR;
					menuView.click = false;
				}
			}
			if(e.equals(menu.menuButtons[1])) {
				e.color1 = color_change;
				e.s = "Potegowy";
				if (menuView.click) {
					state = BoardEnum.POW;
					menuView.click = false;
				}
			}
			if(e.equals(menu.menuButtons[2])) {
				e.color1 = color_change;
				e.s = "Mieszany";
				if (menuView.click) {
					state = BoardEnum.MIXING;
					menuView.click = false;
				}
			}
			if(e.equals(menu.menuButtons[3])) {
				e.color1 = color_change;
				e.s = "Wyjœæ";
				if (menuView.click) {
					System.exit(0);
				}
			}
			if(e.equals(pow.powButtons[0])) {
				e.color1 = color_change;
				if (powView.click_p) {
					powModel.openPicture();
					powView.click_p = false;
				}
			}
			
			if(e.equals(pow.powButtons[1])) {
				e.color1 = color_change;
				if (powView.click_p) {
					if(!powModel.picturePathIsEmpty()) {
						questionFormPowModel.frame();
					}
					powView.click_p = false;
				}
			}
			if(e.equals(pow.powButtons[2])) { 
				e.color1 = color_change;
				if (powView.click_p) {
					state = BoardEnum.MENU;
					powView.click_p = false;
				}
			}
			
			if(e.equals(line.linearButtons[0])) {
				e.color1 = color_change;
				if (linearView.click_l) {
					linearModel.openPicture();
					linearView.click_l = false;
				}
			}
			
			if(e.equals(line.linearButtons[1])) {
				e.color1 = color_change;
				if (linearView.click_l) {
					linearModel.negative();
					linearView.click_l = false;
				}
			}
			if(e.equals(line.linearButtons[2])) {
				e.color1 = color_change;
				if (linearView.click_l) {
					if(!linearModel.picturePathIsEmpty()) {
						questionFormModel.frame(0, 255, 40, "light");
					}
					linearView.click_l = false;
				}
			}
			if(e.equals(line.linearButtons[3])) {
				e.color1 = color_change;
				if (linearView.click_l) {
					if(!linearModel.picturePathIsEmpty()) {
						questionFormModel.frame(-255, 0, 40, "dark");
					}
					linearView.click_l = false;
				}
			}
			
			if(e.equals(line.linearButtons[4])) {
				e.color1 = color_change;
				if (linearView.click_l) {
					state = BoardEnum.MENU;
					linearView.click_l = false;
				}
			}
			// mixing open image 1
			if(e.equals(mix.mainButtons[0])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.openPicture();
					path1 = mixingModel.getPicturePath();
					mixingView.click_m = false;
				}
			}
			// mixing open image 2
			if(e.equals(mix.mainButtons[1])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.openPicture();
					path2 = mixingModel.getPicturePath();
					mixingView.click_m = false;
				}
			}
			// Additive mode
			if(e.equals(mix.mixingButtons[0])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("add");
					mixingView.click_m = false;
				}
			}
			// Subtractive mode
			if(e.equals(mix.mixingButtons[1])) { //!!!
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("sub");
					mixingView.click_m = false;
				}
			}
			//Difference mode
			if(e.equals(mix.mixingButtons[2])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("roz");
					mixingView.click_m = false;
				}
			}
			// Multiply mode
			if(e.equals(mix.mixingButtons[3])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("mn");
					mixingView.click_m = false;
				}
			}
			// Screen mode
			if(e.equals(mix.mixingButtons[4])) { // !!!!
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("screen");
					mixingView.click_m = false;
				}
			}
			// Negation mode
			if(e.equals(mix.mixingButtons[5])) { // !!!!
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("negation");
					mixingView.click_m = false;
				}
			}
			// Darken mode
			if(e.equals(mix.mixingButtons[6])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("darken");
					mixingView.click_m = false;
				}
			}
			// Lighten mode
			if(e.equals(mix.mixingButtons[7])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("lighten");
					mixingView.click_m = false;
				}
			}
			// Exclusion mode
			if(e.equals(mix.mixingButtons[8])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("exclusion");
					mixingView.click_m = false;
				}
			}
			// Overlay mode
			if(e.equals(mix.mixingButtons[9])) { 
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("overlay");
					mixingView.click_m = false;
				}
			}
			// Hard light mode
			if(e.equals(mix.mixingButtons[10])) { // !!!!
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("hard_light");
					mixingView.click_m = false;
				}
			}
			// Soft light mode
			if(e.equals(mix.mixingButtons[11])) { 
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("soft_light");
					mixingView.click_m = false;
				}
			}
			// Color dodge mode
			if(e.equals(mix.mixingButtons[12])) { 
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("c_dodge");
					mixingView.click_m = false;
				}
			}
			// Color burn mode
			if(e.equals(mix.mixingButtons[13])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("color_burn");
					mixingView.click_m = false;
				}
			}
			// Reflect mode
			if(e.equals(mix.mixingButtons[14])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					mixingModel.chooseMode("reflect");
					mixingView.click_m = false;
				}
			}
			// Transparency, Opacity
			if(e.equals(mix.mixingButtons[15])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					questionFormPowModel.frame_op();
					mixingModel.chooseMode("opacity");
					mixingView.click_m = false;
				}
			}
			if(e.equals(mix.mainButtons[2])) {
				e.color1 = color_change;
				if (mixingView.click_m) {
					state = BoardEnum.MENU;
					mixingView.click_m = false;
				}
			}
		}
		else {
			if(e.equals(menu.menuButtons[0])) {e.color1 = color_butt; e.s = "Linear";}
			if(e.equals(menu.menuButtons[1])) {e.color1 = color_butt; e.s = "Pow";}
			if(e.equals(menu.menuButtons[2])) {e.color1 = color_butt; e.s = "Blend";}
			if(e.equals(menu.menuButtons[3])) {e.color1 = color_butt;e.s = "Exit";}
			for(int i = 0; i < line.linearButtons.length; i++) {
				if(e.equals(line.linearButtons[i])) {e.color1 = color_butt;}
			}
			for(int i = 0; i < mix.mixingButtons.length; i++) {
				if(e.equals(mix.mixingButtons[i])) {e.color1 = color_butt;}
			}
			for(int i = 0; i < mix.mainButtons.length; i++) {
				if(e.equals(mix.mainButtons[i])) {e.color1 = color_butt;}
			}
			for(int i = 0; i < pow.powButtons.length; i++) {
				if(e.equals(pow.powButtons[i])) {e.color1 = color_butt;}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (state.equals(BoardEnum.MENU)){
			menu.draw(g);
			draw();
			for(Button i:menu.menuButtons) {
				pasteButton(i);
			}
		}
        if (state.equals(BoardEnum.LINEAR)){
			line.draw(g);
			draw();
			for(Button i:line.linearButtons) {
				pasteButton(i);
			}
		}
        if (state.equals(BoardEnum.POW)){
			pow.draw(g);
			draw();
			for(Button i:pow.powButtons) {
				pasteButton(i);
			}
		}
        if (state.equals(BoardEnum.MIXING)){
			mix.draw(g);
			draw();
			for(Button i:mix.mixingButtons) {
				pasteButton(i);
			}
			for(Button i:mix.mainButtons) {
				pasteButton(i);
			}
		}
	}

	public static String getPath1() {
		return path1;
	}

	public static String getPath2() {
		return path2;
	}
	
}
