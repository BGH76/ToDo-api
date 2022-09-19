package com.houts.ToDoapi.userprofile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserProfile, Long> {

    Optional<UserProfile> findUserProfileByEmail(String email);

    List<UserProfile> findUserProfileById(Long id);

//    @Query("SELECT t FROM Task t JOIN user_profile u on t.user_profile_id = ?1")
//    List<UserProfile> selectUsersWithTask(Long id);
}
