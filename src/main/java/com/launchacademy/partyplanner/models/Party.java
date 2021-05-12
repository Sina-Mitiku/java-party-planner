package com.launchacademy.partyplanner.models;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@Table(name="parties")
public class Party {

  @Id
  @SequenceGenerator(name="parties_generator",
      sequenceName="parties_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE,
      generator="parties_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotEmpty
  @Column(name="name", nullable=false)
  private String name;

  @Column(name="description", nullable = false)
  private String description;

  @Column(name="location", nullable = false)
  private String location;
}

