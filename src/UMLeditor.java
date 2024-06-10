import javax.swing.*;

import Screen.Canvas;
import Screen.MenuBar;
import Screen.ToolLists;


import java.awt.*;

public class UMLeditor extends JFrame{
    MenuBar menuBar;
    ToolLists toolLists; 
    Canvas canvas;
    
    
    public UMLeditor(){
        canvas = Canvas.getCanvas();
        menuBar = new MenuBar();
        toolLists = new ToolLists();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(menuBar, BorderLayout.NORTH);
        getContentPane().add(toolLists, BorderLayout.WEST);
        getContentPane().add(canvas, BorderLayout.CENTER);

    }
    public static void main(String[] args) {    

        UMLeditor MainScreen = new UMLeditor();

        MainScreen.setTitle("UML editor");
        MainScreen.setSize(1200, 900);
        MainScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainScreen.setLocationRelativeTo(null);
        MainScreen.setVisible(true);
    }

} 