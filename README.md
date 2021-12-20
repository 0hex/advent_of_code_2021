# Advent of Code 2021

![Java CI with Maven](https://github.com/0hex/advent_of_code_2021/workflows/Maven%20CI/badge.svg)

[My](https://github.com/0hex) participation in the 2021 edition of [Advent of Code](https://adventofcode.com/2021/).

To code the solution for a new puzzle, please use the following command, remembering to set the desired `DAY`:
```bash
DAY=0 mvn archetype:generate \
  -DarchetypeGroupId=com.nohex.aoc \
  -DarchetypeArtifactId=maven-archetype \
  -DarchetypeVersion=1.0.0 \
  -DgroupId=com.nohex.aoc \
  -Dversion=2021.0-SNAPSHOT \
  -DartifactId=day${DAY} \
  -DinteractiveMode=false
```
