package Atlassian_week5;
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
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int wt=edge[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        int cities=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<n;i++){
            int st=i;
            int[] dist=getShortestPath(st,adj,n);
            int tempCities=0;
            for(int j=0;j<dist.length;j++){
                if(dist[j]<=distanceThreshold){
                    tempCities++;
                }
            }
            if(cities>=tempCities){
                cities=tempCities;
                ans=st;
            }
        }
        return ans;
    }
    public int[] getShortestPath(int st,List<List<Pair>> adj,int n){
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.dist-b.dist);
        dist[st]=0;
        pq.add(new Pair(st,0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int u=curr.node;
            int d=curr.dist;
            if(dist[u]>d){
                continue;
            }
            for(Pair neigh:adj.get(u)){
                int v=neigh.node;
                int wt=neigh.dist;
                if(dist[u]+wt<dist[v]){
                    dist[v]=dist[u]+wt;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        return dist;
    }
}
