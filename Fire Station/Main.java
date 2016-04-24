import java.util.*;
import java.io.*;
class GraphOperations
{
    protected boolean processed[];
    protected boolean discovered[];
    protected Vertex  parent[];
    protected boolean finished;

    protected Graph   g;

    public GraphOperations( Graph g )
    {
        this.g = g;
         processed = new boolean [ g.getNumVertices() ];
        discovered = new boolean [ g.getNumVertices() ];
            parent = new Vertex  [ g.getNumVertices() ];
    }

    public void initializeSearch()
    {
        for( int i=0; i < processed.length; i++ ) {
            processed[i] = discovered[i] = false;
            parent[i] = null;
        }
        finished = false;
    }

    // The 'findPath()' method is the tool to be used after other
    // algorithms, as the ones for constructing the minimum spanning tree.
    public LinkedList<Vertex> findPath( int start, int end )
    {
        LinkedList<Vertex> path = new LinkedList<Vertex>();

        findPath( path, start, end );

        return path;
    }
    private void findPath( LinkedList<Vertex> path, int start, int end )
    {
        if ( start == -1 ) return;

        if ( start == end || end == -1 )
            path.add( g.getVertex( start ) );
        else {
            findPath( path, start, parent[end].getId() );
            path.add( g.getVertex( end ) );
        }
    }

    public boolean validEdge( Edge e )
    {
        return e != null;
    }

    // Basic squeme for Breath First Search
    public void bfs( Vertex start )
    {
        // It is convinient to call initializeSearch() before calling this method.
        Queue<Vertex>  q = new LinkedList<Vertex>();

        q.add( start );
        discovered[start.getId()] = true;

        while( q.size() > 0 ) {
            
            Vertex currentVertex = q.remove();
            processVertex( currentVertex );
            processed[ currentVertex.getId() ] = true;

            for( Edge e : currentVertex.getEdges() ) {

                if ( ! validEdge( e ) ) continue;
                
                Vertex nextVertex = e.getDestination();

                if ( ! discovered[ nextVertex.getId() ] ) {

                    q.add( nextVertex );
                    discovered[ nextVertex.getId() ] = true;
                    parent[ nextVertex.getId() ] = currentVertex;
                }

                if ( ! processed[ nextVertex.getId() ] ) processEdge( e );
            }
        }
    }

    // Basic squeme for Deep First Search
    protected void dfs( Vertex currentVertex )
    {
        // It is convinient to call initializeSearch() before calling this method.

        if ( finished ) return;

        discovered[ currentVertex.getId() ] = true;
        processVertex( currentVertex );

        for( Edge e : currentVertex.getEdges() ) {

            if ( ! validEdge( e ) ) continue;
            
            Vertex nextVertex = e.getDestination();

            if ( ! discovered[ nextVertex.getId() ] ) {
                
                parent[ nextVertex.getId() ] = currentVertex;
                dfs( nextVertex );

            } else if ( ! processed[ nextVertex.getId() ] ) {
                
                processEdge( e );
            }
            if ( finished ) return;
        }

        processed[ currentVertex.getId() ] = true;
    }


    // Rewrite these methods depending on the problem to solve.
    public void processVertex( Vertex v )
    {
        System.out.println( "processed vertex: " + v );
    }
    public void processEdge( Edge e )
    {
        System.out.println( "processed edge: " + e );
    }


    public LinkedList<Vertex> topsort()
    {
        int inDegree[] = new int [ g.getNumVertices() ];

        Queue<Vertex> q = new LinkedList<Vertex>();

        // Initially the 'inDegree' array contains the input degree of each node.
        // And the queue 'q' contains the nodes of the graph with no input edges.
        for( int i=0; i < inDegree.length; i++ ) {

            inDegree[i] = g.getVertex(i).getInDegree();

            if ( 0 == inDegree[i] ) q.add( g.getVertex(i) );
        }

        // The queue 'q' will be empty if no nodes have zero input degree.

        LinkedList<Vertex>  sorted = new LinkedList<Vertex>();

        while( q.size() > 0 ) {
            
            Vertex currentVertex = q.remove();

            sorted.add( currentVertex );

            // The input degree of each node connected with the current node
            // is decreased. Those nodes whose input degree get equal to zero
            // is added to the queue.
            for( Edge e : currentVertex.getEdges() ) {
                
                Vertex nextVertex = e.getDestination();
                if ( --inDegree[ nextVertex.getId() ] == 0 ) q.add( nextVertex );
            }
        }

        if ( sorted.size() != g.getNumVertices() )
            System.err.printf( "Not a DAG -- only %d vertices found\n", sorted.size() );

        return sorted;
    }

