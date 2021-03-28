package com.tnc.luggage.interfaces;

import com.tnc.luggage.model.Box;
import com.tnc.luggage.model.Slot;

public interface AddAndSetObject {

    void addAndSetObject(Slot slot, Box box);
    void setObjectToNull(Slot slot);

}
