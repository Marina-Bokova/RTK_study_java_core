package Lesson6_2;

public class DBClassesTheme implements Validate {
    public static void main(String[] args) {
        // Создадим пользователя и заполним его данными
        User user1 = new User(USER_ID);
        user1.setLogin(LOGIN);
        user1.setName(USER_NAME);
        System.out.println("\nИнформация по созданному пользователю:");
        System.out.println(user1.createJson().toString());

        // Создадим два домена и заполним их данными
        Domain domain1 = new Domain(DOMAIN_ID_1, SCHEMA_1);
        domain1.setCode(DOMAIN_CODE_1);
        domain1.setUrn(URN);
        domain1.setName(NAME_1);
        domain1.setDescription(DESCRIPTION_1);
        domain1.setCreator(user1);

        Domain domain2 = new Domain(DOMAIN_ID_2, SCHEMA_2);
        domain2.setCode(DOMAIN_CODE_2);
        domain2.setUrn(URN);
        domain2.setName(NAME_2);
        domain2.setEntity(ENTITY_2);
        domain2.setCreator(user1);

        System.out.println("\nИнформация о созданных доменах:");
        System.out.println("1. " + domain1.createJson().toString());
        System.out.println("2. " + domain2.createJson().toString());

        // Создадим два справочника и заполним их данными
        Directory directory1 = new Directory(DIRECTORY_ID_1, BASE_NAME_1, TABLE_NAME_1);
        directory1.setDomain(domain1);
        directory1.setCode(DIRECTORY_CODE_1);
        directory1.setUrn(URN_1);
        directory1.setShortName(SHORT_NAME);
        directory1.setPublishType(publishType_1);
        directory1.setVersion(VERSION_1);
        directory1.setVersionDate(VERSION_DATE_1);
        directory1.setCreator(user1);
        directory1.setExternal(EXTERNAL);

        Directory directory2 = new Directory(DIRECTORY_ID_2, BASE_NAME_2, TABLE_NAME_2);
        directory2.setDomain(domain2);
        directory2.setSeqName(SEQ_NAME_2);
        directory2.setCode(DIRECTORY_CODE_2);
        directory2.setShortName(SHORT_NAME);
        directory2.setCreator(user1);
        directory2.setExternal(EXTERNAL);
        directory2.setPublished(PUBLISHED_2);

        System.out.println("\nИнформация о созданных справочниках:");
        System.out.println("1. " + directory1.createJson().toString());
        System.out.println("2. " + directory2.createJson().toString());

        System.out.println("\nСравнение данных в справочниках:");
        System.out.println("Справочники равны: " + directory1.equals(directory2));
        System.out.println("\nID справочников равны: " +
                (directory1.getDirectoryId() == directory2.getDirectoryId()));
        System.out.printf("  ID_1 = %d %n  ID_2 = %d %n",
                directory1.getDirectoryId(), directory2.getDirectoryId());
        System.out.println("\nДомены справочников равны: " +
                Validate.customEquals(directory1.getDomain(), directory2.getDomain()));
        System.out.printf("  domain_1 = %s %n  domain_2 = %s %n",
                directory1.getDomain(), directory2.getDomain());
        System.out.println("\nЗначения параметра \"BaseName\" справочников равны: " +
                Validate.customEquals(directory1.getBaseName(), directory2.getBaseName()));
        System.out.printf("  base_name_1 = %s %n  base_name_2 = %s %n",
                directory1.getBaseName(), directory2.getBaseName());
        System.out.println("\nЗначения параметра \"TableName\" справочников равны: " +
                Validate.customEquals(directory1.getTableName(), directory2.getTableName()));
        System.out.printf("  table_name_1 = %s %n  table_name_2 = %s %n",
                directory1.getTableName(), directory2.getTableName());
        System.out.println("\nЗначения параметра \"SeqName\" справочников равны: " +
                Validate.customEquals(directory1.getSeqName(), directory2.getSeqName()));
        System.out.printf("  seq_name_1 = %s %n  seq_name_2 = %s %n",
                directory1.getSeqName(), directory2.getSeqName());
        System.out.println("\nИсточники справочников равны: " +
                Validate.customEquals(directory1.getSource(), directory2.getSource()));
        System.out.printf("  source_1 = %s %n  source_2 = %s %n",
                directory1.getSource(), directory2.getSource());
        System.out.println("\nКоды справочников равны: " +
                Validate.customEquals(directory1.getCode(), directory2.getCode()));
        System.out.printf("  code_1 = %s %n  code_2 = %s %n",
                directory1.getCode(), directory2.getCode());
        System.out.println("\nЗначения параметра \"Urn\" справочников равны: " +
                Validate.customEquals(directory1.getUrn(), directory2.getUrn()));
        System.out.printf("  urn_1 = %s %n  urn_2 = %s %n",
                directory1.getUrn(), directory2.getUrn());
        System.out.println("\nКраткие наименования справочников равны: " +
                Validate.customEquals(directory1.getShortName(), directory2.getShortName()));
        System.out.printf("  short_name_1 = %s %n  short_name_2 = %s %n",
                directory1.getShortName(), directory2.getShortName());
        System.out.println("\nВерсии справочников равны: " +
                Validate.customEquals(directory1.getVersion(), directory2.getVersion()));
        System.out.printf("  version_1 = %s %n  version_2 = %s %n",
                directory1.getVersion(), directory2.getVersion());
        System.out.println("\nДаты создания данной версии справочников равны: " +
                directory1.getVersionDate().equals(directory2.getVersionDate()));
        System.out.printf("  version_date_1 = %s %n  version_date_2 = %s %n",
                directory1.getVersionDate(), directory2.getVersionDate());
        System.out.println("\nДаты создания справочников равны: " +
                directory1.getCreationDate().equals(directory2.getCreationDate()));
        System.out.printf("  creation_date_1 = %s %n  creation_date_2 = %s %n",
                directory1.getCreationDate(), directory2.getCreationDate());
        System.out.println("\nДаты последнего изменения справочников равны: " +
                directory1.getUpdateDate().equals(directory2.getUpdateDate()));
        System.out.printf("  update_date_1 = %s %n  update_date_2 = %s %n",
                directory1.getUpdateDate(), directory2.getUpdateDate());
        System.out.println("\nАвторы справочников равны: " +
                Validate.customEquals(directory1.getCreator(), directory2.getCreator()));
        System.out.printf("  creator_1 = %s %n  creator_2 = %s %n",
                directory1.getCreator(), directory2.getCreator());
        System.out.println("\nЗначения параметра \"external\" справочников равны: " +
                (directory1.getExternal() == directory1.getExternal()));
        System.out.printf("  external_1 = %s %n  external_2 = %s %n",
                directory1.getExternal(), directory2.getExternal());
        System.out.println("\nЗначения параметра \"published\" справочников равны: " +
                (directory1.getPublished() == directory1.getPublished()));
        System.out.printf("  published_1 = %s %n  published_2 = %s %n",
                directory1.getPublished(), directory2.getPublished());
        System.out.println("\nЗначения параметра \"publishType\" справочников равны: " +
                directory1.getPublishType().equals(directory1.getPublishType()));
        System.out.printf("  publishType_1 = %s %n  publishType_2 = %s %n",
                directory1.getPublishType(), directory2.getPublishType());
    }
}