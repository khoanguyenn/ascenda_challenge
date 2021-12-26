# Introduction
This repository provides a possible solution for the problem [SALES TAXES](https://gist.github.com/longkt90/4d7b755b52560431fc16be4aa8b8a3f5) mentioned by [longkt90](https://gist.github.com/longkt90). The provided solution implements three design patterns, aiming to apply taxes to the listed items of `Receipt`, then print into various formats.
- `Builder` instantiates the Item, and apply tax to the item.
- `Decorator` structure how Item and Tax behavior in run-time.
- `Strategy` provides formatter for the `Receipt`, which print out all of the item, tax, total price.
## Problems summary
- Receipt should be printed out in standard or CSV.
- 5% for imported tax, 10% tax basic on all goods, except books, food, and medical products.
- Item's price after taxes is rounded up to the nearst 0.05.
## Analysis
1. To make the `Receipt` can be printed in many other formats (standard, CSV, JSON, XML, ...), the formatter must be injected to the `Receipt` and only interact via a `FormatStrategy` interface to lose coupling. The best pratice is to ultilize `Strategy` pattern to dynamically inject Formats to the `Receipt` object for different purposes at compile time.
2. Taxes are applied in any order to items, but except books, food, and medical products. However, there are two sub-problems on this puzzle.
   - Firstly, the taxes can be applied in any order, which makes the item behaves differently. Hence, it's a good pratice to use `Decorator` pattern, since this pattern solves the additional behaviour recursively by delegating the calls from outer taxes to the core item.
   - Secondly, it's difficulty to tell which item is a tax-free or imported item later on. We could count on "imported" keyword in item's name, but it's better to state the item type and its import status explicitly. Moreover, not all of the item metadate are needed, some could have default variables. Thus, to solve the mentioned problem, creational pattern `Builder` should be ultilized to instantiate, validate the `Item` object and apply taxes when build the `Item`. 
3. Rounding rule to the nearst 0.05 is solved by the formula `CEIL((number  / 0.05) * 0.05)`.