# 📝 FeedbackService

## Описание

**FeedbackService** — микросервис для приема и хранения отзывов пользователей о соревнованиях и играх.

### Основные задачи:

- Прием текстовых отзывов и оценок (рейтинг)
- Сохранение отзывов о играх и соревнованиях
- Получение отзывов по `user_id`, `game_id`, `competition_id`
- Простое REST API
- Интеграция с другими сервисами по HTTP/JSON

---

## 📦 Модели данных (Database Schema)

### `GameFeedback`

```text
id: UUID (PK)
iduser: UUID
idgame: UUID
text: string
rating: int
created_at: timestamp
```

### `CompetitionFeedback`

```text
id: UUID (PK)
iduser: UUID
idcompetition: UUID
text: string
rating: int
created_at: timestamp
```

---

## 🌐 API (REST JSON)

### `/user` — Пользовательский интерфейс

| Метод | Endpoint                   | Описание                                |
|-------|----------------------------|-----------------------------------------|
| POST  | `/user/add/game`           | Добавить отзыв о конкретной игре        |
| POST  | `/user/add/competition`    | Добавить отзыв о конкретном соревновании|
| GET   | `/user/game?idgame={id}`   | Получить отзывы по `idgame`             |
| GET   | `/user/competition?idcompetition={id}` | Получить отзывы по `idcompetition` |

### `/admin` — Административный интерфейс

| Метод | Endpoint                       | Описание                                      |
|-------|--------------------------------|-----------------------------------------------|
| GET   | `/admin/user?iduser={id}`      | Получить все отзывы пользователя (игры + соревнования) |

---

## 🧪 Swagger / OpenAPI

Подключение Swagger:

### 1. Добавь зависимость в `build.gradle`:

```groovy
implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0'
```

### 2. После запуска приложения Swagger будет доступен по адресу:

```
http://localhost:8080/swagger-ui.html
```

---

## 📌 Ответственности FeedbackService

| Компонент       | Ответственность                                                                 |
|------------------|----------------------------------------------------------------------------------|
| FeedbackService  | Хранение отзывов, REST API, фильтрация по id, работа с БД, возврат JSON данных |




