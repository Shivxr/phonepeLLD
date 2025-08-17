import java.util.*;
public class Library {

    static List<Problem> problems=new ArrayList<>();
    Map<String,Integer> prob_map=new HashMap<>();
    int tag=0;
    protected void insert(Problem value){
        problems.add(value);
    }

    protected void add_problem(){
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter problem name: ");
        String problem_name = sc.nextLine();

        System.out.print("Enter description: ");
        String description = sc.nextLine();

        System.out.print("Enter difficulty: ");
        String difficulty = sc.nextLine();

        System.out.print("Enter score: ");
        int score = sc.nextInt();

        insert(new Problem(problem_name,description,"00"+tag,difficulty,score,0,0));
        prob_map.put("00"+tag,problems.size()-1);
        tag+=1;
    }

}
