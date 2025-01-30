package Goldman_Sachs_week6;
import java.util.*;
class Solution {
    HashMap<Character,String> map=new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }};
    char[] arr;
    List<String> ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return ans;
        }
        this.arr=digits.toCharArray();
        helper(new Stack<>(),0);
        return ans;
    }
    public void helper(Stack<Character> stack,int idx){
        if(idx==arr.length){
            ans.add(stackToString(stack));
            return;
        }
        String str=map.get(arr[idx]);
        for(char ch:str.toCharArray()){
            stack.push(ch);
            helper(stack,idx+1);
            stack.pop();
        }
    }
    public String stackToString(Stack<Character> stack){
        StringBuilder sb=new StringBuilder();
        Iterator it=stack.iterator();
        while(it.hasNext()){
            sb.append(it.next());
        }
        return sb.toString();
    }
}
