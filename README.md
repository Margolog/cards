# Проект по автоматизации тестирования сайта MultiCards

<p align="center">
<img src="images/multicards-logo.png" alt="MultiCards" width="320"/>
</p>

> Автоматизированные UI-тесты для сайта https://multicards.io

## Содержание

- Технологии и инструменты
- Реализованные проверки
- Сборка в Jenkins
- Запуск из терминала
- [Allure Report](https://jenkins.qa.guru/job/41-m_a_l_qa-unit10-ui/allure/)
- [Allure TestOps](https://allure.autotests.cloud/project/5244/test-cases/44953?search=W3siaWQiOiJ0eXBlIiwidHlwZSI6InRlc3RDYXNlVHlwZUFycmF5IiwidmFsdWUiOlsiYXV0b21hdGVkIl19XQ%3D%3D&treeId=0)
- [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1613)
- Telegram уведомления

---

## Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg" width="50" height="50"/></a>
<a href="https://www.java.com/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" width="50" height="50"/></a>
<a href="https://github.com/"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="50" height="50"/></a>
<a href="https://junit.org/junit5/"><img src="https://junit.org/junit5/assets/img/junit5-logo.png" width="50" height="50"/></a>
<a href="https://qameta.io/allure-report/"><img src="https://avatars.githubusercontent.com/u/5879127?s=200&v=4" width="50" height="50"/></a>
<a href="https://www.jenkins.io/"><img src="https://www.jenkins.io/images/logos/jenkins/jenkins.svg" width="50" height="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/jira/jira-original.svg" width="50" height="50"/></a>
</p>

---

## Структура проекта

- `src/test/java/tests` - тестовые классы и базовая настройка запуска.
- `src/test/java/pages` - page objects для экранов MultiCards.
- `src/test/java/helpers` - вспомогательные методы для вложений в отчеты.
- `src/test/java/data` - тестовые данные и перечисления.

---

## Реализованные проверки

- Проверка отображения кнопки входа через Google
- Проверка отображения ошибки при вводе некорректного email
- Проверка отображения поля Confirmation code после отправки формы восстановления пароля
- Проверка перехода на страницу регистрации со страницы авторизации
- Проверка переключения сайта на испанский язык
- Проверка текста кнопки регистрации после смены языка
- Проверка отображения пунктов меню в хедере
- Проверка корректности ссылки Telegram Support

---

## Сборка в Jenkins

[Открыть Job в Jenkins](https://jenkins.qa.guru/job/41-m_a_l_qa-unit10-ui/)

<p align="center">
<img src="images/Jenkins.png" alt="Jenkins" width="900"/>
</p>

Jenkins выполняет удалённый запуск тестов со следующими настройками:

- окружение: `remote`
- браузер: `chrome`
- версия браузера: `148.0`
- размер окна: `1920x1080`
- базовый URL: `https://multicards.io`
- режим запуска: `headless=true`

Адрес Selenoid хранится в Jenkins Credentials и передаётся в сборку через
переменную `SELENOID_REMOTE_URL`. Результаты тестов из `build/allure-results`
публикуются в Allure Report и отправляются в Allure TestOps.

---

## Запуск из терминала

### Локальный запуск

```bash
./gradlew clean test
```

По умолчанию используются настройки из `local.properties`: локальный Chrome. Любую настройку можно переопределить,
например: `./gradlew clean test -Dheadless=true -DbrowserSize=1440x900`.

### Удалённый запуск

```bash
./gradlew clean test -Denv=remote \
  -DremoteUrl=https://user:password@selenoid.example/wd/hub
```

Настройки берутся из `remote.properties` и также могут быть переопределены через
`-Dbrowser`, `-DbrowserVersion`, `-DbrowserSize`, `-DbaseUrl`, `-DremoteUrl` и
`-Dheadless`.


---

## [Allure Report](https://jenkins.qa.guru/job/41-m_a_l_qa-unit10-ui/allure/)

### Dashboard

<p align="center">
<img src="images/Allure2.png" alt="Allure Dashboard" width="900"/>
</p>

### Тест-кейсы

<p align="center">
<img src="images/allure cs2.png" alt="Allure Cases" width="900"/>
</p>

### Графики

<p align="center">
<img src="images/allure graf.png" alt="Allure Graphs" width="900"/>
</p>

---

## [Allure TestOps](https://allure.autotests.cloud/project/5244/test-cases/44953?search=W3siaWQiOiJ0eXBlIiwidHlwZSI6InRlc3RDYXNlVHlwZUFycmF5IiwidmFsdWUiOlsiYXV0b21hdGVkIl19XQ%3D%3D&treeId=0)

### Dashboard

<p align="center">
<img src="images/Allure TestOps Dashboard2.png" alt="TestOps Dashboard" width="900"/>
</p>

### Автоматизированные тест-кейсы

<p align="center">
<img src="images/auto cs2.png" alt="Auto Cases" width="900"/>
</p>

### Ручные тест-кейсы

<p align="center">
<img src="images/manual cs.png" alt="Manual Cases" width="900"/>
</p>

---

## [Jira](https://jira.autotests.cloud/browse/HOMEWORK-1613)

<p align="center">
<img src="images/jira.png" alt="Jira" width="900"/>
</p>

---

## Telegram уведомления

<p align="center">
<img src="images/telegram2.png" alt="Telegram" width="600"/>
</p>
