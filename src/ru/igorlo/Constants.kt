package ru.igorlo

object Constants {
    const val DB_NAME_DEFAULT = "rpg_game"
    const val DB_USER_DEFAULT = "94405"
    const val DB_PASS_DEFAULT = "440533"
    const val DB_HOST_DEFAULT = "localhost"
    const val DB_PORT_DEFAULT = 5432

    const val GEN_ITEMS_QUANTITY_DEFAULT = 7
    const val GEN_ITEMS_MIN_DAMAGE = 1
    const val GEN_ITEMS_MIN_WEIGHT = 1
    const val GEN_ITEMS_MIN_PRICE = 1
    const val GEN_ITEMS_MAX_DAMAGE = 50 - GEN_ITEMS_MIN_DAMAGE
    const val GEN_ITEMS_MAX_WEIGHT = 20 - GEN_ITEMS_MIN_WEIGHT
    const val GEN_ITEMS_MAX_PRICE = 5000 - GEN_ITEMS_MIN_PRICE

    const val GEN_SKILLS_QUANTITY_DEFAULT = 5
    const val GEN_SKILLS_MIN_MULT = 0.1
    const val GEN_SKILLS_MAX_MULT = 10.0 - GEN_SKILLS_MIN_MULT

    const val GEN_LOCATIONS_QUANTITY_DEFAULT = 4
    const val GEN_LOCATIONS_MIN_X = 1
    const val GEN_LOCATIONS_MIN_Y = 1
    const val GEN_LOCATIONS_MAX_X = 1000 - GEN_LOCATIONS_MIN_X
    const val GEN_LOCATIONS_MAX_Y = 1000 - GEN_LOCATIONS_MIN_Y

    const val GEN_CITIES_QUANTITY_DEFAULT = 1

    const val TEXT_INTRO = "\n\n" +
            "\t----------------------------------------------------------------\n" +
            "\tWelcome to the data generator for Postgres DB. This program will\n" +
            "\task to input some parameters required for data generation. After\n" +
            "\tcollecting all required data it will connect to selected DB and\n" +
            "\tfill tables with random data.\n\n" +
            "\t\t   Created by Igor Lopatinskiy for university project.\n" +
            "\t\t\t\t\t\t\t   Spring 2019\n" +
            "\t\t\t------------------------------------------------\n\n"

    val GEN_ITEMS_NAMES = listOf(
        "Меч",
        "Топор",
        "Сабля",
        "Катана",
        "Молот",
        "Нож",
        "Клинок",
        "Алебарда",
        "Рубак"
    )

    val GEN_SKILLS_NAMES = listOf(
        "Двойное сальто",
        "Арабское сальто",
        "Удар в челюсть",
        "Нечестный удар",
        "Самурайский замах",
        "Апперкот",
        "Удар в печень",
        "Удар с разворота",
        "Слабый удар",
        "Средний удар",
        "УДАРРРР",
        "Щекотушки"
    )

    val GEN_LOCATIONS_NAMES = listOf(
        "Перелесок",
        "Бор",
        "Роща",
        "Лесок",
        "Согра",
        "Чернь",
        "Кедрач",
        "Кедровник",
        "Колок",
        "Крепеж",
        "Чаща",
        "Осинник",
        "Редколесье",
        "Мангр",
        "Вязник",
        "Дром",
        "Лесочек",
        "Парма",
        "Строй",
        "Множество",
        "Зеленый наряд",
        "Зеленый океан",
        "Зеленый цех",
        "Краснолесье",
        "Бережняк",
        "Мостовинник",
        "Валеж",
        "Высокарник",
        "Росляк",
        "Грива",
        "Зеленка",
        "Дровяник",
        "Жальгирис",
        "Бессучник",
        "Ясенник",
        "Бревенчак",
        "Бревенник",
        "Буковник",
        "Марь",
        "Урема",
        "Гилея",
        "Кибела",
        "Сельвасы",
        "Ферония",
        "Березняк",
        "Дубрава",
        "Ельник",
        "Пуща",
        "Стройлес",
        "Сосняк",
        "Высокост",
        "Грабняк",
        "Дубняк",
        "Пихтарни",
        "Рамень",
        "Липняк",
        "Урман",
        "Тайга",
        "Криволесье",
        "Тугай",
        "Моль",
        "Лесишко",
        "Лесище",
        "Чащоба",
        "Целик",
        "Уйма",
        "Тьма",
        "Пропасть",
        "Глушник",
        "Глушняк",
        "Пан",
        "Левада",
        "Масса",
        "Гривняк",
        "Тьма-тьмущая"
    )

