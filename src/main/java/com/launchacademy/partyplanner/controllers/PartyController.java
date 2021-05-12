package com.launchacademy.partyplanner.controllers;

import com.launchacademy.partyplanner.models.Party;
import com.launchacademy.partyplanner.repositories.PartyRepository;
import com.launchacademy.partyplanner.services.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping
public class PartyController {

  private PartyService partyService;

  @Autowired
  public PartyController(PartyService partyService) {
    this.partyService = partyService;
  }

  @GetMapping
  public String root() {
    return "redirect:/parties";
  }

  @GetMapping("/parties")
  public String getPartyList(Model model) {
    model.addAttribute("parties", this.partyService.findAll());
    return "parties/index";
  }

  @GetMapping("/parties/show/{id}")
  public String showParty(@PathVariable Integer id, Model model) {
    model.addAttribute("party", partyService.findById(id));
    return "parties/show";
  }

  @GetMapping("/parties/new")
  public String newParty(@ModelAttribute("party") Party party){
    return "parties/new";
  }

  @PostMapping("/parties")
  public String addParty(@ModelAttribute("party") Party party) {
    this.partyService.add(party);
    return "redirect:/parties/show/" + party.getId();
  }
}