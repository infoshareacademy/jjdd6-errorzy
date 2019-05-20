package com.infoshareacademy.jjdd6.errorzy.user;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class UserBean {

    @Inject
    UserDao userDao;

    public UserModel getUser(UserModel userModel) {
        UserModel user = userDao.findById(userModel.getUserId());
        if (user != null)
            return user;

        else {
            UserModel newUser = userDao.update(userModel);
            if (userDao.findAll().size() == 0) {
                newUser.setRoleAdministration(true);
            }
            userDao.save(newUser);
            return newUser;
        }

    }
}
