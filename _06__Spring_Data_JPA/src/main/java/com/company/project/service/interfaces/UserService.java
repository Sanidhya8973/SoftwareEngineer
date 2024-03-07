package com.company.project.service.interfaces;

import com.company.project.model.User;

import java.util.List;

public interface UserService {

    public abstract List<User> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir);

    public abstract User createUser(User user) throws Exception;

    public abstract List<User> createUsers(List<User> userList) throws Exception;

    public abstract User readUser(Long id) throws Exception;

    public abstract List<User> readUsers();

    public abstract User updateUser(Long id, User user) throws Exception;

    public abstract String deleteUser(Long id) throws Exception;

    public abstract User patchUser(Long id, User user) throws Exception;

}

