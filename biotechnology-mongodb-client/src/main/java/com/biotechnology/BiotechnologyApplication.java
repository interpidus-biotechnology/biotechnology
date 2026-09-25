package com.biotechnology;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BiotechnologyApplication {
    public static void main(String[] args) throws Exception {
        var context = SpringApplication.run(BiotechnologyApplication.class, args);
        var repo = context.getBean(ExperimentRepository.class);
        System.out.println("=== Практична робота №4: MongoDB / Біотехнології ===");
        System.out.println("Студент: Головко Дмитро Ігорович | Група: 1КІ-24");
        System.out.println("База: biotechnology-db | Колекція: biotechnology-experiments");
        System.out.println("Команди: 1-додати документ, 2-показати всі, 3-пошук за біотехнологом, 4-видалити за культурою, 0-вихід.");

        // Для лабораторної роботи передбачено інтерактивний режим.
        // Команди можна виконати послідовно: 1, 2, 3, 1, 4.
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                System.out.print("Введіть команду: ");
                if (!sc.hasNextLine()) break;
                String cmd = sc.nextLine().trim();
                switch (cmd) {
                    case "1" -> {
                        Experiment e = new Experiment(
                            "Головко Дмитро",
                            "д-р Коваль",
                            "Іван Прут",
                            LocalDate.of(2024, 9, 21),
                            "пшениця",
                            List.of("SNP8:A/T", "SNP9:C/G"),
                            List.of("екстракція", "ПЛР", "секвенування"),
                            new Experiment.Laboratory("м. Черкаси, вул. Технологічна, 10", "380472550999"),
                            10
                        );
                        Experiment saved = repo.save(e);
                        System.out.println("[1] Додано документ: " + saved.getId());
                    }
                    case "2" -> {
                        List<Experiment> all = repo.findAll();
                        System.out.println("[2] У колекції документів: " + all.size());
                        all.forEach(System.out::println);
                    }
                    case "3" -> {
                        System.out.print("Введіть біотехнолога: ");
                        String name = sc.nextLine();
                        var found = repo.findByBiotechnologist(name);
                        System.out.println("[3] Знайдено документів: " + found.size());
                        found.forEach(System.out::println);
                    }
                    case "4" -> {
                        System.out.print("Введіть культуру для видалення: ");
                        String culture = sc.nextLine();
                        long count = repo.deleteByPlantCulture(culture);
                        System.out.println("[4] Видалено документів: " + count);
                    }
                    case "0" -> { context.close(); return; }
                    default -> System.out.println("Невідома команда.");
                }
            }
        }
    }
}
