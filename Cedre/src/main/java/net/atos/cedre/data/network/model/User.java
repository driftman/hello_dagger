package net.atos.cedre.data.network.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by abk on 30/03/2018.
 */

public class User {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("username")
    private String username;
    @SerializedName("email")
    private String email;

    public User() {}

    public User(Integer id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
