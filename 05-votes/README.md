# Votes

A `Votes` object wraps a String of ballots, one character per ballot.

- `'A'`, `'B'`, and `'C'` are votes for candidates A, B, and C.
- Any other character, lowercase included, is a spoiled ballot. It stays in the String but every method ignores it.

## Methods

1. **`Votes(String ballots)`** throws `IllegalArgumentException` if `ballots` is null or contains zero real votes.
2. **`countFor(char c)`** returns the number of votes `c` received, or 0 if `c` is not `A`, `B`, or `C`.
3. **`candidates()`** returns a `Set<Character>` of every candidate with at least one vote.

## Examples

| Code | Result |
|---|---|
| `new Votes(null)`, `new Votes("")`, `new Votes("xyz-")`, `new Votes("cab")` | throw |
| `new Votes("A")`, `new Votes("AABxC-A")` | accepted |
| `countFor('A')` on `"AABxC-A"` | `3` |
| `countFor('Z')` on `"AABxC-A"` | `0` |
| `candidates()` on `"AABxC-A"` | `{A, B, C}` |
| `candidates()` on `"BB"` | `{B}` |
