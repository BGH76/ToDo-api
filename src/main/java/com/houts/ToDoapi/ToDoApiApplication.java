package com.houts.ToDoapi;

import com.houts.ToDoapi.account.Account;
import com.houts.ToDoapi.account.AccountRepository;
import com.houts.ToDoapi.task.Task;
import com.houts.ToDoapi.task.TaskRepository;
import com.houts.ToDoapi.userprofile.UserProfile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ToDoApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(ToDoApiApplication.class, args);

	}
//	@Bean
//	CommandLineRunner commandLineRunner(AccountRepository accountRepository, TaskRepository taskRepository) {
//		return args -> {
//			UserProfile userProfile = new UserProfile("Brian", "Houts", "houts@mail.com");
//			Account account = new Account("bhouts", "123", userProfile);
//
//
//			UserProfile userProfile2 = new UserProfile("Tucker", "Houts", "tuck@mail.com");
//			Account account2 = new Account("thouts","654321", userProfile2);
//
//			UserProfile userProfile3 = new UserProfile("Buddy", "Houts", "bud@mail.com");
//			Account account3 = new Account("buddyhouts","9852", userProfile3);
//
//			Task task = new Task(1L, "Wash the car", LocalDate.now().minusDays(2), false);
//			Task task1 = new Task(1L, "Clean the House", LocalDate.now().minusDays(5), false);
//			Task task2 = new Task(2L, "Work on fullstack api", LocalDate.now(), false);
//			Task task3 = new Task(1L, "Pick up the mail", LocalDate.now().minusDays(7), false);
//			Task task4 = new Task(1L, "Work on building Kanban board", LocalDate.now().minusDays(12), false);
//			Task task5 = new Task(1L, "Need ReadMe files completed by Monday before meeting", LocalDate.now().minusDays(3), false);
//			Task task6 = new Task(1L, "More test data to render todo list", LocalDate.now(), false);
//
//			accountRepository.saveAll(List.of(account, account2, account3));
//			taskRepository.saveAll(List.of(task, task1, task2, task3, task4, task5, task6));
////			System.out.println(accountRepository.findById(1L));
//		};
//	}

}
