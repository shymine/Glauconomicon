package shymine.glauconomicon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import shymine.glauconomicon.campaign.Campaign;
import shymine.glauconomicon.campaign.Character;
import shymine.glauconomicon.campaign.Item;
import shymine.glauconomicon.campaign.Place;
import shymine.glauconomicon.repository.CampaignRepository;
import shymine.glauconomicon.repository.CharacterRepository;
import shymine.glauconomicon.repository.ItemRepository;
import shymine.glauconomicon.repository.PlaceRepository;

import java.util.ArrayList;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CampaignRepository campaignRepository, CharacterRepository characterRepository, ItemRepository itemRepository, PlaceRepository placeRepository) {
        return args -> {
            log.info("Present Data: "+campaignRepository.findAll());

            Item bb = new Item();
            bb.setName("Beginner's Blade").setDescription("A blade made of wood for beginners");
            bb = itemRepository.save(bb);

            Item bs = new Item();
            bs.setName("Beginner's Shield").setDescription("A shield made of wood for beginners");
            bs = itemRepository.save(bs);
            
            Character hiro = new Character();
            hiro.setName("Hiro").setBackground("The hero").addEquipment(bb).addEquipment(bs).addAbility("HP", 30);
            hiro = characterRepository.save(hiro);

            Character trainer = new Character();
            trainer.setName("Hugo").setBackground("The trainer of the training grounds").addEquipment(bs).addAbility("HP", 70).addAbility("Attack", 30);
            trainer = characterRepository.save(trainer);

            Place p1 = new Place();
            p1.setName("Training Ground").setDescription("A training ground for beginners").addItem(bb).addNpcs(trainer);
            p1 = placeRepository.save(p1);

            Campaign c1 = new Campaign();
            c1.setName("Test1").setDescription("Une campagne test").addNpc(trainer).addPc(hiro).addPlace(p1);

            Campaign c2 = new Campaign();
            c2.setName("Test2").setDescription("Seconde campagne de test");

            Campaign c3 = new Campaign();
            c3.setName("Test3").setDescription("Troisième campagne");

            Campaign c4 = new Campaign();
            c4.setName("Test4").setDescription("Quatrième campagne");

            Campaign c5 = new Campaign();
            c5.setName("Test5").setDescription("Cinquième campagne");


            log.info("Preloading "+campaignRepository.save(c1));
            log.info("Preloading "+campaignRepository.save(c2));
            log.info("Preloading "+campaignRepository.save(c3));
            log.info("Preloading "+campaignRepository.save(c4));
            log.info("Preloading "+campaignRepository.save(c5));

        };
    }
}
