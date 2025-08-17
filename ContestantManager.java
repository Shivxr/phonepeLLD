import java.lang.constant.Constable;
import java.util.*;
public class ContestantManager {
    List<Contestant> contestants=new ArrayList<>();
    Map<String,Integer> users_map=new HashMap<>();

    protected void add(Contestant value){
        contestants.add(value);
    }

    protected void add_user(){
        int f=0;
        Scanner sc=new Scanner(System.in);
        root:
        while(true){
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            for(Contestant c:contestants){
                if(c.username.equals(username) || username.isEmpty()){
                    f=1;
                    System.out.println("username already exists or empty username");
                    System.out.println("press 0 to exit");
                    int n=sc.nextInt();
                    if(n==0){
                        break root;
                    }
                }
            }
            if(f==1){
                sc.nextLine();
                continue;
            }
            System.out.print("Enter password: ");
            String password = sc.nextLine();

            add(new Contestant(0,username,password," "));
            users_map.put(username,contestants.size()-1);
            System.out.println("account created successfully !");
            break root;
        }
    }
    protected String auth(){
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            if(users_map.containsKey(username)){
                if(contestants.get(users_map.get(username)).password.equals(password)){
                    System.out.println("user "+username+" has logged in");
                    return username;
                }
                else{
                    System.out.println("incorrect password");
                }
            }
            else{
                System.out.println("incorrect username");
            }
            System.out.println("enter 0 to quit");
            String q=sc.nextLine();
            if(q.equals("0")){
                System.out.println("Authentication Revoked");
                return "";
            }
        }
    }
}
