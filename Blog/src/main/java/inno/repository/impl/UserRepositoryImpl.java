package inno.repository.impl;

import inno.model.Post;
import inno.model.User;
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
    public boolean create(User user) {
        //добавить запрет на создание другого юзера с тем же именем
        em.persist(user);
        return true;
    }

    /*@Override
    public boolean isExist(User user) {
        if () {
            return true;
        }
        return false;
    }

    @Override
    public User find(Long id) {
        TypedQuery<User> query = em.createQuery("SELECT username FROM User user", User.class);
        return query.getResultList();
    }*/
}
