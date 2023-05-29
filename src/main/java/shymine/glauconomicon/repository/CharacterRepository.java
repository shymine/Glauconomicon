package shymine.glauconomicon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shymine.glauconomicon.campaign.Character;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
