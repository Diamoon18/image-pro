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
```Application``` - this is the entry point of the game. Here we have the main method. \
The Board is a panel where the game takes place.\
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

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
