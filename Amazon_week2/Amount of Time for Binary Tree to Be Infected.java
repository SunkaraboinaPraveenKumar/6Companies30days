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
        HashSet<Integer> vis=new HashSet<>();
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        vis.add(start);
        Map<Integer,Integer> infectionTimes=new HashMap<>();
        infectionTimes.put(start,0);
        int maxInfectionTime=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            int currTime=infectionTimes.get(curr);
            for(int neigh:adj.getOrDefault(curr,new ArrayList<>())){
                if(!vis.contains(neigh)){
                    q.add(neigh);
                    vis.add(neigh);
                    infectionTimes.put(neigh,currTime+1);
                    maxInfectionTime=Math.max(maxInfectionTime,infectionTimes.get(neigh));
                }
            }
        }
        return maxInfectionTime;
    }
    public void buildGraph(TreeNode curr,TreeNode par,HashMap<Integer,List<Integer>> adj){
        if(curr!=null){
            if(par!=null){
                adj.computeIfAbsent(curr.val,k->new ArrayList<>()).add(par.val);
                adj.computeIfAbsent(par.val,k->new ArrayList<>()).add(curr.val); 
            }
            buildGraph(curr.left,curr,adj);
            buildGraph(curr.right,curr,adj);
        }
    }
}