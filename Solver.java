import java.util.*;
public class Solver {

    Library ob1;
    ContestantManager ob2;

    Solver(Library ob1,ContestantManager ob2){
        this.ob1=ob1;
        this.ob2=ob2;
    }

    protected void search_solve(String uname){
        List<Problem> temp=new ArrayList<>();
        Scanner sc=new Scanner(System.in);
        while(true) {
            System.out.println("1.search by difficulty");
            System.out.println("2.input Problem to Solve");
            System.out.println("3.exit");
            int n = sc.nextInt();
            if (n == 1) {
                System.out.println("enter difficulty");
                sc.nextLine();
                String diff = sc.nextLine();
                //p.tag+" "+p.problem_name+" "+p.description+" "+p.difficulty+" "+p.score
                for (Problem p : ob1.problems) {
                    if (p.difficulty.equals(diff)) {
                        temp.add(p);
                    }
                }
                System.out.println("1.Filter by rating");
                System.out.println("2.Filter by likes");
                System.out.println("3.Filter by most solved");
                int ch = sc.nextInt();
                if (ch == 1) {
                    temp.sort((a, b) -> Integer.compare(a.score, b.score));
                } else if (ch == 2) {
                    temp.sort((a, b) -> Integer.compare(a.likes, b.likes));
                } else if (ch == 3) {
                    temp.sort((a, b) -> Integer.compare(a.count, b.count));
                } else {
                    System.out.println("No filter Applied");
                }
                for (Problem p : temp) {
                    System.out.println(p.tag + " " + p.problem_name + " " + p.description + " " + p.difficulty + " " + p.score);
                }
            } else if (n == 2) {
                sc.nextLine();
                System.out.println("Enter tag to solve");
                String inp = sc.nextLine();
                if (ob1.prob_map.containsKey(inp)) {
                    int z = ob1.prob_map.get(inp);
                    int y = ob2.users_map.get(uname);
                    ob1.problems.get(z).count += 1;
                    ob2.contestants.get(y).score += ob1.problems.get(z).score;

                    System.out.println("would u like to give a like?");
                    String reply = sc.nextLine();
                    if (reply.equals("yes")) {
                        ob1.problems.get(z).likes += 1;
                    }


                } else {
                    System.out.println("incorrect tag");
                }
            } else {
                System.out.println("logout sucess");
                break;
            }
        }
        }

    }

