package com.company._02__WebService.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import com.company._02__WebService.service.interfaces.UserService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.company._02__WebService.repository.UserRepository;
import com.company._02__WebService.entity.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;

@Service(value = "service_user")
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> doPaginationAndSorting(int pageNumber, int pageSize, String[] sortBy, String sortDir) {
        List<Order> orderList = new ArrayList<>();
        for (int i = 0; i < sortBy.length; i++) {
            Order order = null;
            if (sortDir.equalsIgnoreCase(Sort.Direction.DESC.name())) {
                order = new Order(Sort.Direction.DESC, sortBy[i]);
            } else {
                order = new Order(Sort.Direction.ASC, sortBy[i]);
            }
            orderList.add(order);
        }
        Sort sort = Sort.by(orderList);
        Pageable pageable = PageRequest.of(pageNumber, pageSize, sort);
        Page<User> userPage = userRepository.findAll(pageable);
        List<User> userList = userPage.getContent();
        return userList;
    }

    @Override
    public User createUser(User user) throws Exception {
        if (null != user) {
            return userRepository.save(user);
        } else {
            throw new Exception("EXCEPTION -> user can not be null");
        }
    }

    @Override
    public List<User> createUsers(List<User> userList) throws Exception {
        if (null != userList) {
            return userRepository.saveAll(userList);
        } else {
            throw new Exception("EXCEPTION -> users can not be null");
        }
    }

    @Override
    public User readUser(Long id) throws Exception {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new Exception("EXCEPTION -> user not found in database");
        }
    }

    @Override
    public List<User> readUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(Long id, User user) throws Exception {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User updateUser = new User();
            if (user.getFirstName() != null) {
                updateUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                updateUser.setLastName(user.getLastName());
            }
            if (user.getEmail() != null) {
                updateUser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                updateUser.setPassword(user.getPassword());
            }
            if (user.getRoleList() != null) {
                updateUser.setRoleList(user.getRoleList());
            }
            return userRepository.save(updateUser);
        } else {
            throw new Exception("EXCEPTION -> user not found in database");
        }
    }

    @Override
    public String deleteUser(Long id) throws Exception {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "SUCCESS -> user deleted";
        } else {
            throw new Exception("EXCEPTION -> user not found in database");
        }
    }

    @Override
    public User patchUser(Long id, User user) throws Exception {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isPresent()) {
            User updateUser = new User();
            if (user.getId() != null) {
                updateUser.setId(user.getId());
            }
            if (user.getFirstName() != null) {
                updateUser.setFirstName(user.getFirstName());
            }
            if (user.getLastName() != null) {
                updateUser.setLastName(user.getLastName());
            }
            if (user.getEmail() != null) {
                updateUser.setEmail(user.getEmail());
            }
            if (user.getPassword() != null) {
                updateUser.setPassword(user.getPassword());
            }
            if (user.getRoleList() != null) {
                updateUser.setRoleList(user.getRoleList());
            }
            return userRepository.save(updateUser);
        } else {
            throw new Exception("EXCEPTION -> user not found in database");
        }
    }

}