    /**
     * Implementation of the Prim algorithm.
     * Leaves in the attribute 'parent' the result.
     * The path in the tree between each pair of vertices
     * can be obtained by means of the method 'findPath()'.
     */
    public double[] minimumSpanningTreePrim( Vertex root )
    {
        boolean inTree[] = new boolean [ g.getNumVertices() ];
        double distance[] = new double [ g.getNumVertices() ];

        // The array distance maintains the distance of each node to the tree

        initializeSearch();
        for( int i=0; i < distance.length; i++ ) distance[i] = Double.MAX_VALUE;

        distance[ root.getId() ] = 0.0;
        parent[ root.getId() ] = null;

        Vertex current = root;

        while( ! inTree[ current.getId() ] ) {

            // The current node is inserted in the tree
            inTree[ current.getId() ] = true;

            // For each edge of the current node
            for( Edge e : current.getEdges() ) {

                // Check each node connected with the current one
                Vertex next = e.getDestination();

                // The weight of the edge is the distance of the candidate node to the current one
                double weight = e.getWeight();

                // If the candidate node is not in the tree and the new distance is lower than the
                // best one up to now, then the distance is updated, the parent relation of nodes
                // in the tree is also updated
                if ( weight < distance[ next.getId() ]  &&  false == inTree[ next.getId() ] ) {

                    distance[ next.getId() ] = weight;
                    parent[ next.getId() ] = current;
                }
            }

            // Looking for the nearest node to the tree among those that are not yet in the tree
            current = root;
            double minDistOfOutOfTreeVertices = Double.MAX_VALUE;
            for( int i=0; i < distance.length; i++ ) {
                if ( ! inTree[ i ]  &&  distance[i] < minDistOfOutOfTreeVertices ) {
                    minDistOfOutOfTreeVertices = distance[i];
                    current = g.getVertex(i);
                }
            }
        }
	return distance;
    }
    /**
     * Implementation of the Kruskal algorithm.
     * Leaves in the attribute 'parent' the result.
     * The path in the tree between each pair of vertices
     * can be obtained by means of the method 'findPath()'.
     *
     * @return A vector containing the subset of edges that form the minimum spanning tree.
     */
    public Vector<Edge> minimumSpanningTreeKruskal()
    {
        initializeSearch();

        // 'setId' contains the id of nodes. Nodes with the same id are in the same connected component.
        int setId[] = new int [ g.getNumVertices() ];
        for( int i=0; i < setId.length; i++ ) setId[i] = i;

        Vector<Edge>  mst = new Vector<Edge>();

        while( mst.size() < g.getNumVertices() ) {

            // Search for the edge with lowest weight between vertices of different sets (or groups).
            Edge bestEdge = null;
            for( Edge e : g.edges ) {

                // If the edge connects nodes in the same connected component then is ignored.
                if ( setId[ e.getOrigin().getId() ] == setId[ e.getDestination().getId() ] ) continue;

                if ( bestEdge == null  ||  e.getWeight() < bestEdge.getWeight() ) bestEdge = e;
            }

            if ( bestEdge != null ) {

                // Marking the vertices as belonging to the same set (or group)

                int setIdMin = Math.min( setId[ bestEdge.getOrigin().getId() ], setId[ bestEdge.getDestination().getId() ] );
                int setIdMax = Math.max( setId[ bestEdge.getOrigin().getId() ], setId[ bestEdge.getDestination().getId() ] );

                for( int i=0; i < setId.length; i++ )
                    setId[i] = ( setId[i] == setIdMax ) ? setIdMin : setId[i];

                mst.add( bestEdge );
            }
        }

        return mst;
    }

