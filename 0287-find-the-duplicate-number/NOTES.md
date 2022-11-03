/** Two pointer (Cycle detection)
* We can convert this problem to a cycle detection case and then use two pointer method
* For a nums[i], we say it stores the index j of the next num, j = nums[i], or we can say nums[i] points to nums[j], nums[j] = nums[nums[i]]. eg nums[2,5,9,6,9,3,8,9,7,1], nums[0] = 2, so we say nums[0] = 2 points to nums[2], nums[2]= 9, say it points to nums[9], and so on so forth, we have 2->9->1->5->3->6->8->7->9->1->5... we can find the cycle: 9->1->5->3->6->8->7->9
* Find intersection point: Use two pointer, slow and fast, slow moves 1 steps every time and fast moves 2 steps every time, stop until they meet;
* Find the entry point of the cycle, which should be the repeated number. fast starts at index 0 and slow starts at the meeting point, move them both at 1 step every time and until they meet. This new meeting point is the entry point. (See the **Tortoise and Hare** Algo for the proof)
*/