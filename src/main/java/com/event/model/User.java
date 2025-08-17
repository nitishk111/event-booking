package com.event.model;

import jakarta.persistence.*;

@Entity(name="User")
@Table(name = "user_detail")
@NamedQueries(
        @NamedQuery(
                name="User.authenticate",
                query="Select u from User u WHERE u.userEmail= :userEmail AND u.userPassword =: userPassword"
        )
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="user_name", nullable = false)
    private String userName;

    @Column(name="user_email",unique = true, nullable = false)
    private String userEmail;

    @Column(name="user_password",nullable = false)
    private String userPassword;

    public User(){

    }

    public User(String userName, String userEmail, String userPassword) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }
}
