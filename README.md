## 日志打印Kotlin扩展





### 添加gradle依赖：

Project build.gradle:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
Module build.gradle：

	dependencies {
	        implementation 'com.github.luohaolun:log:1.8'
	}


### 使用：

	123456.e()
	
	pe("12345")

	Thread{ "abcdef".v() }.start()

	...
	
>打印（显示线程名 可点击跳转到日志输出位置）

	12-29 10:41:20.905 16579-16579/k.lhl.test E/main(MainActivity.kt:15): 123456
	12-29 10:41:20.906 16579-16704/k.lhl.test V/Thread-4(MainActivity.kt:17): abcdef


>分段打印

	"123456789".e(4)  // 4 最大打印长度，默认3900
	
	// 设置默认长度
	setLogMaxLength(4000)


 
  
   
    
     
     
---
## 系统默认样式对话框


### 提示对话框TDialog：


>普通

	TDialog(this, "消息内容").show()	//or
	TDialog("消息内容").show()
	


>设置确定按钮事件

	TDialog(this, "消息内容"){ "点击确定".toast() }     //or
	TDialog("消息内容"){ "点击确定".toastLong() }
	
	
	
>设置确定与取消按钮事件

	TDialog("消息内容").setButtons({ "点击确定".toast() }) { "点击取消".toast() }
	
	
 
 
 
 
 
 

### 等待对话框PDialog：

	val pDialog = PDialog(this, "正在上传..") { "取消上传".toast() }	//or
	val pDialog = PDialog("正在上传..").show()
	
	
	
	
	
	
	
	
---
## View类常用扩展


>单击（已处理连续点击）

	view.click { "点击事件".toast() }
	
>长按

	view.longClick { "长按事件".toast() }
	
>显隐
	
	view.visible = true  // or false


---
## 其他
	123.dp() 	// 数字转换DP
	123.45.kp(1)	// 保留1位小数 123.5
