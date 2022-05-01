package com.project.model.weapon;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weapon {

    private int health;
    private int attack;
    private int defense;
    private int vampirism;
    private int healPower;

}
