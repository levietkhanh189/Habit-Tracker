package datacreate;

import manager.DAOManager;
import model.entity.Habit;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.entity.MyUser;

import java.util.Date;
public class CreateDefaultHabit {
    public static void main(String[] args) {
        Habit habit = new Habit("Default","\uFE0F⚽","Football",null,null,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Default","\uD83D\uDEB4","Ride bike",null,null,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Default","\uD83D\uDCD6","Read book",null,null,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Default","\uD83D\uDEAD","No smoking",null,null,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Default","\uD83D\uDE06","Smile",null,null,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Default","\uD83D\uDE34","Sleep early",null,null,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Default","\uD83C\uDF40","Water plant",null,null,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Default","\uFE0F\uD83C\uDFB6","Heard music",null,null,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
        habit = new Habit("Default","\uFE0F\uD83C\uDFBE","Tennis",null,null,"Good","Default");
        DAOManager.getInstance().getHabitDAO().create(habit);
    }
}
