package com.chanchifeng.model;

import javax.persistence.*;

@Entity
public class User {
    private Integer uid;
    private String uname;

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Basic
    @Column(name = "uname")
    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        User user = (User) o;

        if (uid != null ? !uid.equals(user.uid) : user.uid != null) {
            return false;
        }
        if (uname != null ? !uname.equals(user.uname) : user.uname != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = uid != null ? uid.hashCode() : 0;
        result = 31 * result + (uname != null ? uname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                '}';
    }
}
