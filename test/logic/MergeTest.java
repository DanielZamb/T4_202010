package model.logic;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTest {
    private Integer[] random,sorted,inverted;
    public MergeTest(){}
    private void setupRandom(){
        random = new Integer[60];
        for (int i = 0; i<=random.length-1;i++)
            random[i] = StdRandom.uniform(560,1546520);
    }
    private void setupSorted(){
        sorted = new Integer[60];
        for (int i = 0 ; i<=sorted.length-1;i++)
            sorted[i] = i+1;
    }
    private void setupInverted(){
        inverted = new Integer[60];
        for(int i = inverted.length-1 ;i>-1;i--){
            inverted[(inverted.length-1)-i] = i;
        }
    }
    @Test
    public void sortTestRandom() {
        setupRandom();
        Merge.sort(random);
        int mayor = random[StdRandom.uniform(30,59)];
        int menor = random[StdRandom.uniform(0,29)];
        boolean comp = mayor > menor;
        assertTrue(comp);
    }
    @Test
    public void sortTestSorted(){
        setupSorted();
        Merge.sort(sorted);
        int mayor = sorted[StdRandom.uniform(30,59)];
        int menor = sorted[StdRandom.uniform(0,29)];
        boolean comp = mayor > menor;
        assertTrue(comp);
    }
    @Test
    public void sortTestInverted(){
        setupInverted();
        Merge.sort(inverted);
        int mayor = inverted[StdRandom.uniform(30,59)];
        int menor = inverted[StdRandom.uniform(0,29)];
        boolean comp = mayor > menor;
        assertTrue(comp);
    }
}