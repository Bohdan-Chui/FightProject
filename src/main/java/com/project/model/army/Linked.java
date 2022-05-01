package com.project.model.army;

import com.project.model.army.impl.Solder;

public interface Linked {

    void setBehind(Solder enemy);

    Solder getBehind();
}

