package com.startech.restapi.Persistence;

        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface UserPersistence extends JpaRepository<User, Long> {
}