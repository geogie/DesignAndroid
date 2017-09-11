## dataBinding Lambda font ##
 1. activity中bind，不用find，根据xxx_yy --> XxxYyBinding。类似于vue和react驼峰式生成标签属性。布局中layout为根,data-variable变量实现view-data双向绑定
 2. adapter中实现bind，hold中的bind负责数据填充，android:text="@{product.price}",fragment中binding使用
 3. GradientDrawable的drawable修改颜色，创建一个drawable模型生成不同颜色不通高度的drawable作为背景。间接实现item不同的高度。
 4. model中Arrays.asList使用，Serializable实现data-view
 5. recycler的item的PaddingDecoration自定义。
 6. recycler的item的OnItemSelectedListener自定义
 7. BottomSheetDialogFragment使用
 8. ViewSwitcher两个view切换：比如完成一个view然后切换下一步
 9. Guideline使用:标准线，以这个目标来设置其它view位置
 10. LayerDrawable使用，背景、图片层次感。
 11. [参考](https://github.com/saulmm/From-design-to-Android-part1)
