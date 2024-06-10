package Factory;


import java.util.ArrayList;

import Object.Shape;

import Object.Group;

public class GroupFactory {

    public static Group GroupGenerate(ArrayList<Shape> shapes){
        return new Group(shapes);
    }
    
}
