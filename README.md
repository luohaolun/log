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
	        implementation 'com.github.luohaolun:log:1.4'
	}


### 使用：

	123456.e()

	Thread{ "abcdef".v() }.start()

	...
	
>打印

	12-29 10:41:20.905 16579-16579/k.lhl.test E/main(MainActivity.kt:15): 123456
	12-29 10:41:20.906 16579-16704/k.lhl.test V/Thread-4(MainActivity.kt:17): abcdef


>分段打印

	"123456789".e(4)  // 4 最大打印长度，默认3900
	
	// 设置默认长度
	setLogMaxLength(4000)





