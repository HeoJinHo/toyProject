package com.web.board.entity.item;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("A")
public class Alubum extends Item{

    private String artist;

    private String etc;

}
