package Atlassian_week5;
import java.util.*;
class ThroneInheritance {
    HashMap<String,ArrayList<String>> map;
    String king="";
    HashSet<String> dead=new HashSet<>();
    public ThroneInheritance(String kingName) {
        map=new HashMap<>();
        map.put(kingName,new ArrayList<>());
        king=kingName;
    }
    
    public void birth(String parentName, String childName) {
        map.getOrDefault(parentName,new ArrayList<>()).add(childName);
        map.put(childName,new ArrayList<>());
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> ans=new ArrayList<>();
        dfs(king,ans);
        return ans;
    }
    public void dfs(String start,List<String> ans){
        if(!dead.contains(start)){
            ans.add(start);
        }
        for(String child:map.getOrDefault(start,new ArrayList<>())){
            dfs(child,ans);
        }
    }
}

/**
 * Your ThroneInheritance object will be instantiated and called as such:
 * ThroneInheritance obj = new ThroneInheritance(kingName);
 * obj.birth(parentName,childName);
 * obj.death(name);
 * List<String> param_3 = obj.getInheritanceOrder();
 */