    /**
     * Implementation of the Dijkstra algorithm.
     * Afterwards the 'findPath()' method could be used for recovering the path from 'from' to 'to'.
     */
    public void shortestPaths( int from )
    {
        shortestPath( g.getVertex(from), null );
    }
    public void shortestPath( int from, int to )
    {
        shortestPath( g.getVertex(from), g.getVertex(to) );
    }
    public void shortestPath( Vertex from, Vertex to )
    {
        boolean inTree[] = new boolean [ g.getNumVertices() ];
        double distance[] = new double [ g.getNumVertices() ];

        initializeSearch();
        for( int i=0; i < distance.length; i++ ) distance[i] = Double.MAX_VALUE;

        distance[ from.getId() ] = 0.0;
        parent[ from.getId() ] = null;

        Vertex current = from;

        // If 'to' or destination is not null the algorithm ends when such node is reached.
        // Otherwise the all shortest path from 'from' or origin to the other nodes are computed.
        while( ! inTree[ current.getId() ]  &&  current != to ) {

            inTree[ current.getId() ] = true;

            for( Edge e : current.getEdges() ) {
                
                Vertex next = e.getDestination();

                double weight = distance[ current.getId() ] + e.getWeight();

                // Distances are updated even if the node was reached previously.
                // Parent node of nodes are also updated.
                if ( weight < distance[ next.getId() ] ) {
                    distance[ next.getId() ] = weight;
                    parent[ next.getId() ] = current;
                }
            }

            // The current node for the next iteration is chosen among those
            // already reached but no in the tree. Thanks to this search the
            // Dijkstra algorihtm guarantees the shortest path between two nodes
            // or for from an origin node to the remaining nodes.
            current = from;
            double minDistOfOutOfTreeVertices = Double.MAX_VALUE;
            for( int i=0; i < distance.length; i++ ) {
                if ( ! inTree[ i ]  &&  distance[i] < minDistOfOutOfTreeVertices ) {
                    minDistOfOutOfTreeVertices = distance[i];
                    current = g.getVertex(i);
                }
            }
        }
    }

    /**
     * Implementation of the Floyd algorithm.
     */
    public double [][] allShortestPaths()
    {
        double weight[][] = new double [ g.getNumVertices() ][ g.getNumVertices() ];

        for( int i=0; i < weight.length; i++ )
            for( int j=0; j < weight[i].length; j++ ) weight[i][j] = Double.MAX_VALUE;

        for( int i=0; i < g.getNumVertices(); i++ ) {
            for( Edge e : g.getVertex(i).getEdges() ) {
                weight[ i ][ e.getDestination().getId() ] = e.getWeight();
                if ( ! g.isDirected() ) {
                    weight[ e.getDestination().getId() ][ i ] = e.getWeight();
                }
            }
        }

        for( int k=0; k < g.getNumVertices(); k++ ) {
            for( int i=0; i < g.getNumVertices(); i++ ) {
                for( int j=0; j < g.getNumVertices(); j++ ) {
                    double through_k = weight[i][k] + weight[k][j];
                    if ( through_k < weight[i][j] ) {
                        weight[i][j] = through_k;
                    }
                }
            }
        }

        return weight;
    }
}

class Graph
{
    protected Vector<Vertex>  vertices;
    protected Vector<Edge>    edges;
    protected boolean         directed;

    protected int totalOutDegree;
    protected int totalInDegree;

    protected Edge  adjacency[][]; // Not always used. Must be generated ad-hoc for those algorithms that need it.

    public Graph( boolean directed )
    {
        vertices = new Vector<Vertex>();
           edges = new Vector<Edge>();

        totalOutDegree = 0;
        totalInDegree = 0;

        this.directed = directed;

        adjacency = null;
    }

    public int getNumVertices() { return vertices.size(); }
    public int getNumEdges()    { return edges.size(); }
    public int getDegree()      { return totalOutDegree; }
    public int getOutDegree()   { return totalOutDegree; }
    public int getInDegree()    { return totalInDegree; }

    public Vertex getVertex( int index ) { return vertices.get(index); }

    public boolean isDirected() { return directed; }


    public void generateAdjacencyMatrix()
    {
        adjacency = new Edge [ vertices.size() ][ vertices.size() ];

        for( Vertex v : vertices ) {
            for( Edge e : v.getEdges() ) {
                
                adjacency[ v.getId() ][ e.getDestination().getId() ] = e;
            }
        }
        // It not necessary to add the edge from 'dest' to 'origin' because if the graph was
        // generated as non-directed the edge from 'dest' to 'origin' must exist as an edge inside
        // the destination vertex. This implementation forces to allocate more memory but it 
        // give us the chance of use it for different purposes.
    }

    public Edge findEdge( Vertex from, Vertex to )
    {
        if ( adjacency != null ) return adjacency[ from.getId() ][ to.getId() ];

        for( Edge e : from.getEdges() ) if ( e.getDestination() == to ) return e;

        return null;
    }

    public void reset() // InitializeGraph
    {
        vertices.clear();        
        edges.clear();        

        totalOutDegree = 0;
        totalInDegree = 0;
    }

