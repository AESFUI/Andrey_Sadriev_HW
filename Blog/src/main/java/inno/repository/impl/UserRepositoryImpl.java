package inno.repository.impl;

import inno.model.Users;
import inno.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public boolean create(Users users) {
        //добавить запрет на создание другого юзера с тем же именем
        em.persist(users);
        return true;
    }

    /*@Override
    public boolean isExist(Users user) {
        if () {
            return true;
        }
        return false;
    }

    @Override
    public Users find(Long id) {
        TypedQuery<Users> query = em.createQuery("SELECT username FROM Users user", Users.class);
        return query.getResultList();
    }*/
}
