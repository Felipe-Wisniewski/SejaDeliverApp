package br.com.flmwg.provadeliver.model;

import java.util.ArrayList;

/**
 * Classe responsável pelo cálculo do subconjunto em que a soma dos elementos são de máxima soma.
 * @author Felipe Wisniewski
 */
public class Subset {

    private ArrayList<Integer> set;

    public Subset(ArrayList<Integer> set) {
        this.set = set;
    }

    private Integer[] maxSum() {
        if (set.isEmpty() || set.size() < 3) {
            return new Integer[]{0,0,0};
        }

        int tempStart = 0,
                startIndex = 0,
                endIndex = 0,
                currentSum = set.get(0),
                maxSum = set.get(0);

        for (int i = 1; i < set.size(); i++) {
            currentSum += set.get(i);

            if (set.get(i) > currentSum) {
                currentSum = set.get(i);
                tempStart = i;
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                startIndex = tempStart;
                endIndex = i;
            }
        }
        return new Integer[]{startIndex, endIndex, maxSum};
    }

    public ArrayList<String> subsetMaxSum() {
        ArrayList<String> subset = new ArrayList<>();
        Integer[] resultMaxSum = maxSum();
        int star = resultMaxSum[0], end = resultMaxSum[1], total = resultMaxSum[2];

        if (total <= 0) {
            subset.add("Conjunto NULO ou VAZIO");
        }else {
            for (int i = 0; i < set.size(); i++) {
                if (i == star) {
                    subset.add(i, "**" + set.get(i).toString());
                }else if (i == end) {
                    subset.add(i, set.get(i).toString() + "**");
                }else {
                    subset.add(i, set.get(i).toString());
                }
            }
        }
        return subset;
    }
}
