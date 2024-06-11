package Factory;


import java.util.ArrayList;

import Object.BasicObject;
import Object.Group;

public class GroupFactory {

    public static Group GroupGenerate(ArrayList<BasicObject> shapes){
        return new Group(shapes);
    }
    
}
