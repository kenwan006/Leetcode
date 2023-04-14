We ought to define a delimiter to separate words within the list, however, any character delimiter can be part of the original word. Thus, we use lengthOfStr + '/' to delimit a word.
Take ["a/b", "c"] for example, the encoded word is s = "3/a/b1/c".
​
To encode s, we keep track of the position of startIndex - it starts from a 'number' and a '/', which is the length and delimiter for the first string.