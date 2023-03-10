package com.example.demo3.service;

import com.example.demo3.entity.User;

import java.util.List;

public interface UserService {

    /**Returns User with given email
     *
     * @param email
     * @return User
     */
    User findByEmail(String email);

    /**Saves given User to database
     *
     * @param user
     */
    void saveUser(User user);

    /**Returns list of all Users
     *
     * @return list of Users
     */
    List<User> findAll();

    /**Returns list of Users with given user as their supervisor
     *
     * @param user
     * @return list of Users
     */
    List<User> findBySupervisor(User user);

    /**Returns max value of contract that user can accept from all his roles
     *
     * @param user
     * @return max value of contract that user can accept
     */
    Double getMaxContractValue(User user);

}