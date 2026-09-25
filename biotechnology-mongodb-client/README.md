# Практична робота №4 — MongoDB / Біотехнології

**Студент:** Головко Дмитро Ігорович  
**Група:** 1КІ-24  
**Варіант:** Біотехнології  
**База даних:** `biotechnology-db`  
**Колекція:** `biotechnology-experiments`

## Технології
- Java 23
- Maven
- MongoDB Community Server
- MongoDB Compass
- Spring Boot
- Spring Data MongoDB
- MongoDB Java driver через Spring Data

## CSV
`src/main/resources/biotechnology.csv` містить таблицю варіанта з англомовними назвами колонок і значеннями у подвійних лапках.

## Налаштування
1. Запустити MongoDB Community Server.
2. За потреби відкрити MongoDB Compass і підключитися до `mongodb://localhost:27017`.
3. Виконати `mvn clean install`.
4. Запустити `mvn exec:java -Dexec.mainClass="com.biotechnology.BiotechnologyApplication"`.

## Команди
1 — додати документ експерименту.  
2 — показати всі документи.  
3 — знайти документи за біотехнологом.  
4 — видалити документи за культурою рослини.  
0 — завершити програму.

Для звіту передбачена послідовність команд `1, 2, 3, 1, 4`, як вимагає практична робота.
