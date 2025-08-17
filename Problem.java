public class Problem {

    String problem_name;
    String description;
    String tag;
    String difficulty;
    int score;
    int likes;
    int count;

    Problem(String problem_name,String description,String tag,String difficulty,int score,int likes,int count){
        this.problem_name=problem_name;
        this.description=description;
        this.tag=tag;
        this.difficulty=difficulty;
        this.score=score;
        this.likes=likes;
        this.count=count;
    }
}
