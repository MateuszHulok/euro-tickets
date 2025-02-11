package euro.tickets.service.impl;

import euro.tickets.domain.PromoCode;
import euro.tickets.domain.Promotor;
import euro.tickets.repository.PromoCodeRepository;
import euro.tickets.repository.PromotorRepository;
import euro.tickets.service.PromotorService;
import euro.tickets.service.dto.PromotorCreateDTO;
import euro.tickets.service.dto.PromotorDTO;
import euro.tickets.service.dto.PromotorUpdateDTO;
import euro.tickets.service.mapper.PromotorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link Promotor}.
 */
@Slf4j
@Service
@Transactional
public class PromotorServiceImpl implements PromotorService {
    private final PromotorRepository promotorRepository;
    private final PromotorMapper promotorMapper;
    private final PromoCodeRepository promoCodeRepository;

    public PromotorServiceImpl(PromotorRepository promotorRepository, PromotorMapper promotorMapper, PromoCodeRepository promoCodeRepository) {
        this.promotorRepository = promotorRepository;
        this.promotorMapper = promotorMapper;
        this.promoCodeRepository = promoCodeRepository;
    }

    @Override
    public PromotorDTO save(PromotorUpdateDTO promotorDTO) {
        log.debug("Request to save Promotor : {}", promotorDTO);

        Promotor promotor = promotorRepository.getOne(promotorDTO.getId());
        promotor.setName(promotorDTO.getName());
        promotor.setLastName(promotorDTO.getLastName());
        promotor.setEmail(promotorDTO.getEmail());
        promotor.setPhoneNumber(promotor.getPhoneNumber());

        Set<PromoCode> newPromoCodes = createPromoCodes(promotorDTO.getNewPromoCodes(), promotor);
        promoCodeRepository.saveAll(newPromoCodes);

        log.debug("Updating promotor {}", promotor);

        promotor = promotorRepository.save(promotor);
        return promotorMapper.toDto(promotor);
    }

    @Override
    public PromotorDTO create(PromotorCreateDTO promotorDTO) {
        log.debug("Request to create Promotor : {}", promotorDTO);
        Promotor promotor = new Promotor();
        promotor.setName(promotorDTO.getName());
        promotor.setLastName(promotorDTO.getLastName());
        promotor.setEmail(promotorDTO.getEmail());
        promotor.setEnabled(true);
        promotor.setCreatedAt(Instant.now());
        promotor.setPhoneNumber(promotor.getPhoneNumber());

        log.info("Creating promotor {}", promotor);
        promotor = promotorRepository.save(promotor);

        Set<PromoCode> promoCodes =
            createPromoCodes(promotorDTO.getNewPromoCodes(), promotor);
        log.info("Saving promo codes: {}", promoCodes);
        promoCodeRepository.saveAll(promoCodes);

        promotor.getPromoCodes().addAll(promoCodes);

        return promotorMapper.toDto(promotor);
    }

    private Set<PromoCode> createPromoCodes(Set<String> newPromoCodes, Promotor promotor) {
        if (newPromoCodes == null)
            return Collections.emptySet();
        else
            return
                newPromoCodes
                    .stream()
                    .map(code -> {
                        PromoCode promoCode = new PromoCode();
                        promoCode.setCode(code);
                        promoCode.setCreatedAt(Instant.now());
                        promoCode.setEnabled(true);

                        if (promotor != null)
                            promoCode.setPromotor(promotor);

                        return promoCode;
                    }).collect(Collectors.toSet());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PromotorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Promotors");
        return promotorRepository.findAll(pageable)
            .map(promotorMapper::toDto);
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<PromotorDTO> findOne(Long id) {
        log.debug("Request to get Promotor : {}", id);
        return promotorRepository.findById(id)
            .map(promotorMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Promotor : {}", id);
        promotorRepository.deleteById(id);
    }
}
