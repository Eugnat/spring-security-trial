package webdemo.mongoentities;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "mongoroles")
public class MongoRole {

    private String id;

    private String name;

    public MongoRole() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MongoRole{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MongoRole mongoRole = (MongoRole) o;
        return name.equals(mongoRole.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