    val GEN_CITIES_NAMES = listOf(
        "Санкт-Петербург",
        "Амстердам",
        "Антверпен",
        "Афины",
        "Барселона",
        "Берлин",
        "Брюгге",
        "Варшава",
        "Вашингтон",
        "Вена",
        "Венеция",
        "Гагра",
        "Гамбург",
        "Геленджик",
        "Дрезден",
        "Дубай",
        "Дубровник",
        "Евпатория",
        "Ейск",
        "Екатеринбург",
        "Женева",
        "Загреб",
        "Иерусалим",
        "Ижевск",
        "Иркутск",
        "Йошкар-Ола",
        "Казань",
        "Кёльн",
        "Киев",
        "Лас-Вегас",
        "Лондон",
        "Лос-Анджелес",
        "Мадрид",
        "Милан",
        "Минск",
        "Москва",
        "Мюнхен",
        "Неаполь",
        "Новосибирск",
        "Нью-Йорк",
        "Одесса",
        "Омск",
        "Осло",
        "Париж",
        "Пекин",
        "Прага",
        "Рим",
        "Рио-де-Жанейро",
        "Ростов-на-Дону",
        "Севастополь",
        "София",
        "Сочи",
        "Таллин",
        "Тбилиси",
        "Тель-Авив",
        "Ульяновск",
        "Уфа",
        "Филадельфия",
        "Флоренция",
        "Хайфа",
        "Ханой",
        "Харьков",
        "Хельсинки",
        "Хошимин",
        "Цюрих",
        "Чебоксары",
        "Челябинск",
        "Чикаго",
        "Шанхай",
        "Штутгарт",
        "Щецин",
        "Эйлат",
        "Эйндховен",
        "Юрмала",
        "Якутск",
        "Ялта",
        "Ярославль"
    )

    val NAMES_FIRSTNAME_FIRSTHALF = listOf(
        "Ветро",
        "Древо",
        "Пещеро",
        "Стале",
        "Пиво",
        "Велико",
        "Старо",
        "Дубо",
        "Камне",
        "Чиче",
        "Михо",
        "Евгено",
        "Данило",
        "Максимо",
        "Де",
        "Само"
    )

    val NAMES_FIRSTNAME_SECONDHALF =
        listOf("крыл", "руб", "лаз", "вар", "ус", "борец", "верец", "щит", "лом", "ил", "рез")

    val NAMES_SECOND_NAME = listOf(
        "Древний",
        "Славный",
        "Обжористый",
        "Непробиваемый",
        "Щуплый",
        "Пустоголовый",
        "Прекрасный",
        "Дерзкий",
        "Трусливый",
        "Седой",
        "Лысый",
        "Бородач",
        "Первобытный",
        "Ильин",
        "Ерёменко",
        "Косенков",
        "Чикулаев",
        "Простаков",
        "Жванецкий",
        "Навальный",
        "Вульт"
    )

    val NAMES_AFTER_NAME = listOf(
        "I",
        "II",
        "III",
        "VI",
        "из рода Ланистеров",
        "(особенный)",
        "Отчисленный",
        "(дырявый)",
        "умоляющий не есть его",
        "сын Марии",
        "святой"
    )
}