package datacreate;

import manager.DAOManager;
import model.entity.*;

import java.util.Date;

public class CreateDefaultChallenge {
    public static void main(String[] args) {
        //Challenge(String name, String description, Date startDate, Date endDate)
        Challenge challenge = new Challenge("\uD83E\uDD14 Challenge 1","Just for testing",new Date(),new Date());
        DAOManager.getInstance().getChallengeDAO().save(challenge);
        Habit habit = new Habit("Challenge","\uFE0F⚽","Football Challenge",null,challenge,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Challenge","\uD83D\uDEB4","Ride bike Challenge",null,challenge,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Challenge","\uD83D\uDCD6","Read book Challenge",null,challenge,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Challenge","\uD83D\uDEAD","No smoking Challenge",null,challenge,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);

        challenge = new Challenge("\uD83E\uDD14 Challenge 2","Just for testing",new Date(),new Date());
        DAOManager.getInstance().getChallengeDAO().save(challenge);
        habit = new Habit("Challenge","\uD83D\uDE06","Smile Challenge",null,challenge,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Challenge","\uD83D\uDE34","Sleep early Challenge",null,challenge,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Challenge","\uD83C\uDF40","Water plant Challenge",null,challenge,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);

        challenge = new Challenge("\uD83E\uDD14 Challenge 3","Just for testing",new Date(),new Date());
        DAOManager.getInstance().getChallengeDAO().save(challenge);
        habit = new Habit("Challenge","\uFE0F\uD83C\uDFB6","Heard music Challenge",null,challenge,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Challenge","\uFE0F\uD83C\uDFBE","Tennis Challenge",null,challenge,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
    }
}
