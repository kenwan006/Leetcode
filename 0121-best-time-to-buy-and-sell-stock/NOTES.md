1. The sell  is always after the buy , so every time we update buy price (finding the smaller buy price), we have to reset the sell price and find the max sell price after that.
2. Everytime we check the stock we have to calcualte the current profit to see if we have to update the max profit.
3. We can use three pointers to keep track of buy price, sell price and max profit.