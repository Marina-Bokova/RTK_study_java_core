package Lesson6_2;

import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

import java.util.Date;

@Getter
@Setter
public class User implements Validate {
    private final int userId; // Сделаем обязательным, но неизменяемым
    private String login;
    private String name;
    private boolean active = true;
    private boolean group = false;
    private final Date creationDate;

    // Обязательные поля добавим в конструктор, остальные будем заполнять вручную
    public User(int userId) {
        this.userId = userId;
        creationDate = new Date();
    }

    public void setLogin(String login) {
        this.login = validateString(login, 255, false);
    }

    public void setName(String name) {
        this.name = validateString(name, 255, false);
    }


    public void setLoginAndName(String login, String name) {
        this.setLogin(login);
        this.setName(name);
    }

    public void setActiveAndGroup(boolean active, boolean group){
        this.setActive(active);
        this.setGroup(group);
    }

    public JSONObject createJson() {
        JSONObject resultJson = new JSONObject();
        resultJson.put("user_id", userId);
        resultJson.put("login", login);
        resultJson.put("name", name);
        resultJson.put("active", active);
        resultJson.put("is_group", group);
        resultJson.put("creation_date", creationDate);
        return resultJson;
    }
}
