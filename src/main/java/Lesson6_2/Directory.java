package Lesson6_2;

import org.json.JSONObject;

import java.util.Date;

public class Directory implements Validate {
    private final int directoryId; // Сделаем обязательным, но неизменяемым
    private Domain domain;
    private String baseName;
    private String tableName;
    private String seqName;
    private String source;
    private String code;
    private String urn;
    private String shortName;
    private String version;
    private Date versionDate;
    private final Date creationDate;
    private Date updateDate;
    private User creator;
    private boolean external = false;
    private boolean published = true;
    private PublishType publishType = PublishType.NONE;


    // Обязательные поля добавим в конструктор, остальные будем заполнять вручную
    public Directory(int id, String baseName, String tableName) {
        this.directoryId = id;
        this.baseName = validateString(baseName, 255, true);
        this.tableName = validateString(tableName, 255, true);
        creationDate = new Date();
        updateDate = creationDate;
    }

    private void refreshUpdateDate() {
        updateDate = new Date();
    }

    public int getDirectoryId() {
        return directoryId;
    }

    public String getDomain() {
        return domain.createJson().toString();
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
        refreshUpdateDate();
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = validateString(baseName, 255, true);
        refreshUpdateDate();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = validateString(tableName, 255, true);
        refreshUpdateDate();
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = validateString(seqName, 255, false);
        refreshUpdateDate();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = validateString(source, 8, false);
        refreshUpdateDate();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = validateString(code, 255, false);
        refreshUpdateDate();
    }

    public String getUrn() {
        return urn;
    }

    public void setUrn(String urn) {
        this.urn = validateString(urn, 255, false);
        refreshUpdateDate();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = validateString(shortName, 255, false);
        refreshUpdateDate();
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = validateString(version, 255, false);
        refreshUpdateDate();
    }

    public Date getVersionDate() {
        return versionDate;
    }

    public void setVersionDate(Date versionDate) {
        this.versionDate = versionDate;
        refreshUpdateDate();
    }

    public String getCreator() {
        return creator.createJson().toString();
    }

    public void setCreator(User creator) {
        this.creator = creator;
        refreshUpdateDate();
    }

    public boolean getExternal() {
        return external;
    }

    public void setExternal(boolean external) {
        this.external = external;
        refreshUpdateDate();
    }

    public boolean getPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
        refreshUpdateDate();
    }

    public String getPublishType() {
        return publishType.getValue();
    }

    public void setPublishType(PublishType publishType) {
        this.publishType = publishType;
        refreshUpdateDate();
    }

    public JSONObject createJson() {
        JSONObject resultJson = new JSONObject();
        resultJson.put("id", directoryId);
        resultJson.put("base_name", baseName);
        resultJson.put("table_name", tableName);
        resultJson.put("seq_ame", seqName);
        resultJson.put("source", source);
        resultJson.put("code", code);
        resultJson.put("urn", urn);
        resultJson.put("short_name", shortName);
        resultJson.put("version", version);
        resultJson.put("version_date", versionDate);
        resultJson.put("creation_date", creationDate);
        resultJson.put("update_date", updateDate);
        resultJson.put("creator_id", creator.getUserId());
        resultJson.put("external", external);
        resultJson.put("published", published);
        resultJson.put("publish_type", publishType);
        return resultJson;
    }
}