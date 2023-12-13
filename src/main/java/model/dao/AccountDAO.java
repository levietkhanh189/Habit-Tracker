package model.dao;

import model.entity.Account;
import model.entity.MyUser;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class AccountDAO {

    private EntityManager entityManager;

    public AccountDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void create(Account account) {
        entityManager.getTransaction().begin();
        try {
            entityManager.persist(account);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    public Account findById(Long accountId) {
        return entityManager.find(Account.class, accountId);
    }

    public List<Account> findAll() {
        TypedQuery<Account> query = entityManager.createNamedQuery("Account.findAll", Account.class);
        return query.getResultList();
    }

    public Account findByUsername(String username) {
        TypedQuery<Account> query = entityManager.createNamedQuery("Account.findByUsername", Account.class);
        query.setParameter("username", username);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Account findByUserId(Long userId) {
        TypedQuery<Account> query = entityManager.createNamedQuery("Account.findByUserId", Account.class);
        query.setParameter("userId", userId);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public Account findByUsernameAndPassword(String username, String password) {
        TypedQuery<Account> query = entityManager.createNamedQuery("Account.findByUsernameAndPassword", Account.class);
        query.setParameter("username", username);
        query.setParameter("password", password);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Account> findAllWithUser() {
        TypedQuery<Account> query = entityManager.createNamedQuery("Account.findAllWithUser", Account.class);
        return query.getResultList();
    }

    public List<Account> findAllWithUserAndNullableUser() {
        TypedQuery<Account> query = entityManager.createNamedQuery("Account.findAllWithUserAndNullableUser", Account.class);
        return query.getResultList();
    }

    public long countAll() {
        TypedQuery<Long> query = entityManager.createNamedQuery("Account.countAll", Long.class);
        return query.getSingleResult();
    }

    public void deleteByUsername(String username) {
        entityManager.getTransaction().begin();
        try {
            TypedQuery<Account> query = entityManager.createNamedQuery("Account.deleteByUsername", Account.class);
            query.setParameter("username", username);
            Account account = query.getSingleResult();
            entityManager.remove(account);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }
    public void updateAccount(Account account) {
        entityManager.getTransaction().begin();
        try {
            // Thay đổi trực tiếp trên đối tượng quản lý
            Account managedAccount = entityManager.find(Account.class, account.getId());
            managedAccount.setUsername(account.getUsername());
            managedAccount.setPassword(account.getPassword());
            // Thêm các thay đổi khác nếu cần
            // ...

            // Gọi flush để đẩy thay đổi xuống cơ sở dữ liệu
            entityManager.flush();

            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }


    // Other methods related to Account

    // Example method: Get user for a specific account
    public MyUser getUserForAccount(Account account) {
        return account.getUser();
    }
}
