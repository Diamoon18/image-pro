package model;


import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class linearModel{
	
	 private static String picturePath ="";
	 static BufferedImage image;
	 static int width;
	 static int height;
	 static JFrame f;
	 	
	public static void openPicture() {
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        jfc.setDialogTitle("Select an image");
        jfc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG images", "jpg");
        jfc.addChoosableFileFilter(filter);

        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
        	picturePath = jfc.getSelectedFile().getPath();
            System.out.println(jfc.getSelectedFile().getPath());
        }
	}
	
	public static boolean picturePathIsEmpty() {
		return picturePath.isEmpty();
	}
	
	public static void negative() {
		try {
			 if(!picturePath.isEmpty()) {

				 File input = new File(picturePath);
				 image = ImageIO.read(input);
				 width = image.getWidth();
				 height = image.getHeight();
				 
				 for(int i = 0; i < height; i++){
					 for(int j = 0; j < width; j++){
						 Color c = new Color(image.getRGB(j, i));
						 int red = (int)(c.getRed());
						 int green = (int)(c.getGreen());
						 int blue = (int)(c.getBlue());
						 
						 int a = -1;
						 int b = 255;
						 int x, y, z;
						 x = 0;
						 y = 0;
						 z = 0;
						 
						 x = a*red+b;
						 y = a*green+b;
						 z = a*blue+b;

						 Color newColor = new Color(x, y, z);
						 image.setRGB(j,i,newColor.getRGB());
					 }
				 }
				 File ouptut = new File(picturePath.replace(".jpg", "_negative.jpg"));
				 ImageIO.write(image, "jpg", ouptut);
				 f = new JFrame();
				 JOptionPane.showMessageDialog(f, "Success!");
			 }
		} catch (Exception e) {}
	}
	
	public static void light(int valueOfB) {
		try {
				 File input = new File(picturePath);
				 image = ImageIO.read(input);
				 width = image.getWidth();
				 height = image.getHeight();
				 
				 for(int i = 0; i < height; i++){
					 for(int j = 0; j < width; j++){
						 Color c = new Color(image.getRGB(j, i));
						 int red = (int)(c.getRed());
						 int green = (int)(c.getGreen());
						 int blue = (int)(c.getBlue());
						 
						 int a = 1;
						 int b = valueOfB;
						 int x, y, z;
						 x = 0;
						 y = 0;
						 z = 0;
						 
						 x = a*red+b;
						 y = a*green+b;
						 z = a*blue+b;
						
						 if (x>255) {
							 x=255;
						 }else if (x < 0){
							 x=0;
						 }
						 if (y>255) {
							 y=255;
						 }else if (y < 0){
							 y=0;
						 }
						 if (z>255) {
							 z=255;
						 }else if (z < 0){
							 z=0;
						 }

						 Color newColor = new Color(x, y, z);
						 image.setRGB(j,i,newColor.getRGB());
					 }
				 }
				 File ouptut = new File(picturePath.replace(".jpg", "_light.jpg"));
				 ImageIO.write(image, "jpg", ouptut);
			
		} catch (Exception e) {}
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "Success!");
	}

	public static void dark(int valueOfB) {
		try {
			     File input = new File(picturePath);
				 image = ImageIO.read(input);
				 width = image.getWidth();
				 height = image.getHeight();
				 
				 for(int i = 0; i < height; i++){
					 for(int j = 0; j < width; j++){
						 Color c = new Color(image.getRGB(j, i));
						 int red = (int)(c.getRed());
						 int green = (int)(c.getGreen());
						 int blue = (int)(c.getBlue());
						 
						 int a = 1;
						 int b = valueOfB;
						 int x, y, z;
						 x = 0;
						 y = 0;
						 z = 0;
						 
						 x = a*red+b;
						 y = a*green+b;
						 z = a*blue+b;

						 if (x>255) {
							 x=255;
						 }else if (x < 0){
							 x=0;
						 }
						 if (y>255) {
							 y=255;
						 }else if (y < 0){
							 y=0;
						 }
						 if (z>255) {
							 z=255;
						 }else if (z < 0){
							 z=0;
						 }
						 
						 Color newColor = new Color(x, y, z);
						 image.setRGB(j,i,newColor.getRGB());
					 }
				 }
				 File ouptut = new File(picturePath.replace(".jpg", "_dark.jpg"));
				 ImageIO.write(image, "jpg", ouptut);
			 
		} catch (Exception e) {}
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "Success!");
	}
	
	public static String getPicturePath() {
		return picturePath;
	}

	public static void setPicturePath(String picturePath) {
		linearModel.picturePath = picturePath;
	}


}
