package datacreate;

import manager.DAOManager;
import model.entity.Account;
import model.entity.MyUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;

public class TestDB {
    public static void main(String[] args) {
        Account account = new Account();
        account.setUsername("test123@gmail.com");
        account.setPassword("test123");
        MyUser myUser = new MyUser();
        myUser.setName("Test");
        myUser.setBirthday(new Date());
        myUser.setGender("male");
        account.setUser(myUser);
        DAOManager.getInstance().getMyUserDAO().create(myUser);
        DAOManager.getInstance().getAccountDAO().create(account);
    }
}
