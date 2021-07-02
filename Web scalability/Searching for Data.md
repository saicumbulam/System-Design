- Once we have a index, we can perform binary search
- **Cardinality** is a number of unique values stored in a particular field. Fields with high cardinality are good candidates for indexes, as they allow you to reduce the data set to a very small number of rows.
- The reason why low-cardinality fields are bad candidates for indexes is that they do not narrow down the search enough

**Two rules of indexes**
- The first rule of thumb when creating indexes on a data set is that the higher the cardinality
- creating indexes is that equal distribution leads to better index performance.
- 