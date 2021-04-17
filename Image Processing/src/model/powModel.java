package model;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class powModel {
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
	
	public static void potega(double valueOfB) {
		try {
			 if(!picturePath.isEmpty()) {
				 File input = new File(picturePath);
				 image = ImageIO.read(input);
				 width = image.getWidth();
				 height = image.getHeight();
				 
				 
				 for(int i = 0; i < height; i++){
					 for(int j = 0; j < width; j++){
						 Color c = new Color(image.getRGB(j, i));
						 double red = (int)(c.getRed());
						 double green = (int)(c.getGreen());
						 double blue = (int)(c.getBlue());
						 
						 double potega = valueOfB;
						 double x, y, z;
						 x = 0;
						 y = 0;
						 z = 0;
						 
						 x = (255 * Math.pow(red/255, potega));
						 y = (255 * Math.pow(green/255, potega));
						 z = (255 * Math.pow(blue/255, potega));
						
						
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

						 Color newColor = new Color((int)x, (int)y, (int)z);
						 image.setRGB(j,i,newColor.getRGB());
					 }
				 }
				 File ouptut = new File(picturePath.replace(".jpg", "_potega.jpg"));
				 ImageIO.write(image, "jpg", ouptut);
			 }
		} catch (Exception e) {}
		f = new JFrame();
		JOptionPane.showMessageDialog(f, "Success!");
	}
	
	public static boolean picturePathIsEmpty() {
		return picturePath.isEmpty();
	}
	
	public static String getPicturePath() {
		return picturePath;
	}
}
