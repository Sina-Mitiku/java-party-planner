package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PartySeeder implements CommandLineRunner {

  private PartyRepository partyRepository;

  @Autowired
  public PartySeeder(PartyRepository partyRepository) {
    this.partyRepository = partyRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Party party1 = new Party();
    party1.setName("Halloween");
    party1.setDescription("costume needed");
    party1.setLocation("conference room");

    Party party2= new Party();
    party2.setName("Christmas");
    party2.setDescription("Evening party");
    party2.setLocation("Boat");

    Party party3 = new Party();
    party3.setName("Fair well");
    party3.setDescription("Lunch party");
    party3.setLocation("lunch room");

    List<Party> parties = (List<Party>) partyRepository.findAll();

    if(parties.size() == 0) {
      partyRepository.save(party1);
      partyRepository.save(party2);
      partyRepository.save(party3);
    }
  }
}