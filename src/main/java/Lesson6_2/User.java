package Lesson6_2;

import org.json.JSONObject;

import java.util.Date;

public class User implements Validate {
    private final int userId; // Сделаем обязательным, но неизменяемым
    private String login;
    private String name;
    private boolean active = true;
    private boolean isGroup = false;
    private final Date creationDate;

    // Обязательные поля добавим в конструктор, остальные будем заполнять вручную
    public User(int userId) {
        this.userId = userId;
        creationDate = new Date();
    }

    public int getUserId() {
        return userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = validateString(login, 255, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateString(name, 255, false);
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getIsGroup() {
        return isGroup;
    }

    public void setIsGroup(boolean isGroup) {
        this.isGroup = isGroup;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setLoginAndName(String login, String name) {
        this.setLogin(login);
        this.setName(name);
    }

    public void setActiveAndGroup(boolean active, boolean isGroup){
        this.setActive(active);
        this.setIsGroup(isGroup);
    }

    public JSONObject createJson() {
        JSONObject resultJson = new JSONObject();
        resultJson.put("user_id", userId);
        resultJson.put("login", login);
        resultJson.put("name", name);
        resultJson.put("active", active);
        resultJson.put("is_group", isGroup);
        resultJson.put("creation_date", creationDate);
        return resultJson;
    }
}
