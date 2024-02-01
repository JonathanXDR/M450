package ch.tbz.m450.util;

import ch.tbz.m450.repository.Address;

import java.util.Comparator;

public class AddressComparator implements Comparator<Address> {
    @Override
    public int compare(Address a1, Address a2) {
        int lastNameComparison = a1.getLastname().compareTo(a2.getLastname());
        if (lastNameComparison != 0) {
            return lastNameComparison;
        }

        return a1.getId() - a2.getId();
    }
}

