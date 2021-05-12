package com.launchacademy.partyplanner.seeders;

import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.FriendRepository;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FriendSeeder implements CommandLineRunner {

  private FriendRepository friendRepository;

  @Autowired
  public FriendSeeder(FriendRepository friendRepository) {
    this.friendRepository = friendRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Friend friend1 = new Friend();
    friend1.setFirstName("Hewan");
    friend1.setLastName("Kibur");

    Friend friend2 = new Friend();
    friend2.setFirstName("Meklit");
    friend2.setLastName("Kibur");

    Friend friend3 = new Friend();
    friend3.setFirstName("Kibur");
    friend3.setLastName("Wudineh");

    List<Friend> friends = (List<Friend>) friendRepository.findAll();

    if(friends.size() == 0) {
      friendRepository.save(friend1);
      friendRepository.save(friend2);
      friendRepository.save(friend3);
    }
  }
}
