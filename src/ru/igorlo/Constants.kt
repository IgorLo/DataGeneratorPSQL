package ru.igorlo

object Constants {
    const val DB_NAME_DEFAULT = "rpg_game"
    const val DB_USER_DEFAULT = "94405"
    const val DB_PASS_DEFAULT = "440533"
    const val DB_HOST_DEFAULT = "localhost"
    const val DB_PORT_DEFAULT = 5432

    const val RANDOM_STRING_SOURCE =
        "ABCDEFGHIJKLMNOPQRSTUVWXYZ_" +
                "=-+0123456789zxcvbnm,./;lkjh" +
                "gfdsaqwertyuiop[]ячсмитьбюфы" +
                "вапролджэйцукенгшщзхъйЁЙЦУКЕ" +
                "НГШЩЗХЪФЫВАПРОЛДЖЭЯЧСМИТЬБЮ"

    var GEN_ITEMS_QUANTITY = 50
    const val GEN_ITEMS_MIN_DAMAGE = 1
    const val GEN_ITEMS_MIN_WEIGHT = 1
    const val GEN_ITEMS_MIN_PRICE = 1
    const val GEN_ITEMS_MAX_DAMAGE = 50
    const val GEN_ITEMS_MAX_WEIGHT = 20
    const val GEN_ITEMS_MAX_PRICE = 5000

    var GEN_SKILLS_QUANTITY = 60
    const val GEN_SKILLS_MIN_MULT = 0.1
    const val GEN_SKILLS_MAX_MULT = 10.0

    var GEN_LOCATIONS_QUANTITY = 150
    const val GEN_LOCATIONS_MIN_X = 1
    const val GEN_LOCATIONS_MIN_Y = 1
    const val GEN_LOCATIONS_MAX_X = 1000
    const val GEN_LOCATIONS_MAX_Y = 1000

    var GEN_CITIES_QUANTITY = 25

    var GEN_CLANS_QUANTITY = 30
    const val GEN_CLANS_MIN_RATING = 1
    const val GEN_CLANS_MAX_RATING = 100

    var GEN_NPCS_QUANTITY = 300
    const val GEN_NPCS_MIN_EXP = 1
    const val GEN_NPCS_MAX_EXP = 1000

    var GEN_CONNECTIONS_QUANTITY = 800

    var GEN_CHARACTERS_QUANTITY = 250
    const val GEN_CHARACTERS_MIN_LEVEL = 1
    const val GEN_CHARACTERS_MAX_LEVEL = 80
    const val GEN_CHARACTERS_MIN_EXP = 1
    const val GEN_CHARACTERS_MAX_EXP = 1000
    const val GEN_CHARACTERS_MIN_HP = 20
    const val GEN_CHARACTERS_MAX_HP = 200
    const val GEN_CHARACTERS_MIN_MONEY = 0
    const val GEN_CHARACTERS_MAX_MONEY = 10000

    var GEN_NPC_FIGHTS_QUANTITY = 3000
    const val GEN_NPC_FIGHTS_PLAYER_LOSTHP_MIN = 0
    const val GEN_NPC_FIGHTS_PLAYER_LOSTHP_MAX = 100
    const val GEN_NPC_FIGHTS_NPC_LOSTHP_MIN = 0
    const val GEN_NPC_FIGHTS_NPC_LOSTHP_MAX = 100
    const val GEN_NPC_FIGHTS_GOTMONEY_MIN = 0
    const val GEN_NPC_FIGHTS_GOTMONEY_MAX = 1000

    var GEN_PLAYER_FIGHTS_QUANTITY = 1000

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

    val GEN_CLANS_NAMES = listOf(
        "NesT",
        "A-TeaM",
        "Dragons of night",
        "Империя Хаира",
        "Ассасины крови",
        "Большие Маракасы",
        "Искатели",
        "Wars of darkness",
        "Отважные союзники",
        "Dark Void",
        "Сталахтиты",
        "ExcLusive Light",
        "Школа Спартанцев",
        "Premium",
        "DarkRaven",
        "CoinS",
        "Бойцы Хаира",
        "Tales Of Summer",
        "Повелители тьмы",
        "DareDevils",
        "Night Hooligans",
        "Жуз",
        "Lightbearers",
        "Кузнецы Счастья",
        "Monster Force",
        "Age of Heroes",
        "Пещерные Войны",
        "Вымершие Драконы",
        "SH-Undead",
        "Легион Рассвета",
        "Тираны",
        "Орден Невидимых",
        "Art Of War",
        "Liandri",
        "Пилигрим",
        "Доблестники Хаира",
        "Red Stars",
        "Подводная гвардия",
        "Редут",
        "Пламя Свободы",
        "Крутые белки",
        "Веселые дракошки",
        "Гильдия Вершителей",
        "rzr-team",
        "Hand Of Justice",
        "Golden Rodger",
        "Легион Империи",
        "The Shadow Knights",
        "Они",
        "Адские карателИ",
        "Veritas"
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