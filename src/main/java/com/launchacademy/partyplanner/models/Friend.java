package com.launchacademy.partyplanner.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name="friends")
@Entity
public class Friend {
  @Id
  @SequenceGenerator(name="friends_generator",
      sequenceName="friends_id_seq", allocationSize = 1)
  @GeneratedValue(strategy= GenerationType.SEQUENCE,
      generator="friends_generator")
  @Column(name="id", nullable=false, unique=true)
  private Integer id;

  @NotEmpty
  @Column(name="first_name", nullable=false)
  private String firstName;

  @NotEmpty
  @Column(name="last_name", nullable = false)
  private String lastName;
}
