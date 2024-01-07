package Lesson6_2;

import static Lesson6_2.Directory.compareParameters;

public class DBClassesTheme implements Validate {
    public static void main(String[] args) {
        // Создадим пользователя и заполним его данными
        User user1 = new User(USER_ID);
        user1.setLoginAndName(LOGIN, USER_NAME);
        System.out.println("\nИнформация по созданному пользователю:");
        System.out.println(user1.createJson().toString());

        // Создадим два домена и заполним их данными
        Domain domain1 = new Domain(DOMAIN_ID_1, SCHEMA_1);
        domain1.setCodeAndUrn(DOMAIN_CODE_1, URN);
        domain1.setNameAndDescription(NAME_1, DESCRIPTION_1);
        domain1.setCreator(user1);

        Domain domain2 = new Domain(DOMAIN_ID_2, SCHEMA_2);
        domain2.setCodeAndUrn(DOMAIN_CODE_2, URN);
        domain2.setName(NAME_2);
        domain2.setEntity(ENTITY_2);
        domain2.setCreator(user1);

        System.out.println("\nИнформация о созданных доменах:");
        System.out.println("1. " + domain1.createJson().toString());
        System.out.println("2. " + domain2.createJson().toString());

        // Создадим два справочника и заполним их данными
        Directory directory1 = new Directory(DIRECTORY_ID_1, BASE_NAME_1, TABLE_NAME_1);
        directory1.setDomain(domain1);
        directory1.setCodeAndShortName(DIRECTORY_CODE_1, SHORT_NAME);
        directory1.setUrn(URN_1);
        directory1.setPublishTypeAndVersion(publishType_1, VERSION_1, VERSION_DATE_1);
        directory1.setCreator(user1);
        directory1.setExternal(EXTERNAL);

        Directory directory2 = new Directory(DIRECTORY_ID_2, BASE_NAME_2, TABLE_NAME_2);
        directory2.setDomain(domain2);
        directory2.setSeqName(SEQ_NAME_2);
        directory1.setCodeAndShortName(DIRECTORY_CODE_2, SHORT_NAME);
        directory2.setCreator(user1);
        directory2.setExternalAndPublished(EXTERNAL, PUBLISHED_2);

        System.out.println("\nИнформация о созданных справочниках:");
        System.out.println("1. " + directory1.createJson().toString());
        System.out.println("2. " + directory2.createJson().toString());

        System.out.println("\nСравнение справочников:");
        System.out.println("Справочники равны: " + directory1.equals(directory2));
        System.out.println("\nСравнение данных в справочниках:");
        compareParameters(directory1, directory2);
    }
}