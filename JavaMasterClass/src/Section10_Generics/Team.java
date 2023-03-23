package Section10_Generics;

import java.util.ArrayList;

public class Team<T extends Player /* & Coach & Manager */>  {
    private String name;
    int played = 0;
    int won = 0;
    int tied = 0;
    int lost = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {

        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean addPlayer(T player){
        if(members.contains(player)){
            System.out.println(player.getName() + " is already on the team");
            return false;
        }
        else {
            members.add(player);
            System.out.println(player.getName() + " picked for the team " + this.name);
            return true;
        }
    }
    public int numPlayers(){
        return this.members.size();
    }

    public void matchResults(Team<T> opponent, int ourScore, int theirScore){
        String message;
        if(ourScore > theirScore){
            won++;
            message = "Beat";
        } else if (ourScore == theirScore) {
            tied++;
            message = "drew with ";
        }
        else{
            lost++;
            message = "lost to ";
        }
        if(opponent != null){
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResults(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (won * 2) + tied;
    }

}
