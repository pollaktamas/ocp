package com.pollaktamas.advancedclassdesign.enums;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapExample {

    public static void main(String[] args) {
        System.out.println(Phase.Transition.from(Phase.LIQUID, Phase.SOLID));
    }

    enum Phase {
        SOLID, LIQUID, GAS;

        enum Transition {
            MELT(SOLID, LIQUID), FREEZE(LIQUID, SOLID),
            BOIL(LIQUID, GAS), CONDENSE(GAS, LIQUID),
            SUBLIME(SOLID, GAS), DEPOSIT(GAS, SOLID);
            final Phase src;
            final Phase dst;

            Transition(Phase src, Phase dst) {
                this.src = src;
                this.dst = dst;
            }

            // Initialize the phase transition map
            private static final Map<Phase, Map<Phase, Transition>> m =
                    new EnumMap<Phase, Map<Phase, Transition>>(Phase.class);

            static {
                for (Phase p : Phase.values())
                    m.put(p, new EnumMap<Phase, Transition>(Phase.class));
                for (Transition trans : Transition.values())
                    m.get(trans.src).put(trans.dst, trans);
            }

            public static Transition from(Phase src, Phase dst) {
                return m.get(src).get(dst);
            }
        }
    }
}