from collections import defaultdict, deque
import graph
import algorithm

def createEdgeSet():
    Edges=[]
    num_edges = 0
    f = open('3.txt','r')
    #print f.read()
    i=0
    y=0
    #print 'entering for'
    for x in f:
        if y == 0:
            #print 'boutta continue'
            y+=1
            continue
            #print 'continued'
        #print x
        #print "line " + str(i)
        #i+=1
        j=0
        my_first_num = ""
        while x[j] != ' ':
            my_first_num+=x[j]
            j+=1
            #print j

        i=j+1
        my_second_num = ""
        while x[i] != ' ':
            my_second_num+=x[i]
            i+=1

        k=i+1
        my_third_num=""
        while x[k] != '\n':
            my_third_num+=x[k]
            k+=1

        Edges.append((int(my_first_num),int(my_second_num),int(my_third_num)))
        #print Edges

    return Edges

""" https://gist.github.com/econchick/4666413
    https://gist.github.com/mdsrosa/c71339cb23bc51e711d8
    """

class Graph:
  def __init__(self):
    self.nodes = set()
    self.edges = defaultdict(list)
    self.distances = {}

  def add_node(self, value):
    self.nodes.add(value)

  def add_edge(self, from_node, to_node, distance):
    #self.edges[from_node].append(to_node)
    self.edges[to_node].append(from_node)
    self.distances[(from_node, to_node)] = distance


def dijsktra(graph, initial):
  visited = {initial: 0}
  path = {}

  nodes = set(graph.nodes)

  while nodes:
    min_node = None
    for node in nodes:
      if node in visited:
        if min_node is None:
          min_node = node
        elif visited[node] < visited[min_node]:
          min_node = node

    if min_node is None:
      break

    nodes.remove(min_node)
    current_weight = visited[min_node]

    for edge in graph.edges[min_node]:
        #print str(edge) + ' edge'
        #print str(min_node) + ' min_'
        weight = current_weight + graph.distances[(min_node, edge)]
        if edge not in visited or weight < visited[edge]:
            visited[edge] = weight
            path[edge] = min_node

  return visited, path

def shortestpath(graph, origin, destination):
    if (destination == origin):
        return [], []
    visited,paths = dijsktra(graph, origin)
    #print paths
    full_path = deque()
    #print destination
    _destination = paths[destination]

    while _destination != origin:
        full_path.appendleft(_destination)
        _destination = paths[_destination]

    """#print full_path
    if not full_path:
        print 'De-q is empty'
        i=1
        for edge in graph.edges.values():
            #print edge
            if edge[0] == origin and edge[1] == destination:
                full_path.appendleft(origin)
                #print full_path

                full_path.append(destination)
                #print full_path
            else:
                print "NO PATH "
                quit()
            i+=1"""

    full_path.appendleft(origin)
    #print full_path

    full_path.append(destination)
    #print full_path


    return visited[destination], list(full_path)

def main():
    graph = Graph()
    Edge_Set = createEdgeSet()
    all_shortest = [[0 for x in range(1,151)] for y in range(1,151)]

    for i in Edge_Set:
       graph.add_edge(i[0],i[1],i[2])

    #print (graph.edges)

    for i in range(1,151):
        graph.add_node(i)

    i = 1
    visit, path = shortestpath(graph, 2, 1)
    print path
    """while i <= 150:
        #print i
        j = 1
        while j <= 150:
            #print str(j) + " J!"
            visited, path = shortestpath(graph, i, j)
            all_shortest[i-1][j-1] = path
            #print all_shortest[i-1][j-1]
            #print '\n'
            j+=1
        i+=1*"""
    #print all_shortest



main()
