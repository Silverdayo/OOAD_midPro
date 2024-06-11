package Screen;
import javax.swing.JMenuBar;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JMenuItem;



public class MenuBar extends JMenuBar{
    private Canvas canvas;
    public MenuBar(){
        JMenu menu;
        JMenuItem menuItem;
        canvas = Canvas.getCanvas();        

        setBackground(new Color(200,200,200));

        // Did it even have a work?
        menu = new JMenu("File");
        add(menu);
        
        // Edit menu
        menu = new JMenu("Edit");
        menu.setBackground(new Color(200,200,200));
        add(menu);

        //group 
        menuItem = CreateMenuItem("Group",new Group());
        menu.add(menuItem);

        //ungroup
        menuItem = CreateMenuItem("UnGroup", new UnGroup());
        menu.add(menuItem);

        //change name
        menuItem = CreateMenuItem("change name", new ChangeName());
        menu.add(menuItem);
    }

    private JMenuItem CreateMenuItem(String name, ActionListener actionListener){
        JMenuItem menuItem = new JMenuItem(name);
        menuItem.setBackground(new Color(200,200,200));
        menuItem.addActionListener(actionListener);
        return menuItem;
    }


    class Group implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(canvas.currentMode.getName() == "select mode"){
                canvas.Group();
            }
        }
    }
    
    class UnGroup implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(canvas.currentMode.getName() == "select mode"){
                canvas.unGroup();
            }
        }
    }
    
    class ChangeName implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(canvas.currentMode.getName() == "select mode"){
                Canvas canvas = Canvas.getCanvas();
                if(canvas.focusedShape != null){
                    canvas.focusedShape.mode_changeName();
                }
            }
        }
    }
}
