package manager;
import jakarta.inject.Inject;
import model.dao.*;
import jakarta.persistence.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
public class DAOManager {

    private static DAOManager instance;

    private MyUserDAO myUserDAO;
    private HabitDAO habitDAO;
    private MoodTrackerDAO moodTrackerDAO;
    private AccountDAO accountDAO;
    private ActivityDAO activityDAO;
    private ChallengeDAO challengeDAO;
    private  ConnectDAO connectDAO;
    private  ConnectInfoDAO connectInfoDAO;
    private  HabitTrackerDAO habitTrackerDAO;
    private ReminderDAO reminderDAO;

    private DAOManager() {
        managerProducer = new EntityManagerProducer();
        entityManagerFactory = managerProducer.createEntityManagerFactory();
        entityManager = managerProducer.createEntityManager(entityManagerFactory);

        myUserDAO = new MyUserDAO(entityManager);
        habitDAO = new HabitDAO(entityManager);
        moodTrackerDAO = new MoodTrackerDAO(entityManager);
        activityDAO = new ActivityDAO(entityManager);
        accountDAO = new AccountDAO(entityManager);
        challengeDAO = new ChallengeDAO(entityManager);
        connectDAO = new ConnectDAO(entityManager);
        connectInfoDAO = new ConnectInfoDAO(entityManager);
        habitTrackerDAO = new HabitTrackerDAO(entityManager);
        reminderDAO = new ReminderDAO(entityManager);
    }

    private EntityManagerProducer managerProducer;
    @Inject
    private EntityManagerFactory entityManagerFactory;

    @Inject
    private EntityManager entityManager;

    public static synchronized DAOManager getInstance() {
        if (instance == null) {
            instance = new DAOManager();
        }
        return instance;
    }

    public MyUserDAO getMyUserDAO() {
        return myUserDAO;
    }

    public HabitDAO getHabitDAO() {
        return habitDAO;
    }

    public MoodTrackerDAO getMoodTrackerDAO() {
        return moodTrackerDAO;
    }

    public AccountDAO getAccountDAO() { return accountDAO; }
    public ChallengeDAO getChallengeDAO() { return challengeDAO; }
    public ConnectDAO getConnectDAO() {
        return connectDAO;
    }
    public ActivityDAO getActivityDAO() {return activityDAO;}
    public ConnectInfoDAO getConnectInfoDAO(){return connectInfoDAO;}
    public HabitTrackerDAO getHabitTrackerDAO(){return habitTrackerDAO;}
    public ReminderDAO getReminderDAO(){return reminderDAO;}
}

