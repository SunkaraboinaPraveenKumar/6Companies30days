import java.util.*;
class Solution {
    class Pair{
        int node;
        int dist;
        public Pair(int node,int dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        HashMap<Integer,List<Pair>> adj=new HashMap<>();
        for(int i=0;i<n;i++){
            adj.put(i,new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(new Pair(e[1],e[2]));
            adj.get(e[1]).add(new Pair(e[0],e[2]));
        }
        int count=Integer.MAX_VALUE;
        int ansNode=-1;
        for(int j=0;j<n;j++){
            int startNode=j;
            int[] dist=shortestPath(startNode,adj,n);
            int tempCount=0;
            for(int i=0;i<dist.length;i++){
                if(dist[i]<=distanceThreshold){
                    tempCount++;
                }
            }
            if(count>=tempCount){
                count=tempCount;
                ansNode=startNode;
            }
        }
        return ansNode;
    }
    public int[] shortestPath(int s,HashMap<Integer,List<Pair>> adj,int n){
        int[] dist=new int[n];
        boolean[] vis=new boolean[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s]=0;
        vis[s]=true;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        pq.add(new Pair(s,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            int d=curr.dist;
            if(d>dist[u]){
                continue;
            }
            for(Pair neigh:adj.get(u)){
                int v=neigh.node;
                if(!vis[v]&&dist[v]>dist[u]+neigh.dist){
                    dist[v]=dist[u]+neigh.dist;
                    pq.add(neigh);
                }
            }
        }
        return dist;
    }
}