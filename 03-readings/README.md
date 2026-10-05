# Readings

A `Readings` object wraps an `int[]` of sensor readings.

| Value | Meaning | Handling |
|---|---|---|
| `-999` | sensor error (junk) | skipped everywhere, never range-checked |
| `-50` to `50` | real reading | kept |
| anything else | illegal | the constructor throws |

## Methods

1. **`Readings(int[] values)`** throws `IllegalArgumentException` if `values` is null, if it has zero real readings, or if any real reading is below -50 or above 50.
2. **`validReadings()`** returns a new `int[]` of the real readings in their original order.
3. **`distinctReadings()`** returns a `Set<Integer>` of the distinct real readings.

## Examples

| Code | Result |
|---|---|
| `new Readings(null)`, `new Readings({})`, `new Readings({-999, -999})` | throw |
| `new Readings({20, 80})`, `new Readings({20, -51})` | throw (out of range) |
| `new Readings({50})`, `new Readings({-50, -999})` | accepted |

With `{20, -999, 25, 20}`: `validReadings()` is `[20, 25, 20]` and `distinctReadings()` is `{20, 25}`.
