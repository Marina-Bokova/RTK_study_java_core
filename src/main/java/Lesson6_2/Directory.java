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

    public void setCodeAndShortName(String code, String shortName) {
        this.setCode(code);
        this.setShortName(shortName);
    }

    public void setSeqNameAndUrn(String seqName, String urn) {
        this.setSeqName(seqName);
        this.setUrn(urn);
    }

    public void setPublishTypeAndVersion(PublishType publishType, String version, Date versionDate) {
        this.setPublishType(publishType);
        this.setVersion(version);
        this.setVersionDate(versionDate);
    }

    public void setExternalAndPublished(boolean external, boolean published) {
        this.setExternal(external);
        this.setPublished(published);
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

    private static boolean customEquals(String parameter1, String parameter2) {
        if (parameter1 == null && parameter2 == null) {
            return true;
        } else if (parameter1 == null || parameter2 == null) {
            return false;
        }
        return parameter1.equals(parameter2);
    }

    public static void compareParameters(Directory object1, Directory object2) {
        System.out.println("ID справочников равны: " +
                (object1.getDirectoryId() == object2.getDirectoryId()));
        System.out.printf("  ID_1 = %d %n  ID_2 = %d %n",
                object1.getDirectoryId(), object2.getDirectoryId());
        System.out.println("\nДомены справочников равны: " +
                customEquals(object1.getDomain(), object2.getDomain()));
        System.out.printf("  domain_1 = %s %n  domain_2 = %s %n",
                object1.getDomain(), object2.getDomain());
        System.out.println("\nЗначения параметра \"BaseName\" справочников равны: " +
                customEquals(object1.getBaseName(), object2.getBaseName()));
        System.out.printf("  base_name_1 = %s %n  base_name_2 = %s %n",
                object1.getBaseName(), object2.getBaseName());
        System.out.println("\nЗначения параметра \"TableName\" справочников равны: " +
                customEquals(object1.getTableName(), object2.getTableName()));
        System.out.printf("  table_name_1 = %s %n  table_name_2 = %s %n",
                object1.getTableName(), object2.getTableName());
        System.out.println("\nЗначения параметра \"SeqName\" справочников равны: " +
                customEquals(object1.getSeqName(), object2.getSeqName()));
        System.out.printf("  seq_name_1 = %s %n  seq_name_2 = %s %n",
                object1.getSeqName(), object2.getSeqName());
        System.out.println("\nИсточники справочников равны: " +
                customEquals(object1.getSource(), object2.getSource()));
        System.out.printf("  source_1 = %s %n  source_2 = %s %n",
                object1.getSource(), object2.getSource());
        System.out.println("\nКоды справочников равны: " +
                customEquals(object1.getCode(), object2.getCode()));
        System.out.printf("  code_1 = %s %n  code_2 = %s %n",
                object1.getCode(), object2.getCode());
        System.out.println("\nЗначения параметра \"Urn\" справочников равны: " +
                customEquals(object1.getUrn(), object2.getUrn()));
        System.out.printf("  urn_1 = %s %n  urn_2 = %s %n",
                object1.getUrn(), object2.getUrn());
        System.out.println("\nКраткие наименования справочников равны: " +
                customEquals(object1.getShortName(), object2.getShortName()));
        System.out.printf("  short_name_1 = %s %n  short_name_2 = %s %n",
                object1.getShortName(), object2.getShortName());
        System.out.println("\nВерсии справочников равны: " +
                customEquals(object1.getVersion(), object2.getVersion()));
        System.out.printf("  version_1 = %s %n  version_2 = %s %n",
                object1.getVersion(), object2.getVersion());
        System.out.println("\nДаты создания данной версии справочников равны: " +
                object1.getVersionDate().equals(object2.getVersionDate()));
        System.out.printf("  version_date_1 = %s %n  version_date_2 = %s %n",
                object1.getVersionDate(), object2.getVersionDate());
        System.out.println("\nДаты создания справочников равны: " +
                object1.getCreationDate().equals(object2.getCreationDate()));
        System.out.printf("  creation_date_1 = %s %n  creation_date_2 = %s %n",
                object1.getCreationDate(), object2.getCreationDate());
        System.out.println("\nДаты последнего изменения справочников равны: " +
                object1.getUpdateDate().equals(object2.getUpdateDate()));
        System.out.printf("  update_date_1 = %s %n  update_date_2 = %s %n",
                object1.getUpdateDate(), object2.getUpdateDate());
        System.out.println("\nАвторы справочников равны: " +
                customEquals(object1.getCreator(), object2.getCreator()));
        System.out.printf("  creator_1 = %s %n  creator_2 = %s %n",
                object1.getCreator(), object2.getCreator());
        System.out.println("\nЗначения параметра \"external\" справочников равны: " +
                (object1.getExternal() == object1.getExternal()));
        System.out.printf("  external_1 = %s %n  external_2 = %s %n",
                object1.getExternal(), object2.getExternal());
        System.out.println("\nЗначения параметра \"published\" справочников равны: " +
                (object1.getPublished() == object1.getPublished()));
        System.out.printf("  published_1 = %s %n  published_2 = %s %n",
                object1.getPublished(), object2.getPublished());
        System.out.println("\nЗначения параметра \"publishType\" справочников равны: " +
                object1.getPublishType().equals(object1.getPublishType()));
        System.out.printf("  publishType_1 = %s %n  publishType_2 = %s %n",
                object1.getPublishType(), object2.getPublishType());
    }
}