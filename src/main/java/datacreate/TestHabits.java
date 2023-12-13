package datacreate;

import manager.DAOManager;
import model.entity.Account;
import model.entity.Habit;
import model.entity.MyUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class TestHabits {
    public static void main(String[] args) {
        List<Habit> userHabits = DAOManager.getInstance().getHabitDAO().findByType("Default");
        for (Habit habit : userHabits) {
            System.out.println("Habit Name: " + habit.getId());
        }
    }
}