    public void insert( Vertex v )
    {
        v.setId( vertices.size() );
        vertices.add( v );
    }
    public void insert( Edge e, boolean directed )
    {
        edges.add( e );

        if ( !directed ) {
            Edge other = new Edge( e.getDestination(), e.getOrigin() );
            other.setCapacity( e.getCapacity() );
            other.setFlow( e.getFlow() );
            other.setResidual( e.getResidual() );
            other.setWeight( e.getWeight() );
            edges.add( other );
            e.getDestination().add( other );
        }
    }
    public void connect( Vertex o, Vertex d, boolean directed )
    {
        Edge e = new Edge( o, d );
        edges.add( e );
        o.add( e );

        if ( ! directed ) {
            e = new Edge( d, o );
            edges.add( e );
            d.add( e );
        }
    }

    public void read( Scanner sf, boolean directed )
    {
    }

    public void print( PrintStream ps )
    {
    }
}

class Edge
{
    protected Vertex      origin;
    protected Vertex      destination;

    protected String      label;

    protected double      weight;

    protected double      capacity;
    protected double      flow;
    protected double      residual;

    public Edge( Vertex origin, Vertex destination )
    {
        this.origin = origin;
        this.destination = destination;
        this.label = null;
        reset();
    }
    public Edge( Vertex origin, Vertex destination, String label )
    {
        this.origin = origin;
        this.destination = destination;
        this.label = label;
        reset();
    }

    public void reset()
    {
        weight   = 1.0;
        capacity = 1.0;
        flow     = 0.0;
        residual = 0.0;
    }

    public Vertex getOrigin() { return origin; }
    public Vertex getDestination() { return destination; }
    public String getLabel() { return label; }

    public double getWeight() { return weight; }

    public void setWeight( double w ) { weight=w; }

    public double getCapacity() { return capacity; }
    public double getFlow()     { return flow; }
    public double getResidual() { return residual; }


    public void setCapacity( double c ) { capacity=c; }
    public void setFlow(     double f ) { flow=f; }
    public void setResidual( double r ) { residual=r; }


    public String toString()
    {
        return origin.toString() + " --> " + destination.toString();
    }
}

class Vertex
{
    protected int             id; // Used as index inside the graph.
    protected String          label;
    protected Vector<Edge>    edges;
    protected int             inDegree;

    public Vertex( int id, String label )
    {
        this.id = id;
        this.label = label;
        this.edges = new Vector<Edge>();
        this.inDegree = 0;
    }

    public int getId() { return id; }
    public String getLabel() { return label; }

    public void setId( int id ) { this.id = id; }

    public Edge getEdge( int i ) { return edges.get(i); }

    public Vector<Edge> getEdges() { return edges; }

    public void add( Edge e )
    {
        edges.add( e );
        e.getDestination().incrInDegree();
    }

    public void incrInDegree() { inDegree++; }

    public int getOutDegree() { return edges.size(); }
    public int getInDegree() { return inDegree; }

    public String toString()
    {
        return String.format( "(%d) <%s>", id, label!=null ? label : "" );
    }
}



public class Main{
	
	public static void main (String args[]) {
	    Scanner tc = new Scanner(System.in);
	    int nCases = tc.nextInt();
	    tc.nextLine(); // Clear buffer
	    for(int it=0;it<nCases;it++){
		String line;
		do{line = tc.nextLine().trim();} while(!line.isEmpty());
		int f = tc.nextInt();
		int i = tc.nextInt();
		int[] bomberos = new int[f];
		Vertex[] intersecciones = new Vertex[i];
		Graph g = new Graph(false);
		for(int j=0;j<f;j++) bomberos[j] = tc.nextInt()-1;
		for(int j=0;j<i;j++){ intersecciones[j] = new Vertex(j,null); g.insert(intersecciones[j]); }
		do{
		    int origen = tc.nextInt()-1;
		    int destino = tc.nextInt()-1;
		    Edge e = new Edge(intersecciones[origen],intersecciones[destino]);
		    e.setWeight(tc.nextInt());
		    g.insert(e,false);
		}while(tc.hasNextInt());
		GraphOperations go = new GraphOperations(g);
		int[] distancias = new int[i];
		// Inicializar distancias //
		for(int j=0;j<i;j++) distancias[j] = Integer.MAX_VALUE;
		// Aplicar prim desde cada parque de bomberos //
		for(int j=0;j<f;j++){
		    double[] distance = go.minimumSpanningTreePrim(intersecciones[bomberos[j]]);
		    for(int z=0;z<distance.length;z++) System.out.println("Distancia de: "+z+" a: "+bomberos[j]+": "+distance[z]);
		}
	    }
	}
}

