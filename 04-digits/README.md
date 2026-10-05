# Digits

A `Digits` object wraps a String like `"12-34 5678"`.

- The characters `'0'` to `'9'` are digits. Anything else is junk, kept in the String but ignored by every method.
- A group is four consecutive digits, junk skipped.

## Methods

1. **`Digits(String s)`** throws `IllegalArgumentException` if `s` is null, or if the number of digits is zero or not a multiple of four.
2. **`digitSum()`** returns the sum of all digits.
3. **`distinctGroups()`** returns a `Set<String>` of the distinct four-digit groups.

## Examples

| Code | Result |
|---|---|
| `new Digits(null)`, `new Digits("")`, `new Digits("--")`, `new Digits("123")`, `new Digits("12-345")` | throw |
| `new Digits("1234")`, `new Digits("12-34 5678")` | accepted |
| `digitSum()` on `"12-34 5678"` | `36` |
| `distinctGroups()` on `"12-34 5678"` | `{"1234", "5678"}` |
| `digitSum()` on `"1111-1111"` | `8` |
| `distinctGroups()` on `"1111-1111"` | `{"1111"}` |
