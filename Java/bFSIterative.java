import java.util.*;

/**
 BFS is a blind search. It uses a queue applying the first in first out principle. 
 All the neighbours of a node will be evaluated first before they go to any other node.
 
 There is a Node class below to aid in the traversal. The nodes are identified by integers.
 
**/
public class bFSIterative {

    public static Node bFSearch(Node startNode, Node goalNode){
        Queue<Node> openNodes=new LinkedList<Node>(); //Will contain the nodes to be explored
        Set<Node>  visited=new HashSet<Node>();      //contains the nodes that have already been visisted

        openNodes.add(startNode);

        while(!openNodes.isEmpty()){
            Node current=openNodes.poll();

            if(current==goalNode){
                System.out.println("Found the goal node");
                return current;
            }
            visited.add(current);
            Set<Node> neighbours=current.getNeighbours();
            for(Node neighbour:neighbours){
                if(!visited.contains(neighbour)){  // if the node has not been visited,stage it for traversal
                    openNodes.add(neighbour);
                }
            }

        }
        System.out.println("The goal node cannot be reached from the start node");
        return null;
    }

    public static void main(String[] args) {
        HashMap<Integer, Node> graph=new HashMap<Integer, Node>();  //will contain our vertices identified by integers

        for(int i=1;i<=20;i++){
           Node newNode=new Node(i);
           graph.put(i,newNode);
        }

        //adding neighbours since it is undirected if has a neighbour of 2 2 has a neighbour of 1
        graph.get(1).addNeighbours(Arrays.asList( graph.get(2), graph.get(3), graph.get(4)));
        graph.get(2).addNeighbours(Arrays.asList( graph.get(1), graph.get(5), graph.get(4)));
        graph.get(3).addNeighbours(Arrays.asList( graph.get(1)));
        graph.get(4).addNeighbours(Arrays.asList( graph.get(1), graph.get(2)));
        graph.get(5).addNeighbours(Arrays.asList( graph.get(2)));

        bFSearch(graph.get(1),graph.get(3)); // Will print found the goal node
        bFSearch(graph.get(1),graph.get(6));  // Will print The goal node cannot be reached from the start node
    }

}

class Node{
    int id;
    Set<Node> neighbours = new HashSet<Node>(); //This are the vertices connected to this vertex

    //Ccnstructor
    Node(int id){
        this.id=id;
    }

    //Methods

    void addNeighbour(Node neighbour){
        neighbours.add(neighbour);
    }
    void addNeighbours(Collection newNeighbours){
        neighbours.addAll(newNeighbours);
    }

    Set<Node> getNeighbours(){
        return this.neighbours;
    }

    int getId(){
        return this.id;
    }

}

