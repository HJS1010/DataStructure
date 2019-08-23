# 动态数组
>数组的容量动态变化的，不是固定的不变的
> 随着数组元素的增加，动态扩容
> 随着数组元素的减小，动态缩容

## 动态数组设计思路
1.内部使用数组来存储数据
2.构造方法中传入capacity，代表初始化数组的容量
3.使用 size 代表数组中存储的元素个数
4.size 为0时，数组为空；
5.size 不为0时，从数组尾部插入元素时，size 代表下一个元素插入的位置
6.先实现一个简单的，可以存储 int 类型元素的数组
7.依次实现数组的元素增、删、改、查；
8.使用泛型
9.实现动态数组的特性
10.简单的复杂度分析
11.均摊复杂度和防止复杂度的震荡

## 动态数组的增、删、改、查
### 在 index 位置添加一个新的元素：

```java
public void add(int index, E e){
	if(index < 0 || index > size){
    throw new IllegalArgumentException("Add failed. Illegal index.");
  }
  if(size == data.length){
   	resize(2*data.length); 
  }
  for(int i = size - 1; i >= index; i--){
    data[i + 1] = data[i];
  }
  data[index] = e;
  size++;
}
```



### 删除 index 位置的元素，并返回删除的元素

```java
public E remove(int index){
	if(index < 0 || index >= size){
   	throw new IllegalArgumentException("Remove failed. Illegal index."); 
  }
  E ret = data[index];
  for(int i = index + 1; i < size; i++){
   	data[i - 1] = data[i]; 
  }
  size--;
  data[size] = null;
  
  if(size == data.length / 4 && data.length / 2 != 0){
   	resize(data.length / 2); 
  }
  
  return ret;
}
```

