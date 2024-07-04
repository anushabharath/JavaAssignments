package ufa;
public class UFC
{
     int V,E;
     Edge edge[];

    class Edge
    {
        int s ,d;
    }

    public UFC(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for(int i=0;i<e;i++)
            edge[i]=new Edge();
    }
    public int find(int parent[] ,int i)
    {
        if(parent[i]==i)
            return i;
        return find(parent,parent[i]);
    }
    public void union(int parent[],int x, int y)
    {
        int xset = find(parent,x);
        int yset = find(parent,y);
        parent[xset]=yset;
    }
    public boolean isCycle(UFC g)
    {
        int parent[] = new int[g.V];
        for(int i=0;i<g.V;i++)
            parent[i] = i;
        for(int i=0;i<g.E;i++)
        {
            int x = g.find(parent, edge[i].s);
            int y = g.find(parent, g.edge[i].d);
            if (x == y)
                return true;
            g.union(parent, x, y);
        }
        return false;
        }
    public static void main(String args[])
    {
UFC obj = new UFC(3,3);
// edge 0-1
obj.edge[0].s =0;
obj.edge[0].d=1;
// edge 1-2
        obj.edge[1].s =1;
        obj.edge[1].d=2;
        // edge 0-2
        obj.edge[2].s =0;
        obj.edge[2].d=2;
if(obj.isCycle(obj))
System.out.println("Yes the Graph contains Cycle");
else
    System.out.println("No the Graph doesnot contain Cycle");
    }
}
