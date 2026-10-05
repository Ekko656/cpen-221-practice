# DNA

A `DNA` object wraps a nucleotide sequence given as a String.

- The nucleotides are `A`, `C`, `G`, and `T`.
- Any other character is junk. Junk stays in the sequence but is ignored when counting nucleotides or splitting into codons.
- A codon is a group of three consecutive nucleotides, junk skipped. `"ACGT-!BAG"` contains the codons `"ACG"` and `"TAG"`.

## Methods

1. **`DNA(String sequence)`** throws `IllegalArgumentException` if `sequence` is null, or if the number of nucleotides is zero or not a multiple of three.
2. **`nucleotideCount(char c)`** returns how many times `c` occurs, or 0 if `c` is not `A`, `C`, `G`, or `T`.
3. **`codonSet()`** returns a `Set<String>` of the distinct codons.

## Examples

| Code | Result |
|---|---|
| `new DNA("ATCGAA")`, `new DNA("ACGT-!BAG")` | accepted |
| `new DNA("ACGT")`, `new DNA("---")`, `new DNA("ATCGAxbTTz")`, `new DNA(null)` | throw |
| `nucleotideCount('A')` on `"ATCGAA"` | `3` |
| `nucleotideCount('X')` on `"ATCGAA"` | `0` |
| `codonSet()` on `"ATCGAA"` | `{ATC, GAA}` |
| `codonSet()` on `"ACGT-!BAG"` | `{ACG, TAG}` |
