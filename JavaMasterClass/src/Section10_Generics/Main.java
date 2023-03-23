package Section10_Generics;

public class Main {
    public static void main(String[] args) {
        FootBallPlayer jed = new FootBallPlayer("Joe");
        BaseBallPlayer pat = new BaseBallPlayer("Pat");
        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<FootBallPlayer> crows = new Team<>("Crows");
        crows.addPlayer(jed);
//        crows.addPlayer(pat);
//        crows.addPlayer(beckham);
        Team<BaseBallPlayer> baseBallTeam = new Team<>("Cubs");
        baseBallTeam.addPlayer(pat);


    }


}
