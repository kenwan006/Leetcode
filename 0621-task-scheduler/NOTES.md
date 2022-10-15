(I)For example we have to arrange the taks 3A, 2B, 1C, the idle time is n =2.
1. Arrange the task A because it has the most frequency fmax = 3
A ? ? A ? ? A
The task A would seperate the slots into (fmax -1) = 2 parts and each part has n = 2 slots available (Note: each part has at least n slots, in this case which is >=2)
2. Fill the slots with task B
A B ? A B ? A     each part has1 empty slot left
3. Fill the slots with task C
A B C A B ?A      1 slot left after this step
In this example, the total time needed is tasks.length + idle = 6 + 1 = 7

(II)What if we have more than 2 tasks with the most frequency ? The answer is for the second one we only need fmax -1 idle slots. For example, we have to arrange the taks 3A, 3B, 1C, the idle time is n =2
1. A  ?   ?   A  ?   ?  A       each part has 2 empty slots left, the total is 4.
2. (AB)  ?  (AB)  ?  (AB)   just put the last B behind A, and see A and B as an integrated task AB, then each part has 1 empty slot left, the total is 2
3.  (AB)  C  (AB) ?  (AB)   fill the task C and we have 1 empty slot left.
In this example, the total time needed is tasks.length + idle = 7 + 1 = 8


(III) What if each part (between two As) does not have enough space to include the new task ?  Answer is expand the capacity accordingly.
For example, we have the tasks 3A, 2B, 2C, 1D, n= 2
1. A  ?  ?   A   ?  ?  A   each part has 2 empty slots
2. A  B  ?   A  B  ?  A   each part has 1 empty slot left
3. A  B  C  A  B  C  A   no empty slot left but we still need to arrange taks D
