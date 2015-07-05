# longpowerset

LongPowerSet efficiently generates a power set of a given set. Its memory usage is O(n) where n is the number of elements in the set. Each element of the set is generated on demand while iterating through the set. It uses a long underneath the covers, so it can generate a power set for a set with up to 63 elements.

## Usage

```
Set<Set<String>> powerSet = LongPowerSet.create(new HashSet<>(Arrays.asList("a", "b", "c")));
for (Set<String> subset : powerSet) {
  // Do something with each subset of the powerset...
}
```
