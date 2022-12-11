# [The State Of Wakanda - 1 [Easy]](https://www.pepcoding.com/resources/online-java-foundation/2d-arrays/wakanda-1-official/ojquestion)

The historic state of Wakanda has various monuments and souvenirs which are visited by many travelers every day. The guides follow a prescribed route of visiting the monuments which improve them understand the relevance of each monument. 

The route of the monument is fixed and expressed in a 2-d matrix where the travelers visit the prescribed next monument. For example

1  2  3
4  5  6
7  8  9

is the prescribed route and the visitors travels this path: 1->2->3->4->5->6->7->8->9

However, a certain visitor decides to travel a different path as follows: 
1. He first travels southwards till no further south places are available.
2. He then moves only 1 place eastwards.
3. He starts to move again towards north till any further north moves are available. 
This continues till all the places are covered. 

For example, the monuments are named as follows:
1  2  3
4  5  6
7  8  9

Path followed by traveler: 1->4->7->8->5->2->3->6->9

You are required to print the path that this traveler follows to visit all places.

1. You will be given a number n, representing the number of rows.
2. You will be given a number m, representing the number of columns.
3. You will be given n*m numbers, representing elements of 2d arrays.

Note - Please check the output format for details.

## Constraints
- 1 <= n <= 10^2
- 1 <= m <= 10^2
- -10^9 <= e1, e2, .. n * m elements <= 10^9

## Format

### Input:

![image](https://user-images.githubusercontent.com/97858274/206899533-cc46430b-1f54-4f7f-bbf4-27a58dd5b128.png)


### Output:

![image](https://user-images.githubusercontent.com/97858274/206899554-c95df480-f6d7-48ff-8870-128cad079eb3.png)











