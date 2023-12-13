package manager;

import model.entity.*;
import java.util.*;

public class AppManager {
    private static AppManager instance;
    private Account currentAccount;
    private MyUser currentUser;
    private List<HabitTracker> currentTracker;
    private Date currentDate;
    private String currentJsp= "/index.jsp";
    private List<HabitTracker> habitTrackers = new ArrayList<HabitTracker>();
    public static synchronized AppManager getInstance() {
        if (instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    public Date getCurrentDate(){
        if(currentDate == null){
            currentDate = new Date();
        }
        return currentDate;
    }

    public void setCurrentUser(MyUser user){
        this.currentUser = user;
    }
    public MyUser getCurrentUser(){
        currentUser.setUserHabits(DAOManager.getInstance().getHabitDAO().findByUser(currentUser));
        return currentUser;
    }
    public String getCurrentJsp(){
        return currentJsp;
    }
    public void setCurrentJsp(String url){
        this.currentJsp = url;
    }

    public void setCurrentAccount(Account account){
        this.currentAccount = account;
    }
    public Account getCurrentAccount(){
        return currentAccount;
    }
    public List<HabitTracker> getCurrentTracker(){return habitTrackers;}
    public void setCurrentTracker(List<HabitTracker> habitTrackers){this.habitTrackers = habitTrackers;}
}
