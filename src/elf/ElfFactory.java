package elf;

import elf.color.BlackElf;
import elf.color.PinkElf;
import elf.color.WhiteElf;
import elf.color.YellowElf;
import enums.ElvesType;

public final class ElfFactory {
    /**
     * Hidden constructor.
     */
    private ElfFactory() { }

    /**
     * Determines what Elf to create based on the given type.
     * @param type the elf type
     * @return the created elf
     */
    public static Elf createElf(final ElvesType type) {
        return switch (type) {
            case YELLOW -> new YellowElf();
            case BLACK -> new BlackElf();
            case PINK -> new PinkElf();
            case WHITE -> new WhiteElf();
        };
    }
}
