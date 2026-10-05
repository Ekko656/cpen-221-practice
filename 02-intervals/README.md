# Intervals

An `Intervals` object stores several number ranges in two arrays of the same length. Range `i` runs from `lower[i]` to `upper[i]`, inclusive.

## Methods

1. **`Intervals(int[] lower, int[] upper)`** throws `IllegalArgumentException` if either array is null or empty, if the arrays have different lengths, or if `lower[i] > upper[i]` for any `i`.
2. **`range(int i)`** returns an `int[]` holding every integer from `lower[i]` to `upper[i]`, in order. Requires a valid index.
3. **`singleIndices()`** returns a `Set<Integer>` of every index `i` where `lower[i] == upper[i]`.

## Examples

| Code | Result |
|---|---|
| `new Intervals(null, {1})` | throws |
| `new Intervals({}, {})` | throws |
| `new Intervals({1, 2}, {3})` | throws (different lengths) |
| `new Intervals({5}, {2})` | throws (5 > 2) |

With `lower = {2, 7, 4}` and `upper = {5, 7, 4}`:

| Code | Result |
|---|---|
| `range(0)` | `[2, 3, 4, 5]` |
| `range(1)` | `[7]` |
| `singleIndices()` | `{1, 2}` |
