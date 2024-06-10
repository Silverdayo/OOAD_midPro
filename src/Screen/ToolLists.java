package Screen;
import javax.swing.*;

import Factory.AssociationLineFactory;
import Factory.ClassFactory;
import Factory.CompositionLineFactory;
import Factory.GeneralizationLineFactory;
import Factory.UseCaseFactory;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList; 

import Mode.*;

public class ToolLists extends JToolBar {
    final int ToolsNumber = 6;
    final int RowsNumber = 1;
    final int HGap = 5;
    final int VGap = 5;

    ToolButton focusedButton = null;

    ArrayList<ToolButton> list;

    Canvas canvas;

    public ToolLists(){    
        //set layout
        canvas = Canvas.getCanvas();
        setLayout(new GridLayout(ToolsNumber, RowsNumber, HGap, VGap));
        setBackground(new java.awt.Color(200,200,200));

        createButton();

        for (ToolButton button : list) {
            add(button);
        }

    }

    private void createButton(){
        list = new ArrayList<>();
        list.add(new ToolButton("select", "lib\\Select.png", new SelectMode()));
        list.add(new ToolButton("association line", "lib\\AssociationLine.png", new LineCreateMode(new AssociationLineFactory())));
        list.add(new ToolButton("generalization line", "lib\\GeneralizationLine.png", new LineCreateMode(new GeneralizationLineFactory())));
        list.add(new ToolButton("composition line", "lib\\CompositionLine.png", new LineCreateMode(new CompositionLineFactory())));
        list.add(new ToolButton("class", "lib\\Class.png", new ObjectCreateMode(new ClassFactory())));
        list.add(new ToolButton("use case", "lib\\UseCase.png", new ObjectCreateMode(new UseCaseFactory())));
    }

    private class ToolButton extends JButton{
        private Color originalColor = new Color(200, 200, 200);
        private Color focusedColor = new Color(100, 100, 100);
        Mode mode;

        public ToolButton(String name, String asset, Mode mode){
            setToolTipText(name);
            ImageIcon imageIcon = new ImageIcon(asset);
            setIcon(imageIcon);
            setBackground(originalColor);
            setFocusPainted(false);
            addActionListener(new getFocus());
            this.mode = mode;
        }
    
        private class getFocus implements ActionListener{
            public void actionPerformed(ActionEvent e){
                if(focusedButton != null) {focusedButton.setBackground(originalColor);}
                focusedButton = (ToolButton) e.getSource();
                focusedButton.setBackground(focusedColor);
                canvas.currentMode = mode;
                canvas.setMode();
            }
        }
    }
}
