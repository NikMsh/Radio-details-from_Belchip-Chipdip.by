### 1. Введение
> Данный план тестирования предназначен для приложения "Radio-details-from_Belchip-Chipdip.by". Целью выполнения данного плана 
тестирования является проверка работоспособности приложения, а также выявление фактов несоответствия 
предъявляемым к проекту требованиям.
### 2. Объект тестирования
> Тестируемое приложение содержит 4 страницы, обеспечивающих реализацию функциональных требований:
 - Главная страница
 - Страница входа
 - Страница результатов поиска
 - Страница просмотра товара
### 3. Атрибуты качества
- Функциональная полнота: приложение должно соответствовать всем функциональным требованиям,
которые заявлены по ссылке: [SRS](https://github.com/NikMsh/Radio-details-from_Belchip-Chipdip.by/blob/master/Project%20Documentation/SRS(RU).md#3.1);
- Кроссбраузерность: приложение должно корректно работать в браузерах Opera(v 29 и выше), Google Chrome(v 42 и выше), FireFox(v39 и выше), Microsoft Edge(v 13 и выше).
- Анонимность: приложение не должно обязывать пользователя использовать информацию, позволяющую идентифицировать пользователя.
- Простота пользовательского интерфейса: интерфейс должен быть достаточно простым для интуитивного
использования новым пользователем.
### 4. Риски
> Логин и пароль пользователя не шифруются, что создаёт потенциальную опасность их получения в явном виде злоумышленниками.
### 5. Аспекты тестирования
> Данное тестирование является интеграционным, т. е. программные модули тестируются в группке, также является дымовым, и будет проводиться по типу "Black box", т. е. без доступа к исходному коду. В ходе тестирования планируется проверить реализацию основных функций приложения, провести позитивные
и негативные тесты, а также проверить нефункциональные требования. К основным функциям можно отнести
следующие пункты:

- возможность войти в аккаунт;
- возможность осуществить поиск товара или каталога:
- возможность получить подкаталоги;
- возможность перейти на главную страницу;
- возможность выйти из аккаунта;

#### Функциональные требования:

##### -Возможность войти в аккаунт
Данный вариант использования небходимо протестировать на:
1. Реакцию приложения на попытку войти в аккаунт.
2. Выполнение данной операции (переход на страницу с основными каталогами).

##### -Возможность осуществить поиск товара или каталога
Данный вариант использования небходимо протестировать на:
1. Реакцию приложения на ввод названия товара или каталога в поле ввода для поиска товаров/каталогов
2. Выполнение данной операции (отображение товаров/каталогов, соответствующих введенным в поле поиска данным).

##### -Возможность получить подкаталоги
Данный вариант использования небходимо протестировать на:
1. Реакцию приложения на получение подкаталогов.
2. Выполнение данной операции (отображение подкаталогов, входящих в определённый каталог товаров).

##### -Возможность перейти на главную страницу
Данный вариант использования небходимо протестировать на:
1. Реакцию приложения на нажатие кнопки Main
2. Выполнение данной операции (переход на стартовую страницу, содержащую основные каталоги товаров).

##### -Возможность выйти из аккаунта
Данный вариант использования небходимо протестировать на:
1. Реакцию приложения на нажатие кнопки Exit
2. Выполнение данной операции (переход на стартовую страницу, отсутствие возможности получить
доступ к данным аккаунта, минуя операцию входа в аккаунт).

#### Нефункциональные требования:
- анонимность пользователя при использовании приложения
- работоспособность в различных веб-браузерах Opera(v 29 и выше), Google Chrome(v 42 и выше), FireFox(v39 и выше), Microsoft Edge(v 13 и выше)
- простота использования благодаря минимальному интерфейсу

### 6. Подходы к тестированию
> Для тестирования приложения необходимо вручную проверить каждый аспект тестирования.

### 7. Представление результатов
> [Результаты тестирования](https://github.com/NikMsh/Radio-details-from_Belchip-Chipdip.by/blob/master/Project%20Documentation/testing/testRes.md).

### 8. Выводы
> С помощью данного тестового плана тестировщик может протестировать функционал приложения.
Факт успешного прохождения всех тестов позволяет сделать вывод о работоспособности приложения
и выполнения им всех предъявляемых требований.
