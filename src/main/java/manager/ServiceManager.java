package manager;
import service.*;
import model.dao.*;
public class ServiceManager {

    private static ServiceManager instance;

    private MyUserService myUserService;
    private HabitService habitService;
    private MoodTrackerService moodTrackerService;
    private AccountService accountService;
    private ActivityService activityService;
    private ChallengeService challengeService;
    private ConnectService connectService;
    private HabitTrackerService habitTrackerService;
    public SendEmailService sendEmailService = new SendEmailService();
    private ServiceManager() {
        myUserService = new MyUserService(DAOManager.getInstance().getMyUserDAO(),DAOManager.getInstance().getHabitDAO());
        habitService = new HabitService(DAOManager.getInstance().getHabitDAO());
        moodTrackerService = new MoodTrackerService(DAOManager.getInstance().getMoodTrackerDAO());
        accountService= new AccountService(DAOManager.getInstance().getAccountDAO(),DAOManager.getInstance().getMyUserDAO());
        activityService= new ActivityService(DAOManager.getInstance().getActivityDAO());
        challengeService= new ChallengeService(DAOManager.getInstance().getChallengeDAO());
        connectService= new ConnectService(DAOManager.getInstance().getConnectDAO());
        habitTrackerService= new HabitTrackerService(DAOManager.getInstance().getHabitTrackerDAO(),DAOManager.getInstance().getHabitDAO(),DAOManager.getInstance().getMyUserDAO(),DAOManager.getInstance().getChallengeDAO());
    }

    public static synchronized ServiceManager getInstance() {
        if (instance == null) {
            instance = new ServiceManager();
        }
        return instance;
    }

    public MyUserService getMyUserService() {
        return myUserService;
    }
    public HabitService getHabitService() {
        return habitService;
    }
    public MoodTrackerService getMoodTrackerService() {
        return moodTrackerService;
    }
    public AccountService getAccountService() {
        return accountService;
    }
    public ActivityService getActivityService() {return activityService;}
    public ChallengeService getChallengeService() {return challengeService;}
    public ConnectService getConnectService() {return connectService;}
    public HabitTrackerService getHabitTrackerService() {return habitTrackerService;}
}
