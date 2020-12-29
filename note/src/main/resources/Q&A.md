# 程序员代码面试指南

## 栈和队列

### 设计一个有 getMin 功能的栈
>【题目】  
> 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。  
>【要求】  
> 1．pop、push、getMin 操作的时间复杂度都是 O(1)。  
> 2．设计的栈类型可以使用现成的栈结构。  
>【题解】  
> 双栈法，维护一个数据栈和一个最小栈  
>【leetcode】155

### 由两个栈组成的队列
>【题目】  
> 编写一个类，用两个栈实现队列，支持队列的基本操作（add、poll、peek）。  
>【题解】  
> push只需要往stack1中放  
> pop的时候检查stack2是否为空，要是为空则把stack1所有元素出栈并入栈到stack2
>【剑指offer09]