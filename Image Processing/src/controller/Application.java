package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;

import model.Board;
import view.imagesLoad;


public class Application extends JFrame {
	
	private static final long serialVersionUID = 1L;
	public final static int WIDTH = 400;
	public final static int HEIGHT = 500;
	
    
    public Application() {
    	initUI();
    }

    private void initUI() {
    	 add(new Board());

         setSize(WIDTH, HEIGHT);

         setTitle("IMAGE~PRO");
         setIconImage(imagesLoad.icon.getImage());
         
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setResizable(false);
         setLocationRelativeTo(null);
       
    }    
    
    public static void main(String[] args) {
    	
    	 EventQueue.invokeLater(() -> {
             Application ex = new Application();
             ex.setVisible(true);
         });
       
    }
}
