package infraesctucure.repository;

import com.javanauta.learning_spring.infraesctucure.entity.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefoneRepository extends JpaRepository<Telefone, Long> {
}