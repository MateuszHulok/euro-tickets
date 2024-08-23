package euro.tickets.repository;

import euro.tickets.domain.PromoCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Spring Data  repository for the PromoCode entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PromoCodeRepository extends JpaRepository<PromoCode, Long> {
    Optional<PromoCode> findByCodeIgnoreCaseAndEnabledIsTrue(String code);
}
