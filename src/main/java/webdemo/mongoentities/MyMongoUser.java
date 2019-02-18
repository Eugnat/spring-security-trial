package webdemo.mongoentities;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Document(collection = "mymongousers")
public class MyMongoUser {

    private String id;

    private String username;

    private String password;

    @DBRef
    private Set<MongoRole> roles;

    public MyMongoUser() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<MongoRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<MongoRole> roles) {
        this.roles = roles;
    }

    public void addRole(MongoRole role) {
        if (roles == null) {
            roles = new HashSet<>();
        }

        roles.add(role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyMongoUser that = (MyMongoUser) o;
        return username.equals(that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    @Override
    public String toString() {
        return "MyMongoUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
