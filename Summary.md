# 一本糊涂账（hutubill）项目总结
>本项目基于java学习网站how2j的j2se实践项目[一本糊涂账](https://how2j.cn/k/hutubill/hutubill-tutorials/710.html?p=115680)，在原有基础上添加了查看消费记录详情和编辑的功能。仅作为学习练手项目使用。

本人在原项目基础上添加了查看消费详情的新功能，这里放上[源码](https://github.com/wtychn/hutubill)链接，下面对消费详情部分进行总结
## 整体思路
创建一个`DetailPanel`面板用来显示消费详情，在编辑键上添加一个新的`EditFrame`用来编辑选定的记录
## DetailPanel
### 布局
该面板布局分为上中下三个部分，上部放置筛选按钮和分类选择框，中部放置表格，下部放置编辑和删除按钮。
### 实现思路
#### 表格
消费详情显示表格内容需要新建一个`DetailTableModel`，内容直接从数据库record表中查得,并在`updateData`方法中将记录按照时间顺序进行排序
#### 分类选择框
分类选择框内容直接与`CategoryComboBoxModel`连接，无需过多更改。为实现分类选择效果，这里新建`DetailService`来实现全部查找和分类查找两个方法。之后在监听器`DetailListener`中设置标志位以区分筛选和选择全部两个按钮，在刷新方法`updateData`中监听标志位，在刷新时区分查表方法。
#### 编辑和删除按钮  
下方的删除按键直接在监听器中调用`DetailService`中的删除方法即可，而编辑按钮则直接打开`EditFrame`。
## EditFrame
### 布局
该布局参考`SpendPanel`,分为上下两部分，上部用四行两列的方式进行布局，下部放置确定、取消按钮。
### 实现思路
实现思路也与`SpendPanel`相似，不同之处在于编辑界面默认显示要与选定记录相同，且确定键的监听器`EditListener`的内容为更新。需要注意的是该面板默认显示内容需要与选定的记录相同，在`resetInput`方法中进行。因为种类也需要与所选记录一致，所以还需要在每次更新时对下拉框中的种类根据id进行排序，以保证在`JComboBox`的`setSelectedIndex`下可以选中与原记录相同的种类。
## 最后效果
项目已打成jar包，编写bat文件以快速启动，在`classes`目录中