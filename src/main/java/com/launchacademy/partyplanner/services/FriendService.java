package com.launchacademy.partyplanner.services;
import com.launchacademy.partyplanner.models.Friend;
import com.launchacademy.partyplanner.repositories.FriendRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
  private FriendRepository friendRepository;

  @Autowired
  public FriendService(FriendRepository friendRepository) {
    this.friendRepository = friendRepository;
  }

  public List<Friend> findAll() {
    return (List<Friend>) friendRepository.findByOrderByFirstName();
  }

  public void add(Friend friend) {
    friendRepository.save(friend);
  }
}
