package com.techelevator.constructs.model;

import java.util.ArrayList;
import java.util.List;

public class Row {

    private String name;
    private List<SlotLocation> slots;

    public Row(String name) {
        this.name = name;
        this.slots = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SlotLocation getSlot(String slotLocationName) {
        for (SlotLocation slot : slots) {
            if (slot.getName().equals(slotLocationName)) {
                return slot;
            }
        }

        return new SlotLocation(slotLocationName);
    }

    public List<SlotLocation> getSlots() {
        return slots;
    }

    public void setSlots(List<SlotLocation> slots) {
        this.slots = slots;
    }

    public static List<SlotLocation> buildSlots(List<Item> items) {
        List<SlotLocation> slotLocations = new ArrayList<>();

        for (Item item : items) {
            SlotLocation slotLocation = new SlotLocation(item.getSlotLocation());
            slotLocation.load(item);
            slotLocations.add(slotLocation);
        }

        return slotLocations;
    }
}
