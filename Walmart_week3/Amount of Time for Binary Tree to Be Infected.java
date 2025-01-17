package Walmart_week3;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,List<Integer>> adj=new HashMap<>();
        buildGraph(root,null,adj);
        Queue<Integer> q=new LinkedList<>();
        HashSet<Integer> vis=new HashSet<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(start,0);
        q.add(start);
        vis.add(start);
        int maxInfectionTime=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            int currTime=map.get(curr);
            for(int neigh:adj.getOrDefault(curr,new ArrayList<>())){
                if(!vis.contains(neigh)){
                    q.add(neigh);
                    vis.add(neigh);
                    map.put(neigh,currTime+1);
                    maxInfectionTime=Math.max(maxInfectionTime,map.get(neigh));
                }
            }
        }
        return maxInfectionTime;
    }
    public void buildGraph(TreeNode root,TreeNode par,HashMap<Integer,List<Integer>> adj){
        if(root!=null){
            if(par!=null){
                adj.computeIfAbsent(root.val,k->new ArrayList<>()).add(par.val);
                adj.computeIfAbsent(par.val,k->new ArrayList<>()).add(root.val);
            }
            buildGraph(root.left,root,adj);
            buildGraph(root.right,root,adj);
        }
    }
}
