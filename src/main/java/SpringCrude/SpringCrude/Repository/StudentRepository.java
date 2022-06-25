package SpringCrude.SpringCrude.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import SpringCrude.SpringCrude.Models.Students;

public interface StudentRepository extends JpaRepository<Students, Integer>{

	Optional<Students> findByEmail(String email);
}
