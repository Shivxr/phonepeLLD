import java.util.*;
public class Leaders {



    public void leaders(List<Contestant> l){
        l.sort((a,b)->(b.score-a.score));
        int i=0;
        while(i<l.size() && i<10){
            Contestant v=l.get(i);
            System.out.println(v.username+" "+v.score);
            i+=1;
        }
    }
}
