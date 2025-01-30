package Goldman_Sachs_week6;
import java.util.*;
class DataStream {
    int value;
    int k;
    public DataStream(int value, int k) {
        this.value=value;
        this.k=k;
    }
    int consec=0;
    public boolean consec(int num) {
        if(num==value){
            consec++;
        }
        else{
            consec=0;
        }
        return consec>=k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */