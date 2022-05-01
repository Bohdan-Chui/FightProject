package com.project.model.enemy;

import com.project.model.enemy.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

public class EnemyFactory {

    private final Map<String, Supplier<Enemy>> fighters = new HashMap<>();

    public EnemyFactory() {
        fighters.put("warrior", Warrior::new);
        fighters.put("knight", Knight::new);
        fighters.put("rookie", Rookie::new);
        fighters.put("defender", Defender::new);
        fighters.put("vampire", Vampire::new);
        fighters.put("lancer", Lancer::new);
        fighters.put("healer", Healer::new);
    }

    public Enemy of(String name) {
        Enemy enemy = fighters.get(name).get();
        if (enemy == null)
            throw new NoSuchElementException("No fighter with name - " + name);
        return enemy;
    }
}
