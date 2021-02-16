package ADT;

import java.util.*;

public class GraphNode {    // TODO:Generics
    int value;
    List<GraphNode> neighbors;

    GraphNode(int value){
        this.value = value;
        neighbors = new ArrayList<>();
    }
}
