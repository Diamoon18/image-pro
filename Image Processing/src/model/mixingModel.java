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

public class mixingModel {
	 private static String picturePath="";
	 static BufferedImage image1, image2;
	 static int width;
	 static int height;
	 static JFrame f;
	 static String state;
	 	
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
	
	public static String getPicturePath() {
		return picturePath;
	}

	public static void setPicturePath(String picturePath) {
		mixingModel.picturePath = picturePath;
	}
	
	public static void chooseMode(String mode) {
		try {
				 state =  mode;
				 File input1 = new File(Board.getPath1());
				 image1 = ImageIO.read(input1);
				 width = image1.getWidth();
				 height = image1.getHeight();
 
				 File input2 = new File(Board.getPath2());
				 image2 = ImageIO.read(input2);
				 width = image2.getWidth();
				 height = image2.getHeight();
				 
				 for(int i = 0; i < height; i++){
					 for(int j = 0; j < width; j++){
						 Color c1 = new Color(image1.getRGB(j, i));
						 double red1 = (double)(c1.getRed());
						 double green1 = (double)(c1.getGreen());
						 double blue1 = (double)(c1.getBlue());
						 
						 Color c2 = new Color(image2.getRGB(j, i));
						 double red2 = (double)(c2.getRed());
						 double green2 = (double)(c2.getGreen());
						 double blue2 = (double)(c2.getBlue());
						 
						 double x, y, z;
						 x = 0;
						 y = 0;
						 z = 0;
						 
						 switch(state) {
						 	case "add":
						 		 x = red1+red2;
								 y = green1+green2;
								 z = blue1+blue2;
								 
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
								 
						 		break;
						 	case "sub": 
						 		 x = red1/255+red2/255-1;
								 y = green1/255+green2/255-1;
								 z = blue1/255+blue2/255-1;
								 
								 if (x < 0) {
									 x = 0;
								 }else{
									 x = x*255;
								 }
								 if (y < 0) {
									 y = 0;
								 }else{
									 y = y*255;
								 }
								 if (z < 0) {
									 z = 0;
								 }else{
									 z = z*255;
								 }
						 		break;
						 	case "roz":
						 		 x = Math.abs(red1-red2);
								 y = Math.abs(green1-green2);
								 z = Math.abs(blue1-blue2);
								 
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
								 
						 		break;
						 	case "mn":
						 		 x = (red1*red2)/255;
								 y = (green1*green2)/255;
								 z = (blue1*blue2)/255;
								 
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
								 
						 		break;
						 	case "screen":
						 		 x = (1 - (1 -red1/255)*(1-red2/255))*255;
								 y = (1 - (1 -green1/255)*(1-green2/255))*255;
								 z = (1 - (1 -blue1/255)*(1-blue2/255))*255;
								 
								 if(x > 255) {
									 x = 255;
								 }else if (x < 0) {
									 x=0;
								 }
								 if(y > 255) {
									 y = 255;
								 }else  if (y < 0) {
									 y=0;
									
								 }
								 if(z > 255) {
									 z = 255;
								 }else if (z < 0) {
									 z=0;
									 
								 }
								 
						 		break;
						 	case "negation": 
						 		 x = 1 - Math.abs(1 - red1/255 - red2/255);
								 y = 1 - Math.abs(1 - green1/255 - green2/255);
								 z = 1 - Math.abs(1 - blue1/255 - blue2/255);
								 System.out.println(x + "" + y + "" + z);
								 
								 if(x*255 > 255) {
									 x = 255;
								 }else {
									 x = x * 255;
								 }
								 if(y*255 > 255) {
									 y = 255;
								 }else {
									 y = y * 255;
								 }
								 if(z*255 > 255) {
									 z = 255;
								 }else {
									 z = z * 255;
								 }
						 		break;
						 		
						 	case "darken":
						 		if(red1 < red2) {
						 			x = red1;
						 		}else {
						 			x = red2;
						 		}
						 		if(green1 < green2) {
						 			y = green1;
						 		}else {
						 			y = green2;
						 		}
						 		if(blue1 < blue2) {
						 			z = blue1;
						 		}else {
						 			z = blue2;
						 		}
						 		
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
								 
						 		break;
						 	case "lighten":
						 		if(red1 > red2) {
						 			x = red1;
						 		}else {
						 			x = red2;
						 		}
						 		if(green1 > green2) {
						 			y = green1;
						 		}else {
						 			y = green2;
						 		}
						 		if(blue1 > blue2) {
						 			z = blue1;
						 		}else {
						 			z = blue2;
						 		}
						 		
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
								 
						 		break;
						 	case "exclusion":
						 		 x = red1 + red2 - (2*red1*red2)/255;
								 y = green1 + green2 - (2*green1*green2)/255;
								 z = blue1 + blue2 - (2*blue1*blue2)/255;
								 System.out.println(x + "" + y + "" + z);
								 
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
								 
								 break;
								
						 	case "overlay":
						 		if (red1 / 255 < 0.5) {
			                        x = 2 * red1 / 255 * red2 / 255;
			                    } else {
			                        x = 1 - 2 * (1 - red1 / 255) * (1 - red2 / 255);
			                    }
			                    if (green1 / 255 < 0.5) {
			                        y = 2 * green1 / 255 * green2 / 255;
			                    } else {
			                        y = 1 - 2 * (1 - green1 / 255) * (1 - green2 / 255);
			                    }
			                    if (blue1 / 255 < 0.5) {
			                        z = 2 * blue1 / 255 * blue2 / 255;
			                    } else {
			                        z = 1 - 2 * (1 - blue1 / 255) * (1 - blue2 / 255);
			                    }
			                    
			                    if (x * 255 > 255) {
			                        x = 255;
			                    } else {
			                        x = x * 255;
			                    }
			                    if (y * 255 > 255) {
			                        y = 255;
			                    } else {
			                        y = y * 255;
			                    }
			                    if (z * 255 > 255) {
			                        z = 255;
			                    } else {
			                        z = z * 255;
			                    }
			                    break;
			                    
						 	case "hard_light":
						 		if (red2 / 255 < 0.5) {
			                        x = 2 * red1 / 255 * red2 / 255;
			                    } else {
			                        x = 1 - 2 * (1 - red1 / 255) * (1 - red2 / 255);
			                    }
			                    if (green2 / 255 < 0.5) {
			                        y = 2 * green1 / 255 * green2 / 255;
			                    } else {
			                        y = 1 - 2 * (1 - green1 / 255) * (1 - green2 / 255);
			                    }
			                    if (blue2 / 255 < 0.5) {
			                        z = 2 * blue1 / 255 * blue2 / 255;
			                    } else {
			                        z = 1 - 2 * (1 - blue1 / 255) * (1 - blue2 / 255);
			                    }
			                    
			                    if (x * 255 > 255) {
			                        x = 255;
			                    } else {
			                        x = x * 255;
			                    }
			                    if (y * 255 > 255) {
			                        y = 255;
			                    } else {
			                        y = y * 255;
			                    }
			                    if (z * 255 > 255) {
			                        z = 255;
			                    } else {
			                        z = z * 255;
			                    }
			                    break;
			                    
						 	case "soft_light":
						 		if (red2 / 255 < 0.5) {
			                        x = 2 * red1/255 * red2 / 255 + (Math.pow(red1/255, 2) * (1 - 2 * red2/255));
			                    } else {
			                        x = Math.sqrt(red1 / 255) * (2 * red2 / 255 - 1) + 2 * red1 / 255 * (1 - red2 / 255);
			                    }
						 		if (green2 / 255 < 0.5) {
			                        y = 2 * green1/255 * green2 / 255 + (Math.pow(green1/255, 2) * (1 - 2 * green2/255));
			                    } else {
			                        y = Math.sqrt(green1 / 255) * (2 * green2 / 255 - 1) + 2 * green1 / 255 * (1 - green2 / 255);
			                    }
						 		if (blue2 / 255 < 0.5) {
			                        z = 2 * blue1/255 * blue2 / 255 + (Math.pow(blue1/255, 2) * (1 - 2 * blue2/255));
			                    } else {
			                        z = Math.sqrt(blue1 / 255) * (2 * blue2 / 255 - 1) + 2 * blue1 / 255 * (1 - blue2 / 255);
			                    }
			                
						 		 
						 		 
						 		 	if (x * 255 > 255) {
				                        x = 255;
				                    } else {
				                        x = x * 255;
				                    }
				                    if (y * 255 > 255) {
				                        y = 255;
				                    } else {
				                        y = y * 255;
				                    }
				                    if (z * 255 > 255) {
				                        z = 255;
				                    } else {
				                        z = z * 255;
				                    }
						 		
				                break;
						 		
						 	case "c_dodge":
						 		x = ((red1/255) /(1-red2/255));
						 		y = ((green1/255) / (1-green2/255));
						 		z = ((blue1/255) / (1-blue2/255));
						 		
						 		 if (x < 0) {
									 x = 0;
								 }else{
									 x = x*255;
									 if (x > 255) {
										 x = 255;
									 }
								 }
								 if (y < 0) {
									 y = 0;
								 }else{
									 y = y*255;
									 if (y > 255) {
										 y = 255;
									 }
								 }
								 if (z < 0) {
									 z = 0;
								 }else{
									 z = z*255;
									 if (z > 255) {
										 z = 255;
									 }
								 }
								break;
								
						 	case "color_burn": 
						 		 
						 		x = 1 - (1 - red1/255) / (red2/255);
			                    y = 1 - (1 - green1/255) / (green2/255);
			                    z = 1 - (1 - blue1/255) / (blue2/255);
			                    
			                    if (x < 0) {
									 x = 0;
								 }else{
									 x = x*255;
									 if (x > 255) {
										 x = 255;
									 }
								 }
								 if (y < 0) {
									 y = 0;
								 }else{
									 y = y*255;
									 if (y > 255) {
										 y = 255;
									 }
								 }
								 if (z < 0) {
									 z = 0;
								 }else{
									 z = z*255;
									 if (z > 255) {
										 z = 255;
									 }
								 }
						 		break;
						 		
						 	case "reflect":
						 		
						 		x = (Math.pow(red1/255, 2)/(1 - red2/255));
						 		y = (Math.pow(green1/255, 2)/(1 - green2/255));
						 		z = (Math.pow(blue1/255, 2)/(1 - blue2/255));
						 		
						 		
						 		 if (x < 0) {
									 x = 0;
								 }else{
									 x = x*255;
									 if (x > 255) {
										 x = 255;
									 }
								 }
								 if (y < 0) {
									 y = 0;
								 }else{
									 y = y*255;
									 if (y > 255) {
										 y = 255;
									 }
								 }
								 if (z < 0) {
									 z = 0;
								 }else{
									 z = z*255;
									 if (z > 255) {
										 z = 255;
									 }
								 }
								break;
								
						 	case "opacity":
						 		double alpha = questionFormPowModel.getValueOfPow();
						 		x = (1 - alpha)*(red2/255) + alpha*(red1/255);
						 		y = (1 - alpha)*(green2/255) + alpha*(green1/255);
						 		z = (1 - alpha)*(blue2/255) + alpha*(blue1/255);
						 		
						 		if (x * 255 > 255) {
				                    x = 255;
				                } else {
				                    x = x * 255;
				                }
				                if (y * 255 > 255) {
				                    y = 255;
				                } else {
				                    y = y * 255;
				                }
				                if (z * 255 > 255) {
				                     z = 255;
				                } else {
				                     z = z * 255;
				                }
				                
								break;
								 
						 }
						
						
						
						 Color newColor = new Color((int) x, (int) y, (int) z);
						 image1.setRGB(j,i,newColor.getRGB());
					 }
				 }
				 switch(state) {
				 	case "add":
				 		 File ouptut = new File(picturePath.replace(".jpg", "_additive.jpg"));
						 ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "sub":
				 		 ouptut = new File(picturePath.replace(".jpg", "_subst.jpg"));
						 ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "roz":
				 		ouptut = new File(picturePath.replace(".jpg", "_difference.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "mn":
				 		ouptut = new File(picturePath.replace(".jpg", "_multiply.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "screen":
				 		ouptut = new File(picturePath.replace(".jpg", "_screen.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "negation":
				 		ouptut = new File(picturePath.replace(".jpg", "_negation.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "darken":
				 		ouptut = new File(picturePath.replace(".jpg", "_darken.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "lighten":
				 		ouptut = new File(picturePath.replace(".jpg", "_lighten.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "exclusion":
				 		ouptut = new File(picturePath.replace(".jpg", "_exclusion.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "overlay":
				 		ouptut = new File(picturePath.replace(".jpg", "_overlay.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "hard_light":
				 		ouptut = new File(picturePath.replace(".jpg", "_hard_l.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "soft_light":
				 		ouptut = new File(picturePath.replace(".jpg", "_soft_l.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "c_dodge":
				 		ouptut = new File(picturePath.replace(".jpg", "_colorDodge.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "color_burn":
				 		ouptut = new File(picturePath.replace(".jpg", "_colorBurn.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "reflect":
				 		ouptut = new File(picturePath.replace(".jpg", "_reflect.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 	case "opacity":
				 		ouptut = new File(picturePath.replace(".jpg", "_opacity.jpg"));
						ImageIO.write(image1, "jpg", ouptut);
				 		break;
				 }
				 
				 f = new JFrame();
				 JOptionPane.showMessageDialog(f, "Success!");
			
	  } catch (Exception e) {}
	}
}


