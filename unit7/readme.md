## Домашняя работа по лекции №7

Программа для получения погоды.

### Критерии успеха

- Пользователь может запросить погоду для конкретного города
- Полученная погода должна сохраниться в базе данных
- Пользователь может просмотреть сохраненные в базе данных записи

### Необходимая информация

**Адрес API** - `https://community-open-weather-map.p.rapidapi.com/weather?units=metric&mode=json&q=Красноярск`

> Дополнительное описание данного сервиса можно узнать тут: https://rapidapi.com/community/api/open-weather-map/endpoints

**HTTP-заголовки**
||Название||Значение||
|x-rapidapi-host|community-open-weather-map.p.rapidapi.com|
|x-rapidapi-key|cdd96ad95amsheebcca53e65aac1p136010jsn18e30e4e6350|

### Помощь

Для формирования запроса с заголовками вам необходимо создать специальную сущность `HttpEntity`. И воспользоваться методом класса `RestTemplate` - `exchange`.

Для того, чтобы принять дополнительный параметр в команде `shell`, вам нужно воспользоваться специальной аннотацией `@ShellOption`. Пример:
```Java
@ShellMethod("Get joke about Chuck Norris.")
public String joke(
  @ShellOption(defaultValue = "NERDY") 
    String category) {
  return jokeService.getJoke(category);
}
```

**Всем желаем успехов при выполнении домашнего задания!**