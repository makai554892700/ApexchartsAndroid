#shrink，测试后发现会将一些无效代码给移除，即没有被显示调用的代码，该选项 表示 不启用 shrink。
-dontshrink
#指定重新打包,所有包重命名,这个选项会进一步模糊包名，将包里的类混淆成n个再重新打包到一个个的package中
-flattenpackagehierarchy
#优化时允许访问并修改有修饰符的类和类的成员
-allowaccessmodification
#混淆前后的映射
-printmapping map.txt
#不跳过(混淆) jars中的 非public classes   默认选项
-dontskipnonpubliclibraryclassmembers
#忽略警告
-ignorewarnings
#指定代码的压缩级别
-optimizationpasses 5
#不使用大小写混合类名
-dontusemixedcaseclassnames
#不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
#不启用优化  不优化输入的类文件
-dontoptimize
#不预校验
-dontpreverify
#混淆时是否记录日志
-verbose
#混淆时所采用的算法
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*
#保护注解
-renamesourcefileattribute SourceFile
#保持源文件和行号的信息,用于混淆后定位错误位置
-keepattributes SourceFile,LineNumberTable
#保持含有Annotation字符串的 attributes
-keepattributes *Annotation*
-keepattributes Signature
-keepattributes Exceptions,InnerClasses

-dontwarn org.apache.**
-dontwarn android.support.**
#自定义View
-keep class android.webkit.**{*;}

#保持 任意包名.R类的类成员属性。  即保护R文件中的属性名不变
-keepclassmembers class **.R$* {
    public static <fields>;
}
#-------------------------------------------基础混淆 end--------------------------------------------
#--------------------------------------webview js交互 start-----------------------------------------
-keepattributes JavascriptInterface
-keep class android.webkit.JavascriptInterface {*;}
#--------------------------------------webview js交互 end-------------------------------------------
-keepattributes Signature




