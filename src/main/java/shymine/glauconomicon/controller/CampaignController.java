package shymine.glauconomicon.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import shymine.glauconomicon.LoadDatabase;
import shymine.glauconomicon.campaign.Campaign;
import shymine.glauconomicon.repository.CampaignRepository;

import java.util.List;

@RestController
@RequestMapping(path = "${apiPrefix}")
public class CampaignController {

    @Autowired
    private CampaignRepository campaignRepository;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    @GetMapping("/get_campaign")
    public Campaign getCampaign(@RequestParam(value="name", defaultValue = "Test") String name) {
        Campaign res = this.campaignRepository.findByName(name);
        log.info("/get_campaign "+res);
        return res;
    }

    @GetMapping("/list_campaigns")
    public List<Campaign> listCampaign() {
        List<Campaign> res = this.campaignRepository.findAll();
        log.info("/list_campaign "+res);
        return res;
    }

    @PostMapping("/new_campaign")
    public Campaign newCampaign() {
        Campaign res = this.campaignRepository.save(new Campaign());
        log.info("/new_campaign "+res);
        return res;
    }
}
