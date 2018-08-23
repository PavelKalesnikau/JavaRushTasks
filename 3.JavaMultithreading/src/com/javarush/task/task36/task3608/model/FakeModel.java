package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<User>();
        users.add(new User("John", 1, 1));
        users.add(new User("Johny", 2, 1));
        users.add(new User("Cherry", 3, 2));
        users.add(new User("Tom", 4, 3));
        users.add(new User("Bob", 5, 1));
        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }
}
