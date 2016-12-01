package inno.repository;

import inno.model.Users;


public interface UserRepository {

    //List<Post> findAll();

    //Users find(Long id);

    boolean add(Users users);

    boolean isExist(Users user);

    public boolean isExistForAuto(Users users);

    //boolean remove(Long id);

    //List<Post> findByText(String text);

}
