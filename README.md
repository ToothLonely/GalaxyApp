# Приложение Галактика

Это приложеине написано для просмотра астрофото, публикуемых NASA. В этом прлиожении реализована следующая функциональность:  
- Главный экран со списком (в виде сетки) карточек астофото с названием и изображением. Получение списка реализовано с помощью пагинации.  
- Информационный экран (открывается при нажатии на карточку). На нем изображено астрофото, а так же описание объекта, изображенного на астрофото. На этом экранае реализован Parallax эффект.  
Это мой первый проект на Jetpack Compose, а так же впервые я решил попробовать такие библиотеки как Ktor (вместо привычного Retrofit) и Koin (вместо Hilt).  
Приложение написано в соответствии с рекомендациями Google, по принципам Clean Architecture

# !Warning!

В ходе разработки приложения выяснилось, что API от NASA не работает (из-за блокировки запросов из России (скорее всего) или из-за шатдауна правительства США), однако было принято решение продолжить разработку.
Поэтому на данный момент в приложении использованы заглушки, вместо реальной работы с API.

### Автор

**ToothLonely**

# Стек:

| Категория     | Технология                                                          |
|---------------|---------------------------------------------------------------------|
| Architecture  | ![MVVM](https://img.shields.io/badge/MVVM-purple)                   |
| Language      | ![Kotlin](https://img.shields.io/badge/Kotlin-blue)                 |
| UI            | ![Compose](https://img.shields.io/badge/Jetpack-Compose-lightgrey)  |
| Network       | ![Ktor](https://img.shields.io/badge/Ktor-green)                    |
| Database      | ![Room](https://img.shields.io/badge/Room-red)                      |
| DI            | ![Koin](https://img.shields.io/badge/Koin-orange)                   |
| Navigation    | ![Navigation](https://img.shields.io/badge/Navigation-Jetpack-grey) |
| Image Loading | ![Coil](https://img.shields.io/badge/Coil-yellow)                   |
| Concurrency   | ![Coroutines](https://img.shields.io/badge/Coroutines-yellowgreen)  |

# Структура проекта:

| Package | Content                                                     |
|---------|-------------------------------------------------------------|
| app/    | Application                                                 | 
| data/   | Database, API service, DAOs, DI Module, repository          | 
| model/  | Модели данных (data classes) для использования в приложении | 
| ui/     | MainScreen, InfoScreen, MainActivity                        |
