package com.subscription.domain.animal.port;

import com.subscription.domain.animal.model.Animal;

public interface AnimalAccessPort {

    void createLostAnimal(Animal animal);
}
