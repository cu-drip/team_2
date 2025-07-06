# 📝 FeedbackService

## Описание

**FeedbackService** — микросервис для приема и хранения отзывов пользователей о соревнованиях и играх.

### Основные задачи:

- Прием текстовых отзывов и оценок (рейтинг)
- Сохранение отзывов о играх и соревнованиях
- Получение отзывов по `user_id`, `match_id`, `tournament_id`
- Простое REST API
- Интеграция с другими сервисами по HTTP/JSON

---

## 📦 Модели данных (Database Schema)

### `MatchesFeedback`

```text
id: UUID (PK)
user_id: UUID
match_id: UUID
text: string
rating: int
created_at: timestamp
```

### `TournamentFeedback`

```text
id: UUID (PK)
user_id: UUID
tournament_id: UUID
text: string
rating: int
created_at: timestamp
```

---

## 🌐 API (REST JSON)

### `/user` — Пользовательский интерфейс

| Метод | Endpoint                             | Описание                                 |
|-------|--------------------------------------|------------------------------------------|
| POST  | `/user/add/match`                    | Добавить отзыв о конкретной игре         |
| POST  | `/user/add/tournament`               | Добавить отзыв о конкретном соревновании |
| GET   | `/user/match?matchId={id}`             | Получить отзывы по `match_id`            |
| GET   | `/user/tournament?tournamentId={id}` | Получить отзывы по `tournament_id`       |

### `/admin` — Административный интерфейс

| Метод | Endpoint                  | Описание                                      |
|-------|---------------------------|-----------------------------------------------|
| GET   | `/admin/user?userId={id}` | Получить все отзывы пользователя (игры + соревнования) |

---

## 📌 Ответственности FeedbackService

| Компонент       | Ответственность                                                                 |
|------------------|----------------------------------------------------------------------------------|
| FeedbackService  | Хранение отзывов, REST API, фильтрация по id, работа с БД, возврат JSON данных |




