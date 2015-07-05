package com.jonoler.longpowerset;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class LongPowerSetTest {
  @Test
  public void testEmptyPowerSetHasOneEmptySubset() {
    LongSet<Set<String>> powerSet = LongPowerSet.create(new HashSet<>());
    assertEquals("expect one empty subset in the power set of the empty set", 1, powerSet.longSize());
    assertFalse("expect power set of the empty set to be non-empty", powerSet.isEmpty());
    assertEquals("expect one empty subset in the power set of the empty set", 0, powerSet.iterator().next().size());
    assertTrue("expect power set of the empty set contains the empty set", powerSet.contains(Collections.emptySet()));
    assertEquals("expect empty power sets to be equal", LongPowerSet.create(new HashSet<>()), powerSet);
    Set<Set<String>> constructedSet = new HashSet<>();
    for (Set<String> subset : powerSet) {
      constructedSet.add(subset);
    }
    Set<String> emptySet = Collections.emptySet();
    Set<Set<String>> expectedSet = new HashSet<>(Arrays.asList(emptySet));
    assertEquals("expect iterated contents of power set to be correct", expectedSet, constructedSet);
  }

  @Test
  public void testPowerSetOfSingleElementHasCorrectSubsets() {
    LongSet<Set<String>> powerSet = LongPowerSet.create(new HashSet<>(Arrays.asList("a")));
    assertEquals("expect one empty subset and one one element subset in the power set of a single element set", 2, powerSet.longSize());
    assertTrue("expect empty subset to be contained in power set of single element set", powerSet.contains(Collections.emptySet()));
    assertTrue("expect single element subset to be contained in power set of single element set",
        powerSet.contains(new HashSet<>(Arrays.asList("a"))));
    Set<Set<String>> constructedSet = new HashSet<>();
    for (Set<String> subset : powerSet) {
      constructedSet.add(subset);
    }
    Set<String> emptySet = Collections.emptySet();
    Set<String> singleElementSet = Collections.singleton("a");
    Set<Set<String>> expectedSet = new HashSet<>(Arrays.asList(emptySet, singleElementSet));
    assertEquals("expect iterated contents of power set to be correct", expectedSet, constructedSet);
  }

  @Test
  public void testPowerSetOfThreeElementsHasCorrectSubsets() {
    LongSet<Set<String>> powerSet = LongPowerSet.create(new HashSet<>(Arrays.asList("a", "b", "c")));
    assertEquals("expect 8 subsets in the power set of a 3 element set", 8, powerSet.longSize());
    Set<Set<String>> constructedSet = new HashSet<>();
    for (Set<String> subset : powerSet) {
      constructedSet.add(subset);
    }
    Set<String> emptySet = Collections.emptySet();
    Set<String> singleElementSet1 = Collections.singleton("a");
    Set<String> singleElementSet2 = Collections.singleton("b");
    Set<String> singleElementSet3 = Collections.singleton("c");
    Set<String> twoElementSet1 = new HashSet<>(Arrays.asList("a", "b"));
    Set<String> twoElementSet2 = new HashSet<>(Arrays.asList("a", "c"));
    Set<String> twoElementSet3 = new HashSet<>(Arrays.asList("b", "c"));
    Set<String> threeElementSet = new HashSet<>(Arrays.asList("a", "b", "c"));
    Set<Set<String>> expectedSet = new HashSet<>(Arrays.asList(emptySet, singleElementSet1, singleElementSet2,
        singleElementSet3, twoElementSet1, twoElementSet2, twoElementSet3, threeElementSet));
    assertEquals("expect iterated contents of power set to be correct", expectedSet, constructedSet);
    assertTrue("expect power set to contain correct subsets", powerSet.containsAll(expectedSet));
  }
}
