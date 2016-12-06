package inno.repository.impl;

import inno.model.Users;
import inno.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 * Created by Andrey Sadriev aka AESFUI on 28.11.2016.
 */

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository{

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean add(Users users) {
        if (isExist(users)) {
            return false; //до вас уже приходили
        } else {
            em.persist(users);
            return true;
        }
    }

    @Override
    //Возвращает true если пара логин/пароль совпадают с БД
    public boolean isExist(Users users) {
        String userName = users.getUserName();
        String password = users.getPassword();
        TypedQuery<Users> query = em.createQuery(
                "SELECT users from Users users WHERE username=:username and password=:password", Users.class);
        query.setParameter("username", userName);
        query.setParameter("password", password);

        if (!query.getResultList().isEmpty()) {
            return true;
        } else
            return false;
    }

    @Override
    //Возвращает true если пара логин/пароль совпадают с БД
    public boolean isExistForAuto(Users users) {
        String userName = users.getUserName();
        //String password = users.getPassword();
        TypedQuery<Users> query = em.createQuery(
                "SELECT users from Users users WHERE username=:username", Users.class);
        query.setParameter("username", userName);

        if (!query.getResultList().isEmpty()) {
            return true;
        } else
            return false;
    }
}
