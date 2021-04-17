# Image processing application in Java
An application based on the model, view, controller structure.\
Model - application logic.\
View - drawing application objects.\
Controller - interaction with the user.
## Screenshots
![image](https://user-images.githubusercontent.com/72127610/115123166-277b6b80-9fbc-11eb-8150-61464be19e00.png)
### Add image
![image](https://user-images.githubusercontent.com/72127610/115123184-395d0e80-9fbc-11eb-9965-4154552fcd08.png)
### Linear processing
![image](https://user-images.githubusercontent.com/72127610/115123172-2f3b1000-9fbc-11eb-91bd-ad40a00ceced.png)
![image](https://user-images.githubusercontent.com/72127610/115123178-33672d80-9fbc-11eb-80b6-04b4f783e0ac.png)
### Pow
![image](https://user-images.githubusercontent.com/72127610/115123192-41b54980-9fbc-11eb-8040-0e73ea87c9d6.png)
### Blend processing
![image](https://user-images.githubusercontent.com/72127610/115123201-4974ee00-9fbc-11eb-9d05-89bd42dfcf71.png)
![image](https://user-images.githubusercontent.com/72127610/115123210-4c6fde80-9fbc-11eb-9f5a-63fc7db69102.png)

## Code explanation
### 1) Controller
```Application class``` - this is the entry point of the application. Here we have the main method. \
The Board is a panel where the application takes place.\
Here we put the Board to the center of the JFrame container. 
```java   
add(new Board());
```
This line sets the size of the window.\
Also set the name of the application.\
Add an icon. \
I have not set up the ability to change the size of the application. 
```java   
setSize(WIDTH, HEIGHT); 
setTitle("IMAGE~PRO");
setIconImage(imagesLoad.icon.getImage());

setResizable(false);
```
This ```setDefaultCloseOperation``` will close the application when we click on the close button. \
Passing null to the setLocationRelativeTo() method centers the window on the screen.
``` java
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
```
We create an instance of our code example and make it visible on the screen. 
```java
public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
             Application ex = new Application();
             ex.setVisible(true);
        });
}
``` menuController ``` - for menu buttons and other buttons.\
```implements MouseListener, MouseMotionListener``` - mouse support.\
```mouseMoved``` - follows the position of the mouse.
```java
@Override
public void mouseMoved(MouseEvent e) {
          Board.mouseX = e.getX();
          Board.mouseY = e.getY();
}
```
mousePressed - the user did a mouse click, then the variables for some modes are true.\
mouseReleased - the user released the mouse, then the variables - false.
```java
@Override
public void mousePressed(MouseEvent arg0) {
        menuView.click = true;
        linearView.click_l = true;
        powView.click_p = true;
        mixingView.click_m = true;
}
@Override
public void mouseReleased(MouseEvent arg0) {
        menuView.click = false;
        linearView.click_l = false;
        powView.click_p = false;
        mixingView.click_m = false;
}
```
### 2) Model
```Board enum``` - for easy application development.\
There are application states:\
1.MENU,\
2.LINEAR,\
3.POW,\
4.MIXING\
```Board model``` - here is the main logic of the app.\
Three main functions:
```draw()``` - draws the application on the screen.
```java
private void draw() {
	Graphics g2 = this.getGraphics();
	g2.drawImage(image,0,0,null);
	g2.dispose();
}
```
```pasteButton()``` - checking which button the user pressed.\
Then if the coordinate of the mouse is on the button, changing the color and text of the button.\
If we press the button, then the state changes in this case to Linear.\
If the coordinate of the mouse is not on the button, then don't change the labels and colors of the buttons.
```java
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
                        ...
                        else {
			if(e.equals(menu.menuButtons[0])) {e.color1 = color_butt; e.s = "Linear";}
			if(e.equals(menu.menuButtons[1])) {e.color1 = color_butt; e.s = "Pow";}
			if(e.equals(menu.menuButtons[2])) {e.color1 = color_butt; e.s = "Blend";}
			if(e.equals(menu.menuButtons[3])) {e.color1 = color_butt;e.s = "Exit";}
			for(int i = 0; i < line.linearButtons.length; i++) {
				if(e.equals(line.linearButtons[i])) {e.color1 = color_butt;}
                        }
}
```
Depending on the state of the application, it call the necessary functions, and draw this state.
```java
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
```
### ```linearModel class``` - logic of the linear processing images.
Variables:
```java
private static String picturePath ="";
static BufferedImage image;
static int width;
static int height;
static JFrame f;
```
Method ```openPicture()``` - to open the image.
1. New object JFileChooser with Home Directory.
2. The name of the new window.
3. Do not allow the user to select any file except .jpg
```java
JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
jfc.setDialogTitle("Select an image");
jfc.setAcceptAllFileFilterUsed(false);
FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG images", "jpg");
jfc.addChoosableFileFilter(filter);
```
Save the selected path to a variable picturePath.
```java
int returnValue = jfc.showOpenDialog(null);
if (returnValue == JFileChooser.APPROVE_OPTION) {
            picturePath = jfc.getSelectedFile().getPath();
            System.out.println(jfc.getSelectedFile().getPath());
}
```
Method ```negative()``` - to open the image.\
Load (open) an image.\
Take picture sizes.
```java
File input = new File(picturePath);
image = ImageIO.read(input);
width = image.getWidth();
height = image.getHeight();
```
Looping over successive pixels in the image.\
Get the RGB values.\
Write the formula for processing (negation mode).\
Set new RGB values for the image.\
And save new image in folder.\
Appears a window that indicates a successful operation.
```java
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
```
Methods  light(int valueOfB) and dark(valueOfB) by analogy, but with protection against going out of range.\
Also value of the b loaded with a slider(user can change value).
```java
...
int b = valueOfB;
...
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
 ...
```
``` questionFormModel class implements ChangeListener ``` - window for slider, user selects value of the variable. \
ChangeListener - track Slider value change.
```java
@Override
public void stateChanged(ChangeEvent e) {
	if(stan.equals("dark")) {
		l.setText("value of -b:" + b.getValue()*(-1));
	}else if(stan.equals("light")) {
		l.setText("value of b:" + b.getValue());
	}
}
```
Main Method ```frame(int start, int end, int interval, String mode)```\
start - beginning of interval for slider.\
end - beginning of interval for slider.\
mode - a short description of the method to distinguish the windows (create egative Slider).\
For dark mode we should have the negative Slider, that is why I did this.
```java
if(stan.equals("dark")) {
	int st = start;
	start = end;
	end = st*(-1);
}
```
Creating a new Slider object.
```java
b = new JSlider(start, end, interval);
questionFormModel qm = new questionFormModel();
JPanel p = new JPanel();
```
Depending on the mode, we set title of the window, print the information(text) in the window.\
setInverted(true) - reverse the order.
```java
if(stan.equals("dark")) {
	b.setInverted(true);
	f.setTitle("Podaj wartosc -b:");
	l.setText("value of -b:" + b.getValue()*(-1));
} else if(stan.equals("light")){
	f.setTitle("Podaj wartosc b:");
	l.setText("value of b:" + b.getValue());
} 
```
Button to confirm the selected value from Slider.\
Depending on the mode, invoke the appropriate method.
```java
jb.setBounds(150, 10, 95, 30);
jb.addActionListener(new ActionListener() {
	@Override
	public void actionPerformed(ActionEvent e) {
		if(stan.equals("dark")) {
			valueOfB = b.getValue()*(-1);
			linearModel.dark(valueOfB);
			f.dispose();
		} else if(stan.equals("light")){
			valueOfB = b.getValue();
			linearModel.light(valueOfB);
			f.dispose();
		}
	}
});
```
### ```powModel class``` - logic of the power processing images.
By anology with linearModel class, but another formula.\
```java
double potega = valueOfB;
double x, y, z;
x = 0;
y = 0;
z = 0;
						 
x = (255 * Math.pow(red/255, potega));
y = (255 * Math.pow(green/255, potega));
z = (255 * Math.pow(blue/255, potega));
```
```questionFormPowModel class``` - window(InputDialog) for select value of the variable potega (b).
Main method ```frame()```\
Protection against entering an incorrect value of variable input.\
If value is incorrect, input set 1.\
Invoke the ```potega(valueOfPow)```.
```java
String input = "1";
input = JOptionPane.showInputDialog( "Value of pow [0,10]:");
if(input == null || input.isEmpty() || !input.matches("([0-9]*[.])?[0-9]+")) {
	input = "1";
	JOptionPane.showMessageDialog(f,"Error input, default input 1");
}
valueOfPow = Double.parseDouble(input);
if(valueOfPow < 0 || valueOfPow > 10) {
	valueOfPow = 1;
	JOptionPane.showMessageDialog(f,"Error input, default input 1");
}
powModel.potega(valueOfPow);
```
### ```mixingModel class``` - logic of the blend processing images. ( 16 modes )
