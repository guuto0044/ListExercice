package Generics.SetExercicies.ex1.entities;

import java.util.Date;
import java.util.Objects;

public class User {

    private String nickname;
    private Date dateTime;

    public User(){

    }

    public User(String nickname, Date dateTime) {
        this.nickname = nickname;
        this.dateTime = dateTime;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(nickname, user.nickname);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nickname);
    }
}
