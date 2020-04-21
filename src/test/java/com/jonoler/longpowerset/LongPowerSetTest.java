package com.jonoler.longpowerset;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class LongPowerSetTest {
  @Test
  public void testEmptyPowerSetHasOneEmptySubset() {
    LongSet<Set<String>> powerSet = LongPowerSet.create(new HashSet<>());
    assertEquals(1, powerSet.longSize(), "expect one empty subset in the power set of the empty set");
    assertFalse(powerSet.isEmpty(), "expect power set of the empty set to be non-empty");
    assertEquals(0, powerSet.iterator().next().size(), "expect one empty subset in the power set of the empty set");
    assertTrue(powerSet.contains(Collections.emptySet()), "expect power set of the empty set contains the empty set");
    assertEquals(LongPowerSet.create(new HashSet<>()), powerSet, "expect empty power sets to be equal");
    Set<Set<String>> constructedSet = new HashSet<>();
    for (Set<String> subset : powerSet) {
      constructedSet.add(subset);
    }
    Set<String> emptySet = Collections.emptySet();
    Set<Set<String>> expectedSet = new HashSet<>(Arrays.asList(emptySet));
    assertEquals(expectedSet, constructedSet, "expect iterated contents of power set to be correct");
  }

  @Test
  public void testPowerSetOfSingleElementHasCorrectSubsets() {
    LongSet<Set<String>> powerSet = LongPowerSet.create(new HashSet<>(Arrays.asList("a")));
    assertEquals(2, powerSet.longSize(), "expect one empty subset and one one element subset in the power set of a single element set");
    assertTrue(powerSet.contains(Collections.emptySet()), "expect empty subset to be contained in power set of single element set");
    assertTrue(powerSet.contains(new HashSet<>(Arrays.asList("a"))),
        "expect single element subset to be contained in power set of single element set");
    Set<Set<String>> constructedSet = new HashSet<>();
    for (Set<String> subset : powerSet) {
      constructedSet.add(subset);
    }
    Set<String> emptySet = Collections.emptySet();
    Set<String> singleElementSet = Collections.singleton("a");
    Set<Set<String>> expectedSet = new HashSet<>(Arrays.asList(emptySet, singleElementSet));
    assertEquals(expectedSet, constructedSet, "expect iterated contents of power set to be correct");
  }

  @Test
  public void testPowerSetOfThreeElementsHasCorrectSubsets() {
    LongSet<Set<String>> powerSet = LongPowerSet.create(new HashSet<>(Arrays.asList("a", "b", "c")));
    assertEquals(8, powerSet.longSize(), "expect 8 subsets in the power set of a 3 element set");
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
    assertEquals(expectedSet, constructedSet, "expect iterated contents of power set to be correct");
    assertTrue(powerSet.containsAll(expectedSet), "expect power set to contain correct subsets");
  }
}
