MAX= 2^31-1 = 2,147,483,647
MIN = -2^31 = - 2,147,483,648
​
When total = 214748364, if digit > 7, sign = 1, return MAX;
When total = 214748364, if digit = 7, sign = 1, return total * 10 + digit ( equals to MAX);
When total = 214748364, if digit > 7, sign = -1, return MIN;
​