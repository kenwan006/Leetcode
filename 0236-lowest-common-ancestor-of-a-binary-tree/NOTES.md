Recursion and the base case is:
- if p or q is the same as root, then return the root;
- else get the return value to the left tree and to the right tree.
- If both left tree and right tree are not null, then their lowest common ancestor would be the root.
- If only one is null then return the other one.