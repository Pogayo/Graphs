All the graph searches, (Depth First Search,Bread First Search and the variations of these two such as Dijkstra and A* follow the same pattern). Below is a template that describes searching in graphs.

##Pseudocode

search(start_node,goal_node):
     openNodes = list()                # empty list, if BFS,A* or Djikstra, use the Queue data structure. DFS uses a Stack
     visited = set()                   # empty set to store the nodes that we have visited already
     add start_node to openNodes
     while openNodes is not empty:
        currentNode = openNodes.remove()    # This is where the difference comes in, if it is a BFS, you pick the first.DFS pick the last         if goal_node==currentNode:
             print "found the goal node"    # goal found
             return node
        endif
        add currentNode to visited set
        neighbours=currentNode.getNeighbours()  #get the current nodes neighbours
        for neighbour in neighbours:
            if neighbour is not visited:     #This is necessary to avoid finding yourself in a cycle which creates an endless loop
               add neighbours to openNodes  #staging them for traversal
             endif
        endfor
     endwhile
     print "The goal cannot be reached from the start node"
     return None  
