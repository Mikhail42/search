package org.ionkin.search.map;

import javafx.util.Pair;
import org.ionkin.search.VariableByte;

import java.io.Serializable;

public class IntIntIntTranslator extends IntTranslator<Pair<Integer, Integer>> implements Serializable {

    @Override
    public byte[] serialize(Integer key, Pair<Integer, Integer> pair) {
        return VariableByte.compress(new int[] {key, pair.getKey(), pair.getValue()});
    }

    @Override
    public Pair<Integer, Integer> deserializeValue(byte[] packed) {
        int[] ar = VariableByte.uncompress(packed);
        return new Pair<>(ar[1], ar[2]);
    }
}
