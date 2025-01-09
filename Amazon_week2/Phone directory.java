import java.util.*;
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        // Arrays.sort(contact);
        StringBuilder sb=new StringBuilder();
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        for(char ch:s.toCharArray()){
            sb.append(ch);
            TreeSet<String> list=new TreeSet<>();
            for(int i=0;i<contact.length;i++){
                if(i>0&&contact[i]==contact[i-1]){
                    continue;
                }
                if(contact[i].startsWith(sb.toString())){
                    list.add(contact[i]);
                }
            }
            if(list.size()==0){
                list.add("0");
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}