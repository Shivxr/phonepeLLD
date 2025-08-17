import java.util.*;
public class Menu {
    Library pm=new Library();
    ContestantManager cm=new ContestantManager();
    public void menu(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("1.Create Problem");
            System.out.println("2.Create User Account");
            System.out.println("3.User Login");
            System.out.println("4.Top 10 contestants");
            System.out.println("5.exit");
            int a=sc.nextInt();
            if(a==1){
                pm.add_problem();
            } else if (a == 2) {
                cm.add_user();
            }
            else if(a==3){
                String z=cm.auth();
                if(!z.isEmpty()){
                    Solver sp=new Solver(pm,cm);
                    sp.search_solve(z);
                }
            }
            else if(a==4){
                Leaders led=new Leaders();
                led.leaders(cm.contestants);
            }
            else{
                System.out.println("process revoked");
                break;
            }
        }
    }
}
