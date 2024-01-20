package Lesson6_2;

import java.util.Calendar;
import java.util.Date;

public interface InputData {
    // Пользователь
    int USER_ID = 1;
    String LOGIN = "admin";
    String USER_NAME = "Администратор";

    // Домен. Создадим 2 домена. Значения будем задавать в 1 строке, для удобства
    int DOMAIN_ID_1 = 1, DOMAIN_ID_2 = 13;
    String DOMAIN_CODE_1 = "foms", DOMAIN_CODE_2 = "esnsi";
    String SCHEMA_1 = "foms", SCHEMA_2 = "esnsi";
    String URN = "urn:{domainCode}:{code}"; // Значения задаются одинаковые, поэтому 1 переменная
    String NAME_1 = "ФОМС", NAME_2 = "ЕСНСИ";
    String DESCRIPTION_1 = "Фонд обязательного медицинского страхования"; // Будет только у первого
    boolean ENTITY_2 = true; // Будет только у второго

    // Справочника. Тоже два
    int DIRECTORY_ID_1 = 5, DIRECTORY_ID_2 = 10;
    String BASE_NAME_1 = "foms__f032", BASE_NAME_2 = "esnsi__837";
    String TABLE_NAME_1 = "foms__f032__1_330", TABLE_NAME_2 = "esnsi__837__2539";
    String SEQ_NAME_2 = "seq__esnsi__837";
    String DIRECTORY_CODE_1 = "F032", DIRECTORY_CODE_2 = "837";
    String URN_1 = "urn:foms:F032";
    String SHORT_NAME = "Тестовый справочник";
    String VERSION_1 = "1.330";
    Date VERSION_DATE_1 = new Date(2022, Calendar.APRIL, 25, 14, 53, 33);
    boolean EXTERNAL = true;
    boolean PUBLISHED_2 = true;
    PublishTypeEnum publishType_1 = PublishTypeEnum.VERSION;

    // Сообщения об ошибках
    String LENGTH_ERROR_MESSAGE = "ERROR: Длина строки не должна превышать 255 символов";
    String EMPTY_ERROR_MESSAGE = "ERROR: Строка не может быть пустой";
}