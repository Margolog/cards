# Проект по автоматизации тестирования сайта MultiCards

> Автоматизированные UI-тесты для сайта https://multicards.io

## Содержание

- Технологии и инструменты
- Реализованные проверки
- Сборка в Jenkins
- Запуск из терминала
- Allure Report
- Allure TestOps
- Jira
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

```text
cards
├── images
├── src
│   └── test
│       ├── java
│       │   ├── data
│       │   ├── helpers
│       │   ├── pages
│       │   └── tests
│       └── resources
├── build.gradle
├── README.md
└── .gitignore
```

---

## Реализованные проверки

- Проверка отображения кнопки входа через Google
- Проверка отображения ошибки при вводе некорректного email
- Проверка переключения сайта на испанский язык
- Проверка текста кнопки регистрации после смены языка
- Проверка отображения пунктов меню в хедере
- Проверка корректности ссылки Telegram Support

---

## Сборка в Jenkins

<p align="center">
<img src="images/Jenkins.png" alt="Jenkins" width="900"/>
</p>

Сборка запускается через Jenkins с параметрами:

- browser
- browserVersion
- browserResolution
- baseUrl
- remote
- headless

---

## Запуск из терминала

### Локальный запуск

```bash
gradle clean test
```

### Удалённый запуск

```bash
gradle clean test \
-Dbrowser=CHROME \
-DbrowserVersion=127.0 \
-DbrowserResolution=1920x1080 \
-DbaseUrl=https://multicards.io \
-Dremote=https://user1:1234@selenoid.autotests.cloud/wd/hub
```

---

## Allure Report

### Dashboard

<p align="center">
<img src="images/Allure.png" alt="Allure Dashboard" width="900"/>
</p>

### Тест-кейсы

<p align="center">
<img src="images/allure cs.png" alt="Allure Cases" width="900"/>
</p>

### Графики

<p align="center">
<img src="images/allure graf.png" alt="Allure Graphs" width="900"/>
</p>

---

## Allure TestOps

### Dashboard

<p align="center">
<img src="images/Allure TestOps Dashboard.png" alt="TestOps Dashboard" width="900"/>
</p>

### Автоматизированные тест-кейсы

<p align="center">
<img src="images/auto cs.png" alt="Auto Cases" width="900"/>
</p>

### Ручные тест-кейсы

<p align="center">
<img src="images/manual cs.png" alt="Manual Cases" width="900"/>
</p>

---

## Jira

<p align="center">
<img src="images/jira.png" alt="Jira" width="900"/>
</p>

---

## Telegram уведомления

<p align="center">
<img src="images/tg.png" alt="Telegram" width="600"/>
</p>