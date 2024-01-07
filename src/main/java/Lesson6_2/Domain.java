package Lesson6_2;

import org.json.JSONObject;

import java.util.Date;

public class Domain implements Validate {
    private final int domainId; // Сделаем обязательным, но неизменяемым
    private String code;
    private String schema;
    private String urn;
    private String name;
    private String description;
    private boolean entity = false;
    private boolean system = false;
    private final Date creationDate;
    private User creator;

    // Обязательные поля добавим в конструктор, остальные будем заполнять вручную
    public Domain(int id, String schema) {
        this.domainId = id;
        this.schema = validateString(schema, 32, true);
        creationDate = new Date();
    }

    public int getDomainId() {
        return domainId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = validateString(code, 31, false);
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = validateString(schema, 32, true);
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = validateString(urn, 255, false);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = validateString(name, 255, false);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = validateString(description, 1023, false);
    }

    public boolean getEntity() {
        return entity;
    }

    public void setEntity(boolean entity) {
        this.entity = entity;
    }

    public boolean getSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public String getCreator() {
        return creator.createJson().toString();
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public void setCodeAndUrn(String code, String urn) {
        this.setCode(code);
        this.setUrn(urn);
    }

    public void setNameAndDescription(String name, String description) {
        this.setName(name);
        this.setDescription(description);
    }

    public void setEntityAndSystem(boolean entity, boolean system) {
        this.setEntity(entity);
        this.setSystem(system);
    }

    public JSONObject createJson() {
        JSONObject resultJson = new JSONObject();
        resultJson.put("id", domainId);
        resultJson.put("code", code);
        resultJson.put("schema", schema);
        resultJson.put("urn", urn);
        resultJson.put("name", name);
        resultJson.put("entity", entity);
        resultJson.put("system", system);
        resultJson.put("description", description);
        resultJson.put("creation_date", creationDate);
        resultJson.put("creator_id", creator.getUserId());
        return resultJson;
    }
}
