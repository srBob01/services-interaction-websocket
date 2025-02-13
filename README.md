# Пример чата с использованием STOMP

## Описание проекта

Этот проект демонстрирует работу **WebSocket** на базе Spring Boot с использованием протокола **STOMP**. Реализован простой чат, где клиент может отправлять сообщения на сервер, а сервер транслирует их всем подключённым клиентам в режиме реального времени.

### Основные технологии:
- **WebSocket**: для двусторонней связи между клиентом и сервером.
- **STOMP**: протокол обмена сообщениями поверх WebSocket.
- **SockJS**: для обеспечения совместимости с браузерами, которые не поддерживают WebSocket.

---

## Как это работает

1. **Подключение клиента**:
    - Клиент (браузер) устанавливает соединение с сервером через WebSocket.
    - Используется URL `/ws` для подключения.

2. **Отправка сообщений**:
    - Пользователь вводит текст и отправляет его на сервер по адресу `/app/hello`.
    - Сервер обрабатывает сообщение и добавляет префикс "Hello, ...".

3. **Получение сообщений**:
    - Сервер публикует сообщение в топик `/topic/greetings`.
    - Все клиенты, подписанные на этот топик, получают сообщение в режиме реального времени.

4. **Отображение сообщений**:
    - Клиенты отображают полученные сообщения в списке на веб-странице.

---

## Структура проекта

### Серверная часть

1. **Конфигурация WebSocket**:
    - Класс `WebSocketConfig` настраивает конечную точку (`/ws`) и брокер сообщений:

2. **Контроллер WebSocket**:
    - Обрабатывает сообщения от клиента по адресу `/app/hello`.
    - Публикует обработанные сообщения в топик `/topic/greetings`.

### Клиентская часть

HTML-страница подключается к серверу через WebSocket, используя STOMP и SockJS.

## Пример работы

1. Запустите сервер Spring Boot.
2. Откройте страницу в двух разных браузерах (например, Chrome и Firefox).
3. В одном браузере введите сообщение и нажмите **Send**.
4. Сообщение появится в обоих браузерах в реальном времени.

---

## Преимущества

1. **Реальное время**:
    - Все подключённые клиенты получают обновления сразу после публикации.
2. **Совместимость**:
    - Поддержка SockJS позволяет использовать WebSocket даже в старых браузерах.
3. **Простота**:
    - Лёгкая настройка через Spring Boot и STOMP.

---

## Недостатки

1. **Ограничения встроенного брокера**:
    - Для масштабирования потребуется использовать внешние брокеры, такие как RabbitMQ или ActiveMQ.
2. **Дополнительная настройка для безопасности**:
    - Для продакшена необходимо настроить защиту через HTTPS и авторизацию.

