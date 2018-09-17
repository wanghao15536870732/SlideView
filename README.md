# SlideView

<h1>  卡片式RecycleViewManager，让你的界面炫酷起来 </h1> 

### 界面演示
|SkidRightLayoutManager|EchelonLayoutManager|SlideLayoutManager|
|:--:|:--:|:--:|
|<div align="center"> <img src="https://github.com/wanghao15536870732/SlideView/blob/master/1.gif" height="502px" width="290px"/> |<div align="center"> <img src="https://github.com/wanghao15536870732/SlideView/blob/master/2.gif" height="502px" width="290px"/>|<div align="center"> <img src="https://github.com/wanghao15536870732/SlideView/blob/master/3.gif" height="502px" width="290px"/>|

</div>

### build.gradle中添加
```java
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io' }
    }
}
```
### 添加依赖
```java
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    //noinspection GradleCompatible
    implementation 'com.android.support:appcompat-v7:27.1.1'
    implementation 'com.android.support.constraint:constraint-layout:1.1.1'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'com.android.support.test:runner:1.0.2'
    androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
    
    
    //主要的是这个依赖
    implementation 'com.github.DingMouRen:LayoutManagerGroup:1e6f4f96eb'
    
    
    implementation 'com.android.support:cardview-v7:27.1.1'
    implementation 'com.github.bumptech.glide:glide:3.7.0'
    implementation 'com.android.support:design:27.1.1'
    implementation 'de.hdodenhof:circleimageview:2.2.0'
}
```
###  想要获取更多内容
### 请访问[DingMouRen’s LayoutManagerGroup](https://github.com/DingMouRen/LayoutManagerGroup)
