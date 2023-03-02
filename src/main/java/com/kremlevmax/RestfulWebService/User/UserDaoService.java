package com.kremlevmax.RestfulWebService.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

@Repository
public class UserDaoService {
	private static List<User> allUsers = new ArrayList<>();
	
	private static int userCount = 0;
	
	static {
		allUsers.add(new User(++userCount, "Max Kremlev", LocalDate.now().minusYears(34)));
		allUsers.add(new User(++userCount, "Alina Ganenkova", LocalDate.now().minusYears(31)));
		allUsers.add(new User(++userCount, "Barsik", LocalDate.now().minusYears(7)));
	}
	
	public List<User> getAllUsers() {
		return allUsers;
	}
	
	public User getUserById(int id) {
		Predicate<User> predicate = user -> user.getId().equals(id);
		return allUsers.stream().filter(predicate).findFirst().get();
		
	}
	
	public User addUser(User user) {
		user.setId(++userCount);
		allUsers.add(user);
		return user;
	}

}
