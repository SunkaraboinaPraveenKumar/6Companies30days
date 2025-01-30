package Goldman_Sachs_week6;
import java.util.*;
class Solution {
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        List<String> ans=new ArrayList<>();
        Map<String,List<Integer>> map=new HashMap<>();
        for(List<String> l:access_times){
            String emp=l.get(0);
            String time=l.get(1);
            map.computeIfAbsent(emp,k->new ArrayList<>()).add(Integer.parseInt(time));
        }
        for(String key:map.keySet()){
            List<Integer> list=map.get(key);
            Collections.sort(list);
            if(isHighAccess(list)){
                ans.add(key);
            }
        }
        return ans;
    }
    public boolean isHighAccess(List<Integer> list){
        for(int i=2;i<list.size();i++){
            if(list.get(i)-list.get(i-2)<=99){
                return true;
            }
        }
        return false;
    }
}
